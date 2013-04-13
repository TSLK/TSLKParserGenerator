/*******************************************************************************
 * Copyright (c) 2013 Nick Guletskii.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Nick Guletskii - initial API and implementation
 ******************************************************************************/
package org.ng200.tslk.langgen;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.antlr.v4.Tool;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.misc.STMessage;

public class TSLKGenerator {

	public static void addToZip(File file, ZipOutputStream zipOutputStream)
			throws IOException {
		FileInputStream fileInput = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(file.getPath().replaceFirst(
				"src-gen/", ""));
		zipOutputStream.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fileInput.read(bytes)) >= 0) {
			zipOutputStream.write(bytes, 0, length);
		}
		zipOutputStream.closeEntry();
		fileInput.close();
	}

	public static void cleanup() {
		new File("TSLKGrammar.g4").delete();
	}

	private static void compile() throws IOException {
		final ArrayList<File> files = new ArrayList<File>();
		Path startPath = Paths.get("src-gen");
		Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.println(file);
				if (file.getFileName().toString().endsWith(".java"))
					files.add(file.toFile());
				return FileVisitResult.CONTINUE;
			}
		});
		System.out.println(files);
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				null, null, null);

		Iterable<? extends JavaFileObject> compilationUnits1 = fileManager
				.getJavaFileObjectsFromFiles(files);
		compiler.getTask(null, fileManager, null, null, null, compilationUnits1)
				.call();

		fileManager.close();
	}

	public static void createJar() throws IOException {
		FileOutputStream f = new FileOutputStream("TSLKTranslation.jar");
		final ZipOutputStream zip = new ZipOutputStream(
				new BufferedOutputStream(f));
		Path startPath = Paths.get("src-gen");
		Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				addToZip(file.toFile(), zip);
				return FileVisitResult.CONTINUE;
			}

		});
		zip.close();
	}

	public static void generateGrammar(String templateString,
			HashMap<String, String> modifiableFields) throws IOException {
		ST template = new ST(templateString);
		for (String s : modifiableFields.keySet())
			template.add(s, modifiableFields.get(s));

		template.write(new File("TSLKGrammar.g4"), new STErrorListener() {
			@Override
			public void compileTimeError(STMessage arg0) {
				System.err.println(arg0);
			}

			@Override
			public void internalError(STMessage arg0) {
				System.err.println(arg0);

			}

			@Override
			public void IOError(STMessage arg0) {
				System.err.println(arg0);
			}

			@Override
			public void runTimeError(STMessage arg0) {
				System.err.println(arg0);
			}
		});
	}

	public static void generateJavaSourcecode() {
		String[] toolArgs = { "-o", "src-gen/org/ng200/tslk/lang", "-package",
				"org.ng200.tslk.lang", "TSLKGrammar.g4" };
		Tool.main(toolArgs);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader templateReader = new BufferedReader(new FileReader(
				"src-grammar/TSLKGrammarTemplate.g4"));
		String line = null, templateString = "";
		while ((line = templateReader.readLine()) != null)
			templateString += line + "\n";
		templateReader.close();
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("src-grammar/defaultLanguage");
		defaultProps.load(in);
		in.close();
		Properties applicationProps = new Properties(defaultProps);
		in = new FileInputStream("src-grammar/customLanguage");
		applicationProps.load(in);
		in.close();
		HashMap<String, String> modifiableFields = new HashMap<String, String>();
		for (Object key : Collections.list(applicationProps.propertyNames()))
			modifiableFields.put(key.toString(),
					applicationProps.getProperty(key.toString()));
		generateGrammar(templateString, modifiableFields);
		generateJavaSourcecode();
		compile();
		createJar();
		cleanup();
	}

	public TSLKGenerator() {
	}
}
