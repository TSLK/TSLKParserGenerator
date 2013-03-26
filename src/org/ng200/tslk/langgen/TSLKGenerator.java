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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

import org.antlr.v4.Tool;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.misc.STMessage;

public class TSLKGenerator {

	public TSLKGenerator() {
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
	}

	public static void generateGrammar(String templateString,
			HashMap<String, String> modifiableFields) throws IOException {
		ST template = new ST(templateString);
		for (String s : modifiableFields.keySet())
			template.add(s, modifiableFields.get(s));

		template.write(new File("TSLKGrammar.g4"), new STErrorListener() {
			@Override
			public void runTimeError(STMessage arg0) {
				System.err.println(arg0);
			}

			@Override
			public void internalError(STMessage arg0) {
				System.err.println(arg0);

			}

			@Override
			public void compileTimeError(STMessage arg0) {
				System.err.println(arg0);
			}

			@Override
			public void IOError(STMessage arg0) {
				System.err.println(arg0);
			}
		});
	}

	public static void generateJavaSourcecode() {
		String[] toolArgs = { "-o", "src-gen/org/ng200/tslk/lang", "-package",
				"org.ng200.tslk.lang", "TSLKGrammar.g4" };
		Tool.main(toolArgs);
	}

	public static void cleanup() {
		new File("TSLKGrammar.g4").delete();
	}
}
