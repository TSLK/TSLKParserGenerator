// Generated from TSLKGrammar.g4 by ANTLR 4.0
package org.ng200.tslk.lang;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface TSLKGrammarListener extends ParseTreeListener {
	void enterAssignExpr(TSLKGrammarParser.AssignExprContext ctx);

	void enterAtomBooleanFalse(TSLKGrammarParser.AtomBooleanFalseContext ctx);

	void enterAtomBooleanTrue(TSLKGrammarParser.AtomBooleanTrueContext ctx);

	void enterAtomNumber(TSLKGrammarParser.AtomNumberContext ctx);

	void enterAtomString(TSLKGrammarParser.AtomStringContext ctx);

	void enterBinaryOperator(TSLKGrammarParser.BinaryOperatorContext ctx);

	void enterBody(TSLKGrammarParser.BodyContext ctx);

	void enterBreakStmt(TSLKGrammarParser.BreakStmtContext ctx);

	void enterContinueStmt(TSLKGrammarParser.ContinueStmtContext ctx);

	void enterDynamicChildCall(TSLKGrammarParser.DynamicChildCallContext ctx);

	void enterForBlock(TSLKGrammarParser.ForBlockContext ctx);

	void enterFuncBlock(TSLKGrammarParser.FuncBlockContext ctx);

	void enterFuncCall(TSLKGrammarParser.FuncCallContext ctx);

	void enterIfBlock(TSLKGrammarParser.IfBlockContext ctx);

	void enterLocalAssignExpr(TSLKGrammarParser.LocalAssignExprContext ctx);

	void enterModifyExpr(TSLKGrammarParser.ModifyExprContext ctx);

	void enterNormalStmt(TSLKGrammarParser.NormalStmtContext ctx);

	void enterPathCall(TSLKGrammarParser.PathCallContext ctx);

	void enterReturnStmt(TSLKGrammarParser.ReturnStmtContext ctx);

	void enterStaticChildCall(TSLKGrammarParser.StaticChildCallContext ctx);

	void enterSubExpr(TSLKGrammarParser.SubExprContext ctx);

	void enterTableBlock(TSLKGrammarParser.TableBlockContext ctx);

	void enterTablenode(TSLKGrammarParser.TablenodeContext ctx);

	void enterUnaryOperator(TSLKGrammarParser.UnaryOperatorContext ctx);

	void enterWhileBlock(TSLKGrammarParser.WhileBlockContext ctx);

	void exitAssignExpr(TSLKGrammarParser.AssignExprContext ctx);

	void exitAtomBooleanFalse(TSLKGrammarParser.AtomBooleanFalseContext ctx);

	void exitAtomBooleanTrue(TSLKGrammarParser.AtomBooleanTrueContext ctx);

	void exitAtomNumber(TSLKGrammarParser.AtomNumberContext ctx);

	void exitAtomString(TSLKGrammarParser.AtomStringContext ctx);

	void exitBinaryOperator(TSLKGrammarParser.BinaryOperatorContext ctx);

	void exitBody(TSLKGrammarParser.BodyContext ctx);

	void exitBreakStmt(TSLKGrammarParser.BreakStmtContext ctx);

	void exitContinueStmt(TSLKGrammarParser.ContinueStmtContext ctx);

	void exitDynamicChildCall(TSLKGrammarParser.DynamicChildCallContext ctx);

	void exitForBlock(TSLKGrammarParser.ForBlockContext ctx);

	void exitFuncBlock(TSLKGrammarParser.FuncBlockContext ctx);

	void exitFuncCall(TSLKGrammarParser.FuncCallContext ctx);

	void exitIfBlock(TSLKGrammarParser.IfBlockContext ctx);

	void exitLocalAssignExpr(TSLKGrammarParser.LocalAssignExprContext ctx);

	void exitModifyExpr(TSLKGrammarParser.ModifyExprContext ctx);

	void exitNormalStmt(TSLKGrammarParser.NormalStmtContext ctx);

	void exitPathCall(TSLKGrammarParser.PathCallContext ctx);

	void exitReturnStmt(TSLKGrammarParser.ReturnStmtContext ctx);

	void exitStaticChildCall(TSLKGrammarParser.StaticChildCallContext ctx);

	void exitSubExpr(TSLKGrammarParser.SubExprContext ctx);

	void exitTableBlock(TSLKGrammarParser.TableBlockContext ctx);

	void exitTablenode(TSLKGrammarParser.TablenodeContext ctx);

	void exitUnaryOperator(TSLKGrammarParser.UnaryOperatorContext ctx);

	void exitWhileBlock(TSLKGrammarParser.WhileBlockContext ctx);
}