// Generated from TSLKGrammar.g4 by ANTLR 4.0
package org.ng200.tslk.lang;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface TSLKGrammarListener extends ParseTreeListener {
	void enterBody(TSLKGrammarParser.BodyContext ctx);
	void exitBody(TSLKGrammarParser.BodyContext ctx);

	void enterBreakStmt(TSLKGrammarParser.BreakStmtContext ctx);
	void exitBreakStmt(TSLKGrammarParser.BreakStmtContext ctx);

	void enterModifyExpr(TSLKGrammarParser.ModifyExprContext ctx);
	void exitModifyExpr(TSLKGrammarParser.ModifyExprContext ctx);

	void enterPathCall(TSLKGrammarParser.PathCallContext ctx);
	void exitPathCall(TSLKGrammarParser.PathCallContext ctx);

	void enterAtomString(TSLKGrammarParser.AtomStringContext ctx);
	void exitAtomString(TSLKGrammarParser.AtomStringContext ctx);

	void enterAtomBooleanFalse(TSLKGrammarParser.AtomBooleanFalseContext ctx);
	void exitAtomBooleanFalse(TSLKGrammarParser.AtomBooleanFalseContext ctx);

	void enterAssignExpr(TSLKGrammarParser.AssignExprContext ctx);
	void exitAssignExpr(TSLKGrammarParser.AssignExprContext ctx);

	void enterLocalAssignExpr(TSLKGrammarParser.LocalAssignExprContext ctx);
	void exitLocalAssignExpr(TSLKGrammarParser.LocalAssignExprContext ctx);

	void enterTableBlock(TSLKGrammarParser.TableBlockContext ctx);
	void exitTableBlock(TSLKGrammarParser.TableBlockContext ctx);

	void enterSubExpr(TSLKGrammarParser.SubExprContext ctx);
	void exitSubExpr(TSLKGrammarParser.SubExprContext ctx);

	void enterAtomNumber(TSLKGrammarParser.AtomNumberContext ctx);
	void exitAtomNumber(TSLKGrammarParser.AtomNumberContext ctx);

	void enterContinueStmt(TSLKGrammarParser.ContinueStmtContext ctx);
	void exitContinueStmt(TSLKGrammarParser.ContinueStmtContext ctx);

	void enterReturnStmt(TSLKGrammarParser.ReturnStmtContext ctx);
	void exitReturnStmt(TSLKGrammarParser.ReturnStmtContext ctx);

	void enterNormalStmt(TSLKGrammarParser.NormalStmtContext ctx);
	void exitNormalStmt(TSLKGrammarParser.NormalStmtContext ctx);

	void enterFuncCall(TSLKGrammarParser.FuncCallContext ctx);
	void exitFuncCall(TSLKGrammarParser.FuncCallContext ctx);

	void enterIfBlock(TSLKGrammarParser.IfBlockContext ctx);
	void exitIfBlock(TSLKGrammarParser.IfBlockContext ctx);

	void enterFuncBlock(TSLKGrammarParser.FuncBlockContext ctx);
	void exitFuncBlock(TSLKGrammarParser.FuncBlockContext ctx);

	void enterBinaryOperator(TSLKGrammarParser.BinaryOperatorContext ctx);
	void exitBinaryOperator(TSLKGrammarParser.BinaryOperatorContext ctx);

	void enterWhileBlock(TSLKGrammarParser.WhileBlockContext ctx);
	void exitWhileBlock(TSLKGrammarParser.WhileBlockContext ctx);

	void enterUnaryOperator(TSLKGrammarParser.UnaryOperatorContext ctx);
	void exitUnaryOperator(TSLKGrammarParser.UnaryOperatorContext ctx);

	void enterTablenode(TSLKGrammarParser.TablenodeContext ctx);
	void exitTablenode(TSLKGrammarParser.TablenodeContext ctx);

	void enterStaticChildCall(TSLKGrammarParser.StaticChildCallContext ctx);
	void exitStaticChildCall(TSLKGrammarParser.StaticChildCallContext ctx);

	void enterForBlock(TSLKGrammarParser.ForBlockContext ctx);
	void exitForBlock(TSLKGrammarParser.ForBlockContext ctx);

	void enterDynamicChildCall(TSLKGrammarParser.DynamicChildCallContext ctx);
	void exitDynamicChildCall(TSLKGrammarParser.DynamicChildCallContext ctx);

	void enterAtomBooleanTrue(TSLKGrammarParser.AtomBooleanTrueContext ctx);
	void exitAtomBooleanTrue(TSLKGrammarParser.AtomBooleanTrueContext ctx);
}