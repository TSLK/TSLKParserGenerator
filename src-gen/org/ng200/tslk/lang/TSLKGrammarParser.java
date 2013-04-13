// Generated from TSLKGrammar.g4 by ANTLR 4.0
package org.ng200.tslk.lang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class TSLKGrammarParser extends Parser {
	public static class AssignExprContext extends ExprContext {
		public PathContext varpath;
		public Token o;
		public ExprContext val;

		public AssignExprContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterAssignExpr(this);
		}

		public TerminalNode EQ() {
			return getToken(TSLKGrammarParser.EQ, 0);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitAssignExpr(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public PathContext path() {
			return getRuleContext(PathContext.class, 0);
		}
	}

	public static class AtomBooleanFalseContext extends ExprContext {
		public AtomBooleanFalseContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterAtomBooleanFalse(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitAtomBooleanFalse(this);
		}

		public TerminalNode FALSE() {
			return getToken(TSLKGrammarParser.FALSE, 0);
		}
	}

	public static class AtomBooleanTrueContext extends ExprContext {
		public AtomBooleanTrueContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterAtomBooleanTrue(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitAtomBooleanTrue(this);
		}

		public TerminalNode TRUE() {
			return getToken(TSLKGrammarParser.TRUE, 0);
		}
	}

	public static class AtomNumberContext extends ExprContext {
		public AtomNumberContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterAtomNumber(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitAtomNumber(this);
		}

		public TerminalNode NUMBER() {
			return getToken(TSLKGrammarParser.NUMBER, 0);
		}
	}

	public static class AtomStringContext extends ExprContext {
		public AtomStringContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterAtomString(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitAtomString(this);
		}

		public TerminalNode STRING() {
			return getToken(TSLKGrammarParser.STRING, 0);
		}
	}

	public static class BinaryOperatorContext extends ExprContext {
		public ExprContext l;
		public Token o;
		public ExprContext r;

		public BinaryOperatorContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode AND() {
			return getToken(TSLKGrammarParser.AND, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterBinaryOperator(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitBinaryOperator(this);
		}

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}
	}

	public static class BodyContext extends ParserRuleContext {
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterBody(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitBody(this);
		}

		@Override
		public int getRuleIndex() {
			return RULE_body;
		}

		public List<TerminalNode> SEMI() {
			return getTokens(TSLKGrammarParser.SEMI);
		}

		public TerminalNode SEMI(int i) {
			return getToken(TSLKGrammarParser.SEMI, i);
		}

		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}

		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class, i);
		}
	}

	public static class BreakStmtContext extends StmtContext {
		public BreakStmtContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode BREAK() {
			return getToken(TSLKGrammarParser.BREAK, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterBreakStmt(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitBreakStmt(this);
		}
	}

	public static class ContinueStmtContext extends StmtContext {
		public ContinueStmtContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode CONTINUE() {
			return getToken(TSLKGrammarParser.CONTINUE, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterContinueStmt(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitContinueStmt(this);
		}
	}

	public static class DynamicChildCallContext extends PathContext {
		public PathContext l;
		public ExprContext r;

		public DynamicChildCallContext(PathContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterDynamicChildCall(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitDynamicChildCall(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode LBRACKET() {
			return getToken(TSLKGrammarParser.LBRACKET, 0);
		}

		public PathContext path() {
			return getRuleContext(PathContext.class, 0);
		}

		public TerminalNode RBRACKET() {
			return getToken(TSLKGrammarParser.RBRACKET, 0);
		}
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;

		public ExprContext() {
		}

		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}

		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}

		@Override
		public int getRuleIndex() {
			return RULE_expr;
		}
	}

	public static class ForBlockContext extends StmtContext {
		public ExprContext initexpr;
		public ExprContext whileexpr;
		public ExprContext increxpr;
		public BodyContext forbody;

		public ForBlockContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		public BodyContext body() {
			return getRuleContext(BodyContext.class, 0);
		}

		public TerminalNode DO() {
			return getToken(TSLKGrammarParser.DO, 0);
		}

		public TerminalNode END() {
			return getToken(TSLKGrammarParser.END, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterForBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitForBlock(this);
		}

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public TerminalNode FOR() {
			return getToken(TSLKGrammarParser.FOR, 0);
		}

		public List<TerminalNode> SEMI() {
			return getTokens(TSLKGrammarParser.SEMI);
		}

		public TerminalNode SEMI(int i) {
			return getToken(TSLKGrammarParser.SEMI, i);
		}
	}

	public static class FuncBlockContext extends ExprContext {
		public Token GENERAL_ID;
		public List<Token> args = new ArrayList<Token>();
		public BodyContext funcbody;

		public FuncBlockContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		public BodyContext body() {
			return getRuleContext(BodyContext.class, 0);
		}

		public List<TerminalNode> COMMA() {
			return getTokens(TSLKGrammarParser.COMMA);
		}

		public TerminalNode COMMA(int i) {
			return getToken(TSLKGrammarParser.COMMA, i);
		}

		public TerminalNode END() {
			return getToken(TSLKGrammarParser.END, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterFuncBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitFuncBlock(this);
		}

		public TerminalNode FUNC() {
			return getToken(TSLKGrammarParser.FUNC, 0);
		}

		public List<TerminalNode> GENERAL_ID() {
			return getTokens(TSLKGrammarParser.GENERAL_ID);
		}

		public TerminalNode GENERAL_ID(int i) {
			return getToken(TSLKGrammarParser.GENERAL_ID, i);
		}

		public TerminalNode LPAREN() {
			return getToken(TSLKGrammarParser.LPAREN, 0);
		}

		public TerminalNode RPAREN() {
			return getToken(TSLKGrammarParser.RPAREN, 0);
		}
	}

	public static class FuncCallContext extends PathContext {
		public PathContext l;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();

		public FuncCallContext(PathContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> COMMA() {
			return getTokens(TSLKGrammarParser.COMMA);
		}

		public TerminalNode COMMA(int i) {
			return getToken(TSLKGrammarParser.COMMA, i);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterFuncCall(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitFuncCall(this);
		}

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public TerminalNode LPAREN() {
			return getToken(TSLKGrammarParser.LPAREN, 0);
		}

		public PathContext path() {
			return getRuleContext(PathContext.class, 0);
		}

		public TerminalNode RPAREN() {
			return getToken(TSLKGrammarParser.RPAREN, 0);
		}
	}

	public static class IfBlockContext extends StmtContext {
		public ExprContext ifexpr;
		public BodyContext ifbody;
		public ExprContext expr;
		public List<ExprContext> elifexprs = new ArrayList<ExprContext>();
		public BodyContext body;
		public List<BodyContext> elifbodies = new ArrayList<BodyContext>();
		public BodyContext elsebody;

		public IfBlockContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}

		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class, i);
		}

		public List<TerminalNode> ELSE() {
			return getTokens(TSLKGrammarParser.ELSE);
		}

		public TerminalNode ELSE(int i) {
			return getToken(TSLKGrammarParser.ELSE, i);
		}

		public TerminalNode END() {
			return getToken(TSLKGrammarParser.END, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterIfBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitIfBlock(this);
		}

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public List<TerminalNode> IF() {
			return getTokens(TSLKGrammarParser.IF);
		}

		public TerminalNode IF(int i) {
			return getToken(TSLKGrammarParser.IF, i);
		}

		public List<TerminalNode> THEN() {
			return getTokens(TSLKGrammarParser.THEN);
		}

		public TerminalNode THEN(int i) {
			return getToken(TSLKGrammarParser.THEN, i);
		}
	}

	public static class LocalAssignExprContext extends ExprContext {
		public Token varid;
		public Token o;
		public ExprContext val;

		public LocalAssignExprContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterLocalAssignExpr(this);
		}

		public TerminalNode EQ() {
			return getToken(TSLKGrammarParser.EQ, 0);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitLocalAssignExpr(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode GENERAL_ID() {
			return getToken(TSLKGrammarParser.GENERAL_ID, 0);
		}

		public TerminalNode LOCAL() {
			return getToken(TSLKGrammarParser.LOCAL, 0);
		}
	}

	public static class ModifyExprContext extends ExprContext {
		public PathContext varpath;
		public Token o;
		public ExprContext val;

		public ModifyExprContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode DIVEQ() {
			return getToken(TSLKGrammarParser.DIVEQ, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterModifyExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitModifyExpr(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode MINUSEQ() {
			return getToken(TSLKGrammarParser.MINUSEQ, 0);
		}

		public TerminalNode MULEQ() {
			return getToken(TSLKGrammarParser.MULEQ, 0);
		}

		public PathContext path() {
			return getRuleContext(PathContext.class, 0);
		}

		public TerminalNode PLUSEQ() {
			return getToken(TSLKGrammarParser.PLUSEQ, 0);
		}

		public TerminalNode REM() {
			return getToken(TSLKGrammarParser.REM, 0);
		}
	}

	public static class NormalStmtContext extends StmtContext {
		public NormalStmtContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterNormalStmt(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitNormalStmt(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}
	}

	public static class PathCallContext extends ExprContext {
		public PathCallContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterPathCall(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitPathCall(this);
		}

		public PathContext path() {
			return getRuleContext(PathContext.class, 0);
		}
	}

	public static class PathContext extends ParserRuleContext {
		public int _p;

		public PathContext() {
		}

		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public PathContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}

		public void copyFrom(PathContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}

		@Override
		public int getRuleIndex() {
			return RULE_path;
		}
	}

	public static class ReturnStmtContext extends StmtContext {
		public ExprContext e;

		public ReturnStmtContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterReturnStmt(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitReturnStmt(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode RETURN() {
			return getToken(TSLKGrammarParser.RETURN, 0);
		}
	}

	public static class StaticChildCallContext extends PathContext {
		public PathContext l;
		public Token name;

		public StaticChildCallContext(PathContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode DOT() {
			return getToken(TSLKGrammarParser.DOT, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterStaticChildCall(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitStaticChildCall(this);
		}

		public TerminalNode GENERAL_ID() {
			return getToken(TSLKGrammarParser.GENERAL_ID, 0);
		}

		public PathContext path() {
			return getRuleContext(PathContext.class, 0);
		}
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext() {
		}

		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}

		@Override
		public int getRuleIndex() {
			return RULE_stmt;
		}
	}

	public static class SubExprContext extends ExprContext {
		public ExprContext e;

		public SubExprContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterSubExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitSubExpr(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode LPAREN() {
			return getToken(TSLKGrammarParser.LPAREN, 0);
		}

		public TerminalNode RPAREN() {
			return getToken(TSLKGrammarParser.RPAREN, 0);
		}
	}

	public static class TableBlockContext extends ExprContext {
		public TablenodeContext tablenode;
		public List<TablenodeContext> vals = new ArrayList<TablenodeContext>();

		public TableBlockContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> COMMA() {
			return getTokens(TSLKGrammarParser.COMMA);
		}

		public TerminalNode COMMA(int i) {
			return getToken(TSLKGrammarParser.COMMA, i);
		}

		public TerminalNode END() {
			return getToken(TSLKGrammarParser.END, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterTableBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitTableBlock(this);
		}

		public TerminalNode TABLE() {
			return getToken(TSLKGrammarParser.TABLE, 0);
		}

		public List<TablenodeContext> tablenode() {
			return getRuleContexts(TablenodeContext.class);
		}

		public TablenodeContext tablenode(int i) {
			return getRuleContext(TablenodeContext.class, i);
		}
	}

	public static class TablenodeContext extends ParserRuleContext {
		public Token key;
		public ExprContext val;

		public TablenodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode COLON() {
			return getToken(TSLKGrammarParser.COLON, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterTablenode(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitTablenode(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode GENERAL_ID() {
			return getToken(TSLKGrammarParser.GENERAL_ID, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_tablenode;
		}

		public TerminalNode STRING() {
			return getToken(TSLKGrammarParser.STRING, 0);
		}
	}

	public static class UnaryOperatorContext extends ExprContext {
		public Token o;
		public ExprContext e;

		public UnaryOperatorContext(ExprContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterUnaryOperator(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitUnaryOperator(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode LEN() {
			return getToken(TSLKGrammarParser.LEN, 0);
		}

		public TerminalNode MINUS() {
			return getToken(TSLKGrammarParser.MINUS, 0);
		}

		public TerminalNode NOT() {
			return getToken(TSLKGrammarParser.NOT, 0);
		}
	}

	public static class WhileBlockContext extends StmtContext {
		public ExprContext whileexpr;
		public BodyContext whilebody;

		public WhileBlockContext(StmtContext ctx) {
			copyFrom(ctx);
		}

		public BodyContext body() {
			return getRuleContext(BodyContext.class, 0);
		}

		public TerminalNode DO() {
			return getToken(TSLKGrammarParser.DO, 0);
		}

		public TerminalNode END() {
			return getToken(TSLKGrammarParser.END, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).enterWhileBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof TSLKGrammarListener)
				((TSLKGrammarListener) listener).exitWhileBlock(this);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode WHILE() {
			return getToken(TSLKGrammarParser.WHILE, 0);
		}
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int NUMBER = 1, FUNC = 2, FOR = 3, WHILE = 4, IF = 5,
			ELSE = 6, THEN = 7, DO = 8, END = 9, OR = 10, AND = 11, LOCAL = 12,
			TABLE = 13, RETURN = 14, BREAK = 15, CONTINUE = 16, TRUE = 17,
			FALSE = 18, PLUSEQ = 19, MINUSEQ = 20, MULEQ = 21, DIVEQ = 22,
			REMEQ = 23, POWEQ = 24, LESSEQ = 25, LESS = 26, MOREEQ = 27,
			MORE = 28, EQEQ = 29, EQ = 30, NOTEQ = 31, PLUS = 32, MINUS = 33,
			MUL = 34, DIV = 35, REM = 36, NOT = 37, LEN = 38, POW = 39,
			DOT = 40, COMMA = 41, SEMI = 42, COLON = 43, LPAREN = 44,
			RPAREN = 45, LBRACKET = 46, RBRACKET = 47, LBRACE = 48,
			RBRACE = 49, STRING = 50, SLCOMMENT = 51, MLCOMMENT = 52, WS = 53,
			GENERAL_ID = 54;
	public static final String[] tokenNames = { "<INVALID>", "NUMBER",
			"'functiony'", "'for'", "'while'", "'if'", "'else'", "'then'",
			"'do'", "'end'", "'or'", "'and'", "'local'", "'table'", "'return'",
			"'break'", "'continue'", "'true'", "'false'", "'+='", "'-='",
			"'*='", "'/='", "'%='", "'^='", "'<='", "'<'", "'>='", "'>'",
			"'=='", "'='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'not'",
			"'#'", "'^'", "'.'", "','", "';'", "':'", "'('", "')'", "'['",
			"']'", "'{'", "'}'", "STRING", "SLCOMMENT", "MLCOMMENT", "WS",
			"GENERAL_ID" };
	public static final int RULE_body = 0, RULE_stmt = 1, RULE_expr = 2,
			RULE_tablenode = 3, RULE_path = 4;
	public static final String[] ruleNames = { "body", "stmt", "expr",
			"tablenode", "path" };
	public static final String _serializedATN = "\2\38\u00b6\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\7\2\20"
			+ "\n\2\f\2\16\2\23\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"
			+ "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"
			+ "\3\3\3\7\3\64\n\3\f\3\16\3\67\13\3\3\3\3\3\5\3;\n\3\3\3\3\3\5\3?\n\3\3"
			+ "\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"
			+ "\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\5\4Z\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"
			+ "\3\4\7\4d\n\4\f\4\16\4g\13\4\5\4i\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"
			+ "\3\4\3\4\5\4u\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"
			+ "\3\4\3\4\3\4\3\4\3\4\7\4\u0089\n\4\f\4\16\4\u008c\13\4\3\5\3\5\5\5\u0090"
			+ "\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009a\n\6\3\6\3\6\3\6\3\6\3\6"
			+ "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a9\n\6\f\6\16\6\u00ac\13\6\5\6"
			+ "\u00ae\n\6\3\6\7\6\u00b1\n\6\f\6\16\6\u00b4\13\6\3\6\4V\u00aa\7\2\4\6"
			+ "\b\n\2\b\4##\'(\4\25\30&&\3$&\3\"#\4\33\37!!\4\64\6488\u00d5\2\21\3\2"
			+ "\2\2\4>\3\2\2\2\6t\3\2\2\2\b\u008f\3\2\2\2\n\u0099\3\2\2\2\f\r\5\4\3\2"
			+ "\r\16\7,\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21"
			+ "\22\3\2\2\2\22\3\3\2\2\2\23\21\3\2\2\2\24?\5\6\4\2\25\26\7\20\2\2\26?"
			+ "\5\6\4\2\27?\7\21\2\2\30?\7\22\2\2\31\32\7\5\2\2\32\33\5\6\4\2\33\34\7"
			+ ",\2\2\34\35\5\6\4\2\35\36\7,\2\2\36\37\5\6\4\2\37 \7\n\2\2 !\5\2\2\2!"
			+ "\"\7\13\2\2\"?\3\2\2\2#$\7\6\2\2$%\5\6\4\2%&\7\n\2\2&\'\5\2\2\2\'(\7\13"
			+ "\2\2(?\3\2\2\2)*\7\7\2\2*+\5\6\4\2+,\7\t\2\2,\65\5\2\2\2-.\7\b\2\2./\7"
			+ "\7\2\2/\60\5\6\4\2\60\61\7\t\2\2\61\62\5\2\2\2\62\64\3\2\2\2\63-\3\2\2"
			+ "\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66:\3\2\2\2\67\65\3\2\2\2"
			+ "89\7\b\2\29;\5\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\13\2\2=?\3\2\2"
			+ "\2>\24\3\2\2\2>\25\3\2\2\2>\27\3\2\2\2>\30\3\2\2\2>\31\3\2\2\2>#\3\2\2"
			+ "\2>)\3\2\2\2?\5\3\2\2\2@A\b\4\1\2AB\t\2\2\2Bu\5\6\4\2CD\7\16\2\2DE\78"
			+ "\2\2EF\7 \2\2Fu\5\6\4\2GH\5\n\6\2HI\7 \2\2IJ\5\6\4\2Ju\3\2\2\2KL\5\n\6"
			+ "\2LM\t\3\2\2MN\5\6\4\2Nu\3\2\2\2OP\7\4\2\2PY\7.\2\2QV\78\2\2RS\7+\2\2"
			+ "SU\78\2\2TR\3\2\2\2UX\3\2\2\2VW\3\2\2\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2"
			+ "YQ\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7/\2\2\\]\5\2\2\2]^\7\13\2\2^u\3\2\2"
			+ "\2_h\7\17\2\2`e\5\b\5\2ab\7+\2\2bd\5\b\5\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2"
			+ "\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2\2hi\3\2\2\2ij\3\2\2\2ju\7\13"
			+ "\2\2ku\7\3\2\2lu\7\64\2\2mu\7\23\2\2nu\7\24\2\2ou\5\n\6\2pq\7.\2\2qr\5"
			+ "\6\4\2rs\7/\2\2su\3\2\2\2t@\3\2\2\2tC\3\2\2\2tG\3\2\2\2tK\3\2\2\2tO\3"
			+ "\2\2\2t_\3\2\2\2tk\3\2\2\2tl\3\2\2\2tm\3\2\2\2tn\3\2\2\2to\3\2\2\2tp\3"
			+ "\2\2\2u\u008a\3\2\2\2vw\6\4\2\3wx\7)\2\2x\u0089\5\6\4\2yz\6\4\3\3z{\t"
			+ "\4\2\2{\u0089\5\6\4\2|}\6\4\4\3}~\t\5\2\2~\u0089\5\6\4\2\177\u0080\6\4"
			+ "\5\3\u0080\u0081\t\6\2\2\u0081\u0089\5\6\4\2\u0082\u0083\6\4\6\3\u0083"
			+ "\u0084\7\f\2\2\u0084\u0089\5\6\4\2\u0085\u0086\6\4\7\3\u0086\u0087\7\r"
			+ "\2\2\u0087\u0089\5\6\4\2\u0088v\3\2\2\2\u0088y\3\2\2\2\u0088|\3\2\2\2"
			+ "\u0088\177\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0085\3\2\2\2\u0089\u008c"
			+ "\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\7\3\2\2\2\u008c"
			+ "\u008a\3\2\2\2\u008d\u008e\t\7\2\2\u008e\u0090\7-\2\2\u008f\u008d\3\2"
			+ "\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\5\6\4\2\u0092"
			+ "\t\3\2\2\2\u0093\u0094\b\6\1\2\u0094\u009a\78\2\2\u0095\u0096\7\60\2\2"
			+ "\u0096\u0097\5\6\4\2\u0097\u0098\7\61\2\2\u0098\u009a\3\2\2\2\u0099\u0093"
			+ "\3\2\2\2\u0099\u0095\3\2\2\2\u009a\u00b2\3\2\2\2\u009b\u009c\6\6\b\3\u009c"
			+ "\u009d\7*\2\2\u009d\u00b1\78\2\2\u009e\u009f\6\6\t\3\u009f\u00a0\7\60"
			+ "\2\2\u00a0\u00a1\5\6\4\2\u00a1\u00a2\7\61\2\2\u00a2\u00b1\3\2\2\2\u00a3"
			+ "\u00a4\6\6\n\3\u00a4\u00ad\7.\2\2\u00a5\u00aa\5\6\4\2\u00a6\u00a7\7+\2"
			+ "\2\u00a7\u00a9\5\6\4\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00ab"
			+ "\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"
			+ "\u00a5\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\7/"
			+ "\2\2\u00b0\u009b\3\2\2\2\u00b0\u009e\3\2\2\2\u00b0\u00a3\3\2\2\2\u00b1"
			+ "\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\13\3\2\2"
			+ "\2\u00b4\u00b2\3\2\2\2\23\21\65:>VYeht\u0088\u008a\u008f\u0099\u00aa\u00ad"
			+ "\u00b0\u00b2";
	public static final ATN _ATN = ATNSimulator.deserialize(_serializedATN
			.toCharArray());

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}

	public TSLKGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA,
				_sharedContextCache);
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER)
						| (1L << FUNC) | (1L << FOR) | (1L << WHILE)
						| (1L << IF) | (1L << LOCAL) | (1L << TABLE)
						| (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE)
						| (1L << TRUE) | (1L << FALSE) | (1L << MINUS)
						| (1L << NOT) | (1L << LEN) | (1L << LPAREN)
						| (1L << LBRACKET) | (1L << STRING) | (1L << GENERAL_ID))) != 0)) {
					{
						{
							setState(10);
							stmt();
							setState(11);
							match(SEMI);
						}
					}
					setState(17);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(114);
				switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
				case 1: {
					_localctx = new UnaryOperatorContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(63);
					((UnaryOperatorContext) _localctx).o = _input.LT(1);
					_la = _input.LA(1);
					if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS)
							| (1L << NOT) | (1L << LEN))) != 0))) {
						((UnaryOperatorContext) _localctx).o = (Token) _errHandler
								.recoverInline(this);
					}
					consume();
					setState(64);
					((UnaryOperatorContext) _localctx).e = expr(17);
				}
					break;

				case 2: {
					_localctx = new LocalAssignExprContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(65);
					match(LOCAL);
					setState(66);
					((LocalAssignExprContext) _localctx).varid = match(GENERAL_ID);
					setState(67);
					((LocalAssignExprContext) _localctx).o = match(EQ);
					setState(68);
					((LocalAssignExprContext) _localctx).val = expr(9);
				}
					break;

				case 3: {
					_localctx = new AssignExprContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(69);
					((AssignExprContext) _localctx).varpath = path(0);
					setState(70);
					((AssignExprContext) _localctx).o = match(EQ);
					setState(71);
					((AssignExprContext) _localctx).val = expr(8);
				}
					break;

				case 4: {
					_localctx = new ModifyExprContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(73);
					((ModifyExprContext) _localctx).varpath = path(0);
					setState(74);
					((ModifyExprContext) _localctx).o = _input.LT(1);
					_la = _input.LA(1);
					if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSEQ)
							| (1L << MINUSEQ) | (1L << MULEQ) | (1L << DIVEQ) | (1L << REM))) != 0))) {
						((ModifyExprContext) _localctx).o = (Token) _errHandler
								.recoverInline(this);
					}
					consume();
					setState(75);
					((ModifyExprContext) _localctx).val = expr(7);
				}
					break;

				case 5: {
					_localctx = new FuncBlockContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(77);
					match(FUNC);
					setState(78);
					match(LPAREN);
					setState(87);
					_la = _input.LA(1);
					if (_la == GENERAL_ID) {
						{
							setState(79);
							((FuncBlockContext) _localctx).GENERAL_ID = match(GENERAL_ID);
							((FuncBlockContext) _localctx).args
									.add(((FuncBlockContext) _localctx).GENERAL_ID);
							setState(84);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input, 4,
									_ctx);
							while (_alt != 1 && _alt != -1) {
								if (_alt == 1 + 1) {
									{
										{
											setState(80);
											match(COMMA);
											setState(81);
											((FuncBlockContext) _localctx).GENERAL_ID = match(GENERAL_ID);
											((FuncBlockContext) _localctx).args
													.add(((FuncBlockContext) _localctx).GENERAL_ID);
										}
									}
								}
								setState(86);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,
										4, _ctx);
							}
						}
					}

					setState(89);
					match(RPAREN);
					setState(90);
					((FuncBlockContext) _localctx).funcbody = body();
					setState(91);
					match(END);
				}
					break;

				case 6: {
					_localctx = new TableBlockContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(93);
					match(TABLE);
					setState(102);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER)
							| (1L << FUNC) | (1L << LOCAL) | (1L << TABLE)
							| (1L << TRUE) | (1L << FALSE) | (1L << MINUS)
							| (1L << NOT) | (1L << LEN) | (1L << LPAREN)
							| (1L << LBRACKET) | (1L << STRING) | (1L << GENERAL_ID))) != 0)) {
						{
							setState(94);
							((TableBlockContext) _localctx).tablenode = tablenode();
							((TableBlockContext) _localctx).vals
									.add(((TableBlockContext) _localctx).tablenode);
							setState(99);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la == COMMA) {
								{
									{
										setState(95);
										match(COMMA);
										setState(96);
										((TableBlockContext) _localctx).tablenode = tablenode();
										((TableBlockContext) _localctx).vals
												.add(((TableBlockContext) _localctx).tablenode);
									}
								}
								setState(101);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
						}
					}

					setState(104);
					match(END);
				}
					break;

				case 7: {
					_localctx = new AtomNumberContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(105);
					match(NUMBER);
				}
					break;

				case 8: {
					_localctx = new AtomStringContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(106);
					match(STRING);
				}
					break;

				case 9: {
					_localctx = new AtomBooleanTrueContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(107);
					match(TRUE);
				}
					break;

				case 10: {
					_localctx = new AtomBooleanFalseContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(108);
					match(FALSE);
				}
					break;

				case 11: {
					_localctx = new PathCallContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(109);
					path(0);
				}
					break;

				case 12: {
					_localctx = new SubExprContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(110);
					match(LPAREN);
					setState(111);
					((SubExprContext) _localctx).e = expr(0);
					setState(112);
					match(RPAREN);
				}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
				while (_alt != 2 && _alt != -1) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(134);
							switch (getInterpreter().adaptivePredict(_input, 9,
									_ctx)) {
							case 1: {
								_localctx = new BinaryOperatorContext(
										new ExprContext(_parentctx,
												_parentState, _p));
								((BinaryOperatorContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_expr);
								setState(116);
								if (!(18 >= _localctx._p))
									throw new FailedPredicateException(this,
											"18 >= $_p");
								setState(117);
								((BinaryOperatorContext) _localctx).o = match(POW);
								setState(118);
								((BinaryOperatorContext) _localctx).r = expr(19);
							}
								break;

							case 2: {
								_localctx = new BinaryOperatorContext(
										new ExprContext(_parentctx,
												_parentState, _p));
								((BinaryOperatorContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_expr);
								setState(119);
								if (!(16 >= _localctx._p))
									throw new FailedPredicateException(this,
											"16 >= $_p");
								setState(120);
								((BinaryOperatorContext) _localctx).o = _input
										.LT(1);
								_la = _input.LA(1);
								if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL)
										| (1L << DIV) | (1L << REM))) != 0))) {
									((BinaryOperatorContext) _localctx).o = (Token) _errHandler
											.recoverInline(this);
								}
								consume();
								setState(121);
								((BinaryOperatorContext) _localctx).r = expr(17);
							}
								break;

							case 3: {
								_localctx = new BinaryOperatorContext(
										new ExprContext(_parentctx,
												_parentState, _p));
								((BinaryOperatorContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_expr);
								setState(122);
								if (!(15 >= _localctx._p))
									throw new FailedPredicateException(this,
											"15 >= $_p");
								setState(123);
								((BinaryOperatorContext) _localctx).o = _input
										.LT(1);
								_la = _input.LA(1);
								if (!(_la == PLUS || _la == MINUS)) {
									((BinaryOperatorContext) _localctx).o = (Token) _errHandler
											.recoverInline(this);
								}
								consume();
								setState(124);
								((BinaryOperatorContext) _localctx).r = expr(16);
							}
								break;

							case 4: {
								_localctx = new BinaryOperatorContext(
										new ExprContext(_parentctx,
												_parentState, _p));
								((BinaryOperatorContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_expr);
								setState(125);
								if (!(14 >= _localctx._p))
									throw new FailedPredicateException(this,
											"14 >= $_p");
								setState(126);
								((BinaryOperatorContext) _localctx).o = _input
										.LT(1);
								_la = _input.LA(1);
								if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESSEQ)
										| (1L << LESS)
										| (1L << MOREEQ)
										| (1L << MORE) | (1L << EQEQ) | (1L << NOTEQ))) != 0))) {
									((BinaryOperatorContext) _localctx).o = (Token) _errHandler
											.recoverInline(this);
								}
								consume();
								setState(127);
								((BinaryOperatorContext) _localctx).r = expr(15);
							}
								break;

							case 5: {
								_localctx = new BinaryOperatorContext(
										new ExprContext(_parentctx,
												_parentState, _p));
								((BinaryOperatorContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_expr);
								setState(128);
								if (!(13 >= _localctx._p))
									throw new FailedPredicateException(this,
											"13 >= $_p");
								setState(129);
								((BinaryOperatorContext) _localctx).o = match(OR);
								setState(130);
								((BinaryOperatorContext) _localctx).r = expr(14);
							}
								break;

							case 6: {
								_localctx = new BinaryOperatorContext(
										new ExprContext(_parentctx,
												_parentState, _p));
								((BinaryOperatorContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_expr);
								setState(131);
								if (!(12 >= _localctx._p))
									throw new FailedPredicateException(this,
											"12 >= $_p");
								setState(132);
								((BinaryOperatorContext) _localctx).o = match(AND);
								setState(133);
								((BinaryOperatorContext) _localctx).r = expr(13);
							}
								break;
							}
						}
					}
					setState(138);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return 18 >= _localctx._p;

		case 1:
			return 16 >= _localctx._p;

		case 2:
			return 15 >= _localctx._p;

		case 3:
			return 14 >= _localctx._p;

		case 4:
			return 13 >= _localctx._p;

		case 5:
			return 12 >= _localctx._p;
		}
		return true;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	@Override
	public String getGrammarFileName() {
		return "TSLKGrammar.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String[] getTokenNames() {
		return tokenNames;
	}

	public final PathContext path(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathContext _localctx = new PathContext(_ctx, _parentState, _p);
		PathContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_path);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(151);
				switch (_input.LA(1)) {
				case GENERAL_ID: {
					_localctx = new StaticChildCallContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(146);
					((StaticChildCallContext) _localctx).name = match(GENERAL_ID);
				}
					break;
				case LBRACKET: {
					_localctx = new DynamicChildCallContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(147);
					match(LBRACKET);
					setState(148);
					((DynamicChildCallContext) _localctx).r = expr(0);
					setState(149);
					match(RBRACKET);
				}
					break;
				default:
					throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
				while (_alt != 2 && _alt != -1) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(174);
							switch (getInterpreter().adaptivePredict(_input,
									15, _ctx)) {
							case 1: {
								_localctx = new StaticChildCallContext(
										new PathContext(_parentctx,
												_parentState, _p));
								((StaticChildCallContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_path);
								setState(153);
								if (!(5 >= _localctx._p))
									throw new FailedPredicateException(this,
											"5 >= $_p");
								setState(154);
								match(DOT);
								setState(155);
								((StaticChildCallContext) _localctx).name = match(GENERAL_ID);
							}
								break;

							case 2: {
								_localctx = new DynamicChildCallContext(
										new PathContext(_parentctx,
												_parentState, _p));
								((DynamicChildCallContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_path);
								setState(156);
								if (!(4 >= _localctx._p))
									throw new FailedPredicateException(this,
											"4 >= $_p");
								setState(157);
								match(LBRACKET);
								setState(158);
								((DynamicChildCallContext) _localctx).r = expr(0);
								setState(159);
								match(RBRACKET);
							}
								break;

							case 3: {
								_localctx = new FuncCallContext(
										new PathContext(_parentctx,
												_parentState, _p));
								((FuncCallContext) _localctx).l = _prevctx;
								pushNewRecursionContext(_localctx, _startState,
										RULE_path);
								setState(161);
								if (!(3 >= _localctx._p))
									throw new FailedPredicateException(this,
											"3 >= $_p");
								{
									setState(162);
									match(LPAREN);
									setState(171);
									_la = _input.LA(1);
									if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER)
											| (1L << FUNC)
											| (1L << LOCAL)
											| (1L << TABLE)
											| (1L << TRUE)
											| (1L << FALSE)
											| (1L << MINUS)
											| (1L << NOT)
											| (1L << LEN)
											| (1L << LPAREN)
											| (1L << LBRACKET)
											| (1L << STRING) | (1L << GENERAL_ID))) != 0)) {
										{
											setState(163);
											((FuncCallContext) _localctx).expr = expr(0);
											((FuncCallContext) _localctx).args
													.add(((FuncCallContext) _localctx).expr);
											setState(168);
											_errHandler.sync(this);
											_alt = getInterpreter()
													.adaptivePredict(_input,
															13, _ctx);
											while (_alt != 1 && _alt != -1) {
												if (_alt == 1 + 1) {
													{
														{
															setState(164);
															match(COMMA);
															setState(165);
															((FuncCallContext) _localctx).expr = expr(0);
															((FuncCallContext) _localctx).args
																	.add(((FuncCallContext) _localctx).expr);
														}
													}
												}
												setState(170);
												_errHandler.sync(this);
												_alt = getInterpreter()
														.adaptivePredict(
																_input, 13,
																_ctx);
											}
										}
									}

									setState(173);
									match(RPAREN);
								}
							}
								break;
							}
						}
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	private boolean path_sempred(PathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return 5 >= _localctx._p;

		case 7:
			return 4 >= _localctx._p;

		case 8:
			return 3 >= _localctx._p;
		}
		return true;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext) _localctx, predIndex);

		case 4:
			return path_sempred((PathContext) _localctx, predIndex);
		}
		return true;
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		int _la;
		try {
			int _alt;
			setState(60);
			switch (_input.LA(1)) {
			case NUMBER:
			case FUNC:
			case LOCAL:
			case TABLE:
			case TRUE:
			case FALSE:
			case MINUS:
			case NOT:
			case LEN:
			case LPAREN:
			case LBRACKET:
			case STRING:
			case GENERAL_ID:
				_localctx = new NormalStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
					setState(18);
					expr(0);
				}
				break;
			case RETURN:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
					setState(19);
					match(RETURN);
					setState(20);
					((ReturnStmtContext) _localctx).e = expr(0);
				}
				break;
			case BREAK:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
					setState(21);
					match(BREAK);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
					setState(22);
					match(CONTINUE);
				}
				break;
			case FOR:
				_localctx = new ForBlockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
					setState(23);
					match(FOR);
					setState(24);
					((ForBlockContext) _localctx).initexpr = expr(0);
					setState(25);
					match(SEMI);
					setState(26);
					((ForBlockContext) _localctx).whileexpr = expr(0);
					setState(27);
					match(SEMI);
					setState(28);
					((ForBlockContext) _localctx).increxpr = expr(0);
					setState(29);
					match(DO);
					setState(30);
					((ForBlockContext) _localctx).forbody = body();
					setState(31);
					match(END);
				}
				break;
			case WHILE:
				_localctx = new WhileBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
					setState(33);
					match(WHILE);
					setState(34);
					((WhileBlockContext) _localctx).whileexpr = expr(0);
					setState(35);
					match(DO);
					setState(36);
					((WhileBlockContext) _localctx).whilebody = body();
					setState(37);
					match(END);
				}
				break;
			case IF:
				_localctx = new IfBlockContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
					setState(39);
					match(IF);
					setState(40);
					((IfBlockContext) _localctx).ifexpr = expr(0);
					setState(41);
					match(THEN);
					setState(42);
					((IfBlockContext) _localctx).ifbody = body();
					setState(51);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
					while (_alt != 2 && _alt != -1) {
						if (_alt == 1) {
							{
								{
									setState(43);
									match(ELSE);
									setState(44);
									match(IF);
									setState(45);
									((IfBlockContext) _localctx).expr = expr(0);
									((IfBlockContext) _localctx).elifexprs
											.add(((IfBlockContext) _localctx).expr);
									setState(46);
									match(THEN);
									setState(47);
									((IfBlockContext) _localctx).body = body();
									((IfBlockContext) _localctx).elifbodies
											.add(((IfBlockContext) _localctx).body);
								}
							}
						}
						setState(53);
						_errHandler.sync(this);
						_alt = getInterpreter()
								.adaptivePredict(_input, 1, _ctx);
					}
					setState(56);
					_la = _input.LA(1);
					if (_la == ELSE) {
						{
							setState(54);
							match(ELSE);
							setState(55);
							((IfBlockContext) _localctx).elsebody = body();
						}
					}

					setState(58);
					match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public final TablenodeContext tablenode() throws RecognitionException {
		TablenodeContext _localctx = new TablenodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tablenode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(141);
				switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
				case 1: {
					setState(139);
					((TablenodeContext) _localctx).key = _input.LT(1);
					_la = _input.LA(1);
					if (!(_la == STRING || _la == GENERAL_ID)) {
						((TablenodeContext) _localctx).key = (Token) _errHandler
								.recoverInline(this);
					}
					consume();
					setState(140);
					match(COLON);
				}
					break;
				}
				setState(143);
				((TablenodeContext) _localctx).val = expr(0);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}
}