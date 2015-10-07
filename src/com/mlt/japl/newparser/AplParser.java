// Generated from /Users/markolau/IdeaProjects/Japl/src/com/mlt/japl/newparser/Apl.g4 by ANTLR 4.5.1
package com.mlt.japl.newparser;

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INT=2, FLOAT=3, COMMENT=4, WS=5, NL=6, STRING=7, FUNC=8, ASSIGN=9, 
		LPAREN=10, RPAREN=11, LBRACKET=12, RBRACKET=13, LBRACE=14, RBRACE=15, 
		COLON=16, DIAMOND=17, IF=18, ENDIF=19, ELSE=20, ELSEIF=21, WHILE=22, ENDWHILE=23, 
		REPEAT=24, ENDREPEAT=25, FOR=26, IN=27, ENDFOR=28, OPERATOR=29;
	public static final int
		RULE_sep = 0, RULE_toplevel = 1, RULE_toplevelexpr = 2, RULE_expr_list = 3, 
		RULE_if_expr = 4, RULE_for_expr = 5, RULE_while_expr = 6, RULE_repeat_expr = 7, 
		RULE_arrayexpr = 8, RULE_assignment = 9, RULE_monadic_call_or_niladic = 10, 
		RULE_dyadic_call_or_array = 11, RULE_array = 12, RULE_arrayitem = 13, 
		RULE_subarrayexpr = 14, RULE_integer = 15, RULE_floating = 16, RULE_string = 17, 
		RULE_ident = 18, RULE_index = 19, RULE_func_operator = 20, RULE_func = 21, 
		RULE_lambdafunc = 22, RULE_guard_or_assignment = 23, RULE_guard = 24;
	public static final String[] ruleNames = {
		"sep", "toplevel", "toplevelexpr", "expr_list", "if_expr", "for_expr", 
		"while_expr", "repeat_expr", "arrayexpr", "assignment", "monadic_call_or_niladic", 
		"dyadic_call_or_array", "array", "arrayitem", "subarrayexpr", "integer", 
		"floating", "string", "ident", "index", "func_operator", "func", "lambdafunc", 
		"guard_or_assignment", "guard"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'\n'", null, null, "'\\u2190'", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", "':'", "'\\u22C4'", "':If'", null, 
		"':Else'", "':ElseIf'", "':While'", null, "':Repeat'", null, "':For'", 
		"':In'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID", "INT", "FLOAT", "COMMENT", "WS", "NL", "STRING", "FUNC", "ASSIGN", 
		"LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COLON", 
		"DIAMOND", "IF", "ENDIF", "ELSE", "ELSEIF", "WHILE", "ENDWHILE", "REPEAT", 
		"ENDREPEAT", "FOR", "IN", "ENDFOR", "OPERATOR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Apl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AplParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SepContext extends ParserRuleContext {
		public TerminalNode DIAMOND() { return getToken(AplParser.DIAMOND, 0); }
		public List<TerminalNode> NL() { return getTokens(AplParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AplParser.NL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(AplParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(AplParser.COMMENT, i);
		}
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitSep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sep);
		int _la;
		try {
			setState(56);
			switch (_input.LA(1)) {
			case DIAMOND:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(DIAMOND);
				}
				break;
			case COMMENT:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(51);
					_la = _input.LA(1);
					if ( !(_la==COMMENT || _la==NL) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(54); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMENT || _la==NL );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToplevelContext extends ParserRuleContext {
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AplParser.EOF, 0); }
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public ToplevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toplevel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitToplevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToplevelContext toplevel() throws RecognitionException {
		ToplevelContext _localctx = new ToplevelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_toplevel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(58);
				sep();
				}
			}

			setState(61);
			expr_list();
			setState(63);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(62);
				sep();
				}
			}

			setState(65);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToplevelexprContext extends ParserRuleContext {
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public While_exprContext while_expr() {
			return getRuleContext(While_exprContext.class,0);
		}
		public Repeat_exprContext repeat_expr() {
			return getRuleContext(Repeat_exprContext.class,0);
		}
		public For_exprContext for_expr() {
			return getRuleContext(For_exprContext.class,0);
		}
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public ToplevelexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toplevelexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitToplevelexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToplevelexprContext toplevelexpr() throws RecognitionException {
		ToplevelexprContext _localctx = new ToplevelexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_toplevelexpr);
		try {
			setState(72);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				if_expr();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				while_expr();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				repeat_expr();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				for_expr();
				}
				break;
			case ID:
			case INT:
			case FLOAT:
			case STRING:
			case FUNC:
			case LPAREN:
			case LBRACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				arrayexpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public List<ToplevelexprContext> toplevelexpr() {
			return getRuleContexts(ToplevelexprContext.class);
		}
		public ToplevelexprContext toplevelexpr(int i) {
			return getRuleContext(ToplevelexprContext.class,i);
		}
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			toplevelexpr();
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(75);
					sep();
					setState(76);
					toplevelexpr();
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_exprContext extends ParserRuleContext {
		public ArrayexprContext condition;
		public Expr_listContext thenbranch;
		public ArrayexprContext elifcondition;
		public Expr_listContext elifthenbranch;
		public Expr_listContext elsebranch;
		public TerminalNode IF() { return getToken(AplParser.IF, 0); }
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public TerminalNode ENDIF() { return getToken(AplParser.ENDIF, 0); }
		public List<ArrayexprContext> arrayexpr() {
			return getRuleContexts(ArrayexprContext.class);
		}
		public ArrayexprContext arrayexpr(int i) {
			return getRuleContext(ArrayexprContext.class,i);
		}
		public List<Expr_listContext> expr_list() {
			return getRuleContexts(Expr_listContext.class);
		}
		public Expr_listContext expr_list(int i) {
			return getRuleContext(Expr_listContext.class,i);
		}
		public List<TerminalNode> ELSEIF() { return getTokens(AplParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(AplParser.ELSEIF, i);
		}
		public TerminalNode ELSE() { return getToken(AplParser.ELSE, 0); }
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitIf_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(IF);
			setState(84);
			((If_exprContext)_localctx).condition = arrayexpr();
			setState(85);
			sep();
			setState(86);
			((If_exprContext)_localctx).thenbranch = expr_list();
			setState(88);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(87);
				sep();
				}
			}

			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(90);
				match(ELSEIF);
				setState(91);
				((If_exprContext)_localctx).elifcondition = arrayexpr();
				setState(92);
				sep();
				setState(93);
				((If_exprContext)_localctx).elifthenbranch = expr_list();
				setState(95);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(94);
					sep();
					}
				}

				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(102);
				match(ELSE);
				setState(103);
				((If_exprContext)_localctx).elsebranch = expr_list();
				setState(105);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(104);
					sep();
					}
				}

				}
			}

			setState(109);
			match(ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_exprContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(AplParser.FOR, 0); }
		public TerminalNode ID() { return getToken(AplParser.ID, 0); }
		public TerminalNode IN() { return getToken(AplParser.IN, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode ENDFOR() { return getToken(AplParser.ENDFOR, 0); }
		public For_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_exprContext for_expr() throws RecognitionException {
		For_exprContext _localctx = new For_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_for_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(FOR);
			setState(112);
			match(ID);
			setState(113);
			match(IN);
			setState(114);
			arrayexpr();
			setState(115);
			sep();
			setState(116);
			expr_list();
			setState(117);
			match(ENDFOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_exprContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(AplParser.WHILE, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode ENDWHILE() { return getToken(AplParser.ENDWHILE, 0); }
		public While_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitWhile_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_exprContext while_expr() throws RecognitionException {
		While_exprContext _localctx = new While_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_while_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(WHILE);
			setState(120);
			arrayexpr();
			setState(121);
			sep();
			setState(122);
			expr_list();
			setState(124);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(123);
				sep();
				}
			}

			setState(126);
			match(ENDWHILE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Repeat_exprContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(AplParser.REPEAT, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode ENDREPEAT() { return getToken(AplParser.ENDREPEAT, 0); }
		public Repeat_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitRepeat_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Repeat_exprContext repeat_expr() throws RecognitionException {
		Repeat_exprContext _localctx = new Repeat_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_repeat_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(REPEAT);
			setState(129);
			arrayexpr();
			setState(130);
			sep();
			setState(131);
			expr_list();
			setState(133);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(132);
				sep();
				}
			}

			setState(135);
			match(ENDREPEAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayexprContext extends ParserRuleContext {
		public Monadic_call_or_niladicContext monadic_call_or_niladic() {
			return getRuleContext(Monadic_call_or_niladicContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Dyadic_call_or_arrayContext dyadic_call_or_array() {
			return getRuleContext(Dyadic_call_or_arrayContext.class,0);
		}
		public ArrayexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitArrayexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayexprContext arrayexpr() throws RecognitionException {
		ArrayexprContext _localctx = new ArrayexprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayexpr);
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				monadic_call_or_niladic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				dyadic_call_or_array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AplParser.ID, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				match(ID);
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(147);
			match(ASSIGN);
			setState(148);
			arrayexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Monadic_call_or_niladicContext extends ParserRuleContext {
		public Func_operatorContext func_operator() {
			return getRuleContext(Func_operatorContext.class,0);
		}
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public Monadic_call_or_niladicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monadic_call_or_niladic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitMonadic_call_or_niladic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Monadic_call_or_niladicContext monadic_call_or_niladic() throws RecognitionException {
		Monadic_call_or_niladicContext _localctx = new Monadic_call_or_niladicContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_monadic_call_or_niladic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			func_operator();
			setState(152);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING) | (1L << FUNC) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
				{
				setState(151);
				arrayexpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dyadic_call_or_arrayContext extends ParserRuleContext {
		public ArrayContext l;
		public Func_operatorContext fn;
		public ArrayexprContext r;
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public Func_operatorContext func_operator() {
			return getRuleContext(Func_operatorContext.class,0);
		}
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public Dyadic_call_or_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dyadic_call_or_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitDyadic_call_or_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dyadic_call_or_arrayContext dyadic_call_or_array() throws RecognitionException {
		Dyadic_call_or_arrayContext _localctx = new Dyadic_call_or_arrayContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dyadic_call_or_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((Dyadic_call_or_arrayContext)_localctx).l = array();
			setState(158);
			_la = _input.LA(1);
			if (_la==FUNC || _la==LBRACE) {
				{
				setState(155);
				((Dyadic_call_or_arrayContext)_localctx).fn = func_operator();
				setState(156);
				((Dyadic_call_or_arrayContext)_localctx).r = arrayexpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<ArrayitemContext> arrayitem() {
			return getRuleContexts(ArrayitemContext.class);
		}
		public ArrayitemContext arrayitem(int i) {
			return getRuleContext(ArrayitemContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				arrayitem();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING) | (1L << LPAREN))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayitemContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public FloatingContext floating() {
			return getRuleContext(FloatingContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public SubarrayexprContext subarrayexpr() {
			return getRuleContext(SubarrayexprContext.class,0);
		}
		public ArrayitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayitem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitArrayitem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayitemContext arrayitem() throws RecognitionException {
		ArrayitemContext _localctx = new ArrayitemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrayitem);
		try {
			setState(170);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				ident();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				floating();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				string();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				subarrayexpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubarrayexprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(AplParser.LPAREN, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AplParser.RPAREN, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public SubarrayexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subarrayexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitSubarrayexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubarrayexprContext subarrayexpr() throws RecognitionException {
		SubarrayexprContext _localctx = new SubarrayexprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_subarrayexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(LPAREN);
			setState(173);
			arrayexpr();
			setState(174);
			match(RPAREN);
			setState(176);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(175);
				index();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AplParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatingContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(AplParser.FLOAT, 0); }
		public FloatingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFloating(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingContext floating() throws RecognitionException {
		FloatingContext _localctx = new FloatingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_floating);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AplParser.STRING, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(STRING);
			setState(184);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(183);
				index();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplParser.ID, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(ID);
			setState(188);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(187);
				index();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(AplParser.LBRACKET, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(AplParser.RBRACKET, 0); }
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(LBRACKET);
			setState(191);
			arrayexpr();
			setState(192);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_operatorContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(AplParser.OPERATOR, 0); }
		public Func_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFunc_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_operatorContext func_operator() throws RecognitionException {
		Func_operatorContext _localctx = new Func_operatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_func_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			func();
			setState(196);
			_la = _input.LA(1);
			if (_la==OPERATOR) {
				{
				setState(195);
				match(OPERATOR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(AplParser.FUNC, 0); }
		public LambdafuncContext lambdafunc() {
			return getRuleContext(LambdafuncContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func);
		try {
			setState(200);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(FUNC);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				lambdafunc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdafuncContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(AplParser.LBRACE, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(AplParser.RBRACE, 0); }
		public List<SepContext> sep() {
			return getRuleContexts(SepContext.class);
		}
		public SepContext sep(int i) {
			return getRuleContext(SepContext.class,i);
		}
		public List<Guard_or_assignmentContext> guard_or_assignment() {
			return getRuleContexts(Guard_or_assignmentContext.class);
		}
		public Guard_or_assignmentContext guard_or_assignment(int i) {
			return getRuleContext(Guard_or_assignmentContext.class,i);
		}
		public LambdafuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdafunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitLambdafunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdafuncContext lambdafunc() throws RecognitionException {
		LambdafuncContext _localctx = new LambdafuncContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lambdafunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(LBRACE);
			setState(204);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(203);
				sep();
				}
			}

			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					guard_or_assignment();
					setState(207);
					sep();
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(214);
			arrayexpr();
			setState(216);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(215);
				sep();
				}
			}

			setState(218);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Guard_or_assignmentContext extends ParserRuleContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Guard_or_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard_or_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitGuard_or_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Guard_or_assignmentContext guard_or_assignment() throws RecognitionException {
		Guard_or_assignmentContext _localctx = new Guard_or_assignmentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_guard_or_assignment);
		try {
			setState(222);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				guard();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardContext extends ParserRuleContext {
		public List<ArrayexprContext> arrayexpr() {
			return getRuleContexts(ArrayexprContext.class);
		}
		public ArrayexprContext arrayexpr(int i) {
			return getRuleContext(ArrayexprContext.class,i);
		}
		public TerminalNode COLON() { return getToken(AplParser.COLON, 0); }
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			arrayexpr();
			setState(225);
			match(COLON);
			setState(226);
			arrayexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00e7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\6\2\67\n\2\r\2\16\28\5\2;\n\2\3\3\5\3>\n\3\3\3\3\3"+
		"\5\3B\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\7\5Q\n"+
		"\5\f\5\16\5T\13\5\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"b\n\6\7\6d\n\6\f\6\16\6g\13\6\3\6\3\6\3\6\5\6l\n\6\5\6n\n\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\177\n\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u0088\n\t\3\t\3\t\3\n\3\n\3\n\5\n\u008f\n\n\3"+
		"\13\6\13\u0092\n\13\r\13\16\13\u0093\3\13\3\13\3\13\3\f\3\f\5\f\u009b"+
		"\n\f\3\r\3\r\3\r\3\r\5\r\u00a1\n\r\3\16\6\16\u00a4\n\16\r\16\16\16\u00a5"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00ad\n\17\3\20\3\20\3\20\3\20\5\20\u00b3"+
		"\n\20\3\21\3\21\3\22\3\22\3\23\3\23\5\23\u00bb\n\23\3\24\3\24\5\24\u00bf"+
		"\n\24\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u00c7\n\26\3\27\3\27\5\27\u00cb"+
		"\n\27\3\30\3\30\5\30\u00cf\n\30\3\30\3\30\3\30\7\30\u00d4\n\30\f\30\16"+
		"\30\u00d7\13\30\3\30\3\30\5\30\u00db\n\30\3\30\3\30\3\31\3\31\5\31\u00e1"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\2\3\4\2\6\6\b\b\u00f0\2:\3\2\2\2\4=\3\2\2\2\6J\3"+
		"\2\2\2\bL\3\2\2\2\nU\3\2\2\2\fq\3\2\2\2\16y\3\2\2\2\20\u0082\3\2\2\2\22"+
		"\u008e\3\2\2\2\24\u0091\3\2\2\2\26\u0098\3\2\2\2\30\u009c\3\2\2\2\32\u00a3"+
		"\3\2\2\2\34\u00ac\3\2\2\2\36\u00ae\3\2\2\2 \u00b4\3\2\2\2\"\u00b6\3\2"+
		"\2\2$\u00b8\3\2\2\2&\u00bc\3\2\2\2(\u00c0\3\2\2\2*\u00c4\3\2\2\2,\u00ca"+
		"\3\2\2\2.\u00cc\3\2\2\2\60\u00e0\3\2\2\2\62\u00e2\3\2\2\2\64;\7\23\2\2"+
		"\65\67\t\2\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2"+
		"\2:\64\3\2\2\2:\66\3\2\2\2;\3\3\2\2\2<>\5\2\2\2=<\3\2\2\2=>\3\2\2\2>?"+
		"\3\2\2\2?A\5\b\5\2@B\5\2\2\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\2\2\3D"+
		"\5\3\2\2\2EK\5\n\6\2FK\5\16\b\2GK\5\20\t\2HK\5\f\7\2IK\5\22\n\2JE\3\2"+
		"\2\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\7\3\2\2\2LR\5\6\4\2MN\5"+
		"\2\2\2NO\5\6\4\2OQ\3\2\2\2PM\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\t"+
		"\3\2\2\2TR\3\2\2\2UV\7\24\2\2VW\5\22\n\2WX\5\2\2\2XZ\5\b\5\2Y[\5\2\2\2"+
		"ZY\3\2\2\2Z[\3\2\2\2[e\3\2\2\2\\]\7\27\2\2]^\5\22\n\2^_\5\2\2\2_a\5\b"+
		"\5\2`b\5\2\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2c\\\3\2\2\2dg\3\2\2\2ec\3"+
		"\2\2\2ef\3\2\2\2fm\3\2\2\2ge\3\2\2\2hi\7\26\2\2ik\5\b\5\2jl\5\2\2\2kj"+
		"\3\2\2\2kl\3\2\2\2ln\3\2\2\2mh\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\25\2\2"+
		"p\13\3\2\2\2qr\7\34\2\2rs\7\3\2\2st\7\35\2\2tu\5\22\n\2uv\5\2\2\2vw\5"+
		"\b\5\2wx\7\36\2\2x\r\3\2\2\2yz\7\30\2\2z{\5\22\n\2{|\5\2\2\2|~\5\b\5\2"+
		"}\177\5\2\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\31"+
		"\2\2\u0081\17\3\2\2\2\u0082\u0083\7\32\2\2\u0083\u0084\5\22\n\2\u0084"+
		"\u0085\5\2\2\2\u0085\u0087\5\b\5\2\u0086\u0088\5\2\2\2\u0087\u0086\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\33\2\2\u008a"+
		"\21\3\2\2\2\u008b\u008f\5\26\f\2\u008c\u008f\5\24\13\2\u008d\u008f\5\30"+
		"\r\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\23\3\2\2\2\u0090\u0092\7\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2"+
		"\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096"+
		"\7\13\2\2\u0096\u0097\5\22\n\2\u0097\25\3\2\2\2\u0098\u009a\5*\26\2\u0099"+
		"\u009b\5\22\n\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\27\3\2\2"+
		"\2\u009c\u00a0\5\32\16\2\u009d\u009e\5*\26\2\u009e\u009f\5\22\n\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\31\3\2\2"+
		"\2\u00a2\u00a4\5\34\17\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\33\3\2\2\2\u00a7\u00ad\5&\24"+
		"\2\u00a8\u00ad\5 \21\2\u00a9\u00ad\5\"\22\2\u00aa\u00ad\5$\23\2\u00ab"+
		"\u00ad\5\36\20\2\u00ac\u00a7\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\35\3\2\2\2\u00ae"+
		"\u00af\7\f\2\2\u00af\u00b0\5\22\n\2\u00b0\u00b2\7\r\2\2\u00b1\u00b3\5"+
		"(\25\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\37\3\2\2\2\u00b4"+
		"\u00b5\7\4\2\2\u00b5!\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7#\3\2\2\2\u00b8"+
		"\u00ba\7\t\2\2\u00b9\u00bb\5(\25\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb%\3\2\2\2\u00bc\u00be\7\3\2\2\u00bd\u00bf\5(\25\2\u00be\u00bd"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\'\3\2\2\2\u00c0\u00c1\7\16\2\2\u00c1"+
		"\u00c2\5\22\n\2\u00c2\u00c3\7\17\2\2\u00c3)\3\2\2\2\u00c4\u00c6\5,\27"+
		"\2\u00c5\u00c7\7\37\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"+\3\2\2\2\u00c8\u00cb\7\n\2\2\u00c9\u00cb\5.\30\2\u00ca\u00c8\3\2\2\2"+
		"\u00ca\u00c9\3\2\2\2\u00cb-\3\2\2\2\u00cc\u00ce\7\20\2\2\u00cd\u00cf\5"+
		"\2\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d5\3\2\2\2\u00d0"+
		"\u00d1\5\60\31\2\u00d1\u00d2\5\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d0\3"+
		"\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\5\22\n\2\u00d9\u00db\5"+
		"\2\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00dd\7\21\2\2\u00dd/\3\2\2\2\u00de\u00e1\5\62\32\2\u00df\u00e1\5\24"+
		"\13\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\61\3\2\2\2\u00e2\u00e3"+
		"\5\22\n\2\u00e3\u00e4\7\22\2\2\u00e4\u00e5\5\22\n\2\u00e5\63\3\2\2\2\36"+
		"8:=AJRZaekm~\u0087\u008e\u0093\u009a\u00a0\u00a5\u00ac\u00b2\u00ba\u00be"+
		"\u00c6\u00ca\u00ce\u00d5\u00da\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}