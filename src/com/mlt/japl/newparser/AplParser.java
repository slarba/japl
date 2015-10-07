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
		T__0=1, ID=2, LABEL=3, SIGN=4, INT=5, FLOAT=6, COMPLEX=7, COMMENT=8, WS=9, 
		NL=10, STRING=11, FUNC=12, ASSIGN=13, LPAREN=14, RPAREN=15, LBRACKET=16, 
		RBRACKET=17, LBRACE=18, RBRACE=19, COLON=20, DIAMOND=21, SEMICOLON=22, 
		IF=23, ENDIF=24, ELSE=25, ELSEIF=26, WHILE=27, ENDWHILE=28, REPEAT=29, 
		ENDREPEAT=30, FOR=31, IN=32, ENDFOR=33, OPERATOR=34, OUTERPRODUCT=35;
	public static final int
		RULE_sep = 0, RULE_toplevel = 1, RULE_toplevelexpr = 2, RULE_expr_list = 3, 
		RULE_if_expr = 4, RULE_for_expr = 5, RULE_while_expr = 6, RULE_repeat_expr = 7, 
		RULE_arrayexpr = 8, RULE_assignment = 9, RULE_monadic_call_or_niladic = 10, 
		RULE_dyadic_call_or_array = 11, RULE_array = 12, RULE_arrayitem = 13, 
		RULE_subarrayexpr = 14, RULE_integer = 15, RULE_floating = 16, RULE_complexnum = 17, 
		RULE_string = 18, RULE_ident = 19, RULE_index = 20, RULE_indexelement = 21, 
		RULE_func_operator = 22, RULE_func = 23, RULE_axis = 24, RULE_lambdafunc = 25, 
		RULE_guard_or_assignment = 26, RULE_guard = 27;
	public static final String[] ruleNames = {
		"sep", "toplevel", "toplevelexpr", "expr_list", "if_expr", "for_expr", 
		"while_expr", "repeat_expr", "arrayexpr", "assignment", "monadic_call_or_niladic", 
		"dyadic_call_or_array", "array", "arrayitem", "subarrayexpr", "integer", 
		"floating", "complexnum", "string", "ident", "index", "indexelement", 
		"func_operator", "func", "axis", "lambdafunc", "guard_or_assignment", 
		"guard"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", null, null, "'\\u00af'", null, null, null, null, null, "'\n'", 
		null, null, "'\\u2190'", "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", 
		"'\\u22C4'", "';'", "':If'", null, "':Else'", "':ElseIf'", "':While'", 
		null, "':Repeat'", null, "':For'", "':In'", null, null, "'\\u2218.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ID", "LABEL", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", 
		"WS", "NL", "STRING", "FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", 
		"RBRACKET", "LBRACE", "RBRACE", "COLON", "DIAMOND", "SEMICOLON", "IF", 
		"ENDIF", "ELSE", "ELSEIF", "WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", 
		"FOR", "IN", "ENDFOR", "OPERATOR", "OUTERPRODUCT"
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
			setState(62);
			switch (_input.LA(1)) {
			case DIAMOND:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(DIAMOND);
				}
				break;
			case COMMENT:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(57);
					_la = _input.LA(1);
					if ( !(_la==COMMENT || _la==NL) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(60); 
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
			setState(65);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(64);
				sep();
				}
			}

			setState(67);
			expr_list();
			setState(69);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(68);
				sep();
				}
			}

			setState(71);
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
			setState(78);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				if_expr();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				while_expr();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				repeat_expr();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				for_expr();
				}
				break;
			case ID:
			case INT:
			case FLOAT:
			case COMPLEX:
			case STRING:
			case FUNC:
			case LPAREN:
			case LBRACE:
			case OUTERPRODUCT:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
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
			setState(80);
			toplevelexpr();
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(81);
					sep();
					setState(82);
					toplevelexpr();
					}
					} 
				}
				setState(88);
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
			setState(89);
			match(IF);
			setState(90);
			((If_exprContext)_localctx).condition = arrayexpr();
			setState(91);
			sep();
			setState(92);
			((If_exprContext)_localctx).thenbranch = expr_list();
			setState(94);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(93);
				sep();
				}
			}

			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(96);
				match(ELSEIF);
				setState(97);
				((If_exprContext)_localctx).elifcondition = arrayexpr();
				setState(98);
				sep();
				setState(99);
				((If_exprContext)_localctx).elifthenbranch = expr_list();
				setState(101);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(100);
					sep();
					}
				}

				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(108);
				match(ELSE);
				setState(109);
				((If_exprContext)_localctx).elsebranch = expr_list();
				setState(111);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(110);
					sep();
					}
				}

				}
			}

			setState(115);
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
			setState(117);
			match(FOR);
			setState(118);
			match(ID);
			setState(119);
			match(IN);
			setState(120);
			arrayexpr();
			setState(121);
			sep();
			setState(122);
			expr_list();
			setState(123);
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
			setState(125);
			match(WHILE);
			setState(126);
			arrayexpr();
			setState(127);
			sep();
			setState(128);
			expr_list();
			setState(130);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(129);
				sep();
				}
			}

			setState(132);
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
			setState(134);
			match(REPEAT);
			setState(135);
			arrayexpr();
			setState(136);
			sep();
			setState(137);
			expr_list();
			setState(139);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(138);
				sep();
				}
			}

			setState(141);
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
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				monadic_call_or_niladic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
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
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				match(ID);
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(153);
			match(ASSIGN);
			setState(154);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			func_operator();
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(157);
				arrayexpr();
				}
				break;
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			((Dyadic_call_or_arrayContext)_localctx).l = array();
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(161);
				((Dyadic_call_or_arrayContext)_localctx).fn = func_operator();
				setState(162);
				((Dyadic_call_or_arrayContext)_localctx).r = arrayexpr();
				}
				break;
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(166);
					arrayitem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(169); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public ComplexnumContext complexnum() {
			return getRuleContext(ComplexnumContext.class,0);
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
			setState(177);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				ident();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				floating();
				}
				break;
			case COMPLEX:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				complexnum();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				string();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
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
			setState(179);
			match(LPAREN);
			setState(180);
			arrayexpr();
			setState(181);
			match(RPAREN);
			setState(183);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(182);
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
			setState(185);
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
			setState(187);
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

	public static class ComplexnumContext extends ParserRuleContext {
		public TerminalNode COMPLEX() { return getToken(AplParser.COMPLEX, 0); }
		public ComplexnumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexnum; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitComplexnum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexnumContext complexnum() throws RecognitionException {
		ComplexnumContext _localctx = new ComplexnumContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_complexnum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(COMPLEX);
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
		enterRule(_localctx, 36, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(STRING);
			setState(193);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(192);
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
		enterRule(_localctx, 38, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(ID);
			setState(197);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(196);
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
		public TerminalNode RBRACKET() { return getToken(AplParser.RBRACKET, 0); }
		public List<IndexelementContext> indexelement() {
			return getRuleContexts(IndexelementContext.class);
		}
		public IndexelementContext indexelement(int i) {
			return getRuleContext(IndexelementContext.class,i);
		}
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
		enterRule(_localctx, 40, RULE_index);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(LBRACKET);
			setState(201); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(200);
				indexelement();
				}
				}
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << FUNC) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMICOLON) | (1L << OUTERPRODUCT))) != 0) );
			setState(205);
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

	public static class IndexelementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(AplParser.SEMICOLON, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public IndexelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitIndexelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexelementContext indexelement() throws RecognitionException {
		IndexelementContext _localctx = new IndexelementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_indexelement);
		try {
			setState(209);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(SEMICOLON);
				}
				break;
			case ID:
			case INT:
			case FLOAT:
			case COMPLEX:
			case STRING:
			case FUNC:
			case LPAREN:
			case LBRACE:
			case OUTERPRODUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
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

	public static class Func_operatorContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(AplParser.OPERATOR, 0); }
		public AxisContext axis() {
			return getRuleContext(AxisContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_func_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			func(0);
			setState(216);
			_la = _input.LA(1);
			if (_la==OPERATOR) {
				{
				setState(212);
				match(OPERATOR);
				setState(214);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(213);
					axis();
					}
				}

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
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimplefuncContext extends FuncContext {
		public TerminalNode FUNC() { return getToken(AplParser.FUNC, 0); }
		public AxisContext axis() {
			return getRuleContext(AxisContext.class,0);
		}
		public SimplefuncContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitSimplefunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaContext extends FuncContext {
		public LambdafuncContext lambdafunc() {
			return getRuleContext(LambdafuncContext.class,0);
		}
		public LambdaContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OuterproductContext extends FuncContext {
		public TerminalNode OUTERPRODUCT() { return getToken(AplParser.OUTERPRODUCT, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public OuterproductContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitOuterproduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InnerprodContext extends FuncContext {
		public FuncContext outer;
		public FuncContext inner;
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public InnerprodContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitInnerprod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		return func(0);
	}

	private FuncContext func(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FuncContext _localctx = new FuncContext(_ctx, _parentState);
		FuncContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_func, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			switch (_input.LA(1)) {
			case OUTERPRODUCT:
				{
				_localctx = new OuterproductContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(219);
				match(OUTERPRODUCT);
				setState(220);
				func(2);
				}
				break;
			case FUNC:
				{
				_localctx = new SimplefuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(FUNC);
				setState(223);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(222);
					axis();
					}
					break;
				}
				}
				break;
			case LBRACE:
				{
				_localctx = new LambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				lambdafunc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InnerprodContext(new FuncContext(_parentctx, _parentState));
					((InnerprodContext)_localctx).outer = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_func);
					setState(228);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(229);
					match(T__0);
					setState(230);
					((InnerprodContext)_localctx).inner = func(5);
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AxisContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(AplParser.LBRACKET, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(AplParser.RBRACKET, 0); }
		public AxisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axis; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitAxis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AxisContext axis() throws RecognitionException {
		AxisContext _localctx = new AxisContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_axis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(LBRACKET);
			setState(237);
			arrayexpr();
			setState(238);
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
		enterRule(_localctx, 50, RULE_lambdafunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(LBRACE);
			setState(242);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(241);
				sep();
				}
			}

			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(244);
					guard_or_assignment();
					setState(245);
					sep();
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(252);
			arrayexpr();
			setState(254);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(253);
				sep();
				}
			}

			setState(256);
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
		enterRule(_localctx, 52, RULE_guard_or_assignment);
		try {
			setState(260);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				guard();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
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
		enterRule(_localctx, 54, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			arrayexpr();
			setState(263);
			match(COLON);
			setState(264);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23:
			return func_sempred((FuncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean func_sempred(FuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\6\2=\n\2\r\2\16\2>\5"+
		"\2A\n\2\3\3\5\3D\n\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4"+
		"Q\n\4\3\5\3\5\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\6\3\6\3\6\3\6\3\6\5\6"+
		"a\n\6\3\6\3\6\3\6\3\6\3\6\5\6h\n\6\7\6j\n\6\f\6\16\6m\13\6\3\6\3\6\3\6"+
		"\5\6r\n\6\5\6t\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u0085\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u008e\n\t\3\t\3"+
		"\t\3\n\3\n\3\n\5\n\u0095\n\n\3\13\6\13\u0098\n\13\r\13\16\13\u0099\3\13"+
		"\3\13\3\13\3\f\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\16\6"+
		"\16\u00aa\n\16\r\16\16\16\u00ab\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b4"+
		"\n\17\3\20\3\20\3\20\3\20\5\20\u00ba\n\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\5\24\u00c4\n\24\3\25\3\25\5\25\u00c8\n\25\3\26\3\26\6\26\u00cc"+
		"\n\26\r\26\16\26\u00cd\3\26\3\26\3\27\3\27\5\27\u00d4\n\27\3\30\3\30\3"+
		"\30\5\30\u00d9\n\30\5\30\u00db\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u00e2"+
		"\n\31\3\31\5\31\u00e5\n\31\3\31\3\31\3\31\7\31\u00ea\n\31\f\31\16\31\u00ed"+
		"\13\31\3\32\3\32\3\32\3\32\3\33\3\33\5\33\u00f5\n\33\3\33\3\33\3\33\7"+
		"\33\u00fa\n\33\f\33\16\33\u00fd\13\33\3\33\3\33\5\33\u0101\n\33\3\33\3"+
		"\33\3\34\3\34\5\34\u0107\n\34\3\35\3\35\3\35\3\35\3\35\2\3\60\36\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\3\4\2\n\n\f"+
		"\f\u011a\2@\3\2\2\2\4C\3\2\2\2\6P\3\2\2\2\bR\3\2\2\2\n[\3\2\2\2\fw\3\2"+
		"\2\2\16\177\3\2\2\2\20\u0088\3\2\2\2\22\u0094\3\2\2\2\24\u0097\3\2\2\2"+
		"\26\u009e\3\2\2\2\30\u00a2\3\2\2\2\32\u00a9\3\2\2\2\34\u00b3\3\2\2\2\36"+
		"\u00b5\3\2\2\2 \u00bb\3\2\2\2\"\u00bd\3\2\2\2$\u00bf\3\2\2\2&\u00c1\3"+
		"\2\2\2(\u00c5\3\2\2\2*\u00c9\3\2\2\2,\u00d3\3\2\2\2.\u00d5\3\2\2\2\60"+
		"\u00e4\3\2\2\2\62\u00ee\3\2\2\2\64\u00f2\3\2\2\2\66\u0106\3\2\2\28\u0108"+
		"\3\2\2\2:A\7\27\2\2;=\t\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?A\3\2\2\2@:\3\2\2\2@<\3\2\2\2A\3\3\2\2\2BD\5\2\2\2CB\3\2\2\2CD\3\2\2"+
		"\2DE\3\2\2\2EG\5\b\5\2FH\5\2\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\2\2"+
		"\3J\5\3\2\2\2KQ\5\n\6\2LQ\5\16\b\2MQ\5\20\t\2NQ\5\f\7\2OQ\5\22\n\2PK\3"+
		"\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\7\3\2\2\2RX\5\6\4\2ST"+
		"\5\2\2\2TU\5\6\4\2UW\3\2\2\2VS\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y"+
		"\t\3\2\2\2ZX\3\2\2\2[\\\7\31\2\2\\]\5\22\n\2]^\5\2\2\2^`\5\b\5\2_a\5\2"+
		"\2\2`_\3\2\2\2`a\3\2\2\2ak\3\2\2\2bc\7\34\2\2cd\5\22\n\2de\5\2\2\2eg\5"+
		"\b\5\2fh\5\2\2\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ib\3\2\2\2jm\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2ls\3\2\2\2mk\3\2\2\2no\7\33\2\2oq\5\b\5\2pr\5\2\2\2qp"+
		"\3\2\2\2qr\3\2\2\2rt\3\2\2\2sn\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\32\2\2"+
		"v\13\3\2\2\2wx\7!\2\2xy\7\4\2\2yz\7\"\2\2z{\5\22\n\2{|\5\2\2\2|}\5\b\5"+
		"\2}~\7#\2\2~\r\3\2\2\2\177\u0080\7\35\2\2\u0080\u0081\5\22\n\2\u0081\u0082"+
		"\5\2\2\2\u0082\u0084\5\b\5\2\u0083\u0085\5\2\2\2\u0084\u0083\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\36\2\2\u0087\17\3\2\2"+
		"\2\u0088\u0089\7\37\2\2\u0089\u008a\5\22\n\2\u008a\u008b\5\2\2\2\u008b"+
		"\u008d\5\b\5\2\u008c\u008e\5\2\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7 \2\2\u0090\21\3\2\2\2\u0091\u0095"+
		"\5\26\f\2\u0092\u0095\5\24\13\2\u0093\u0095\5\30\r\2\u0094\u0091\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\23\3\2\2\2\u0096\u0098"+
		"\7\4\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\17\2\2\u009c\u009d\5"+
		"\22\n\2\u009d\25\3\2\2\2\u009e\u00a0\5.\30\2\u009f\u00a1\5\22\n\2\u00a0"+
		"\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\27\3\2\2\2\u00a2\u00a6\5\32\16"+
		"\2\u00a3\u00a4\5.\30\2\u00a4\u00a5\5\22\n\2\u00a5\u00a7\3\2\2\2\u00a6"+
		"\u00a3\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\31\3\2\2\2\u00a8\u00aa\5\34\17"+
		"\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00b4\5(\25\2\u00ae\u00b4\5 \21\2\u00af"+
		"\u00b4\5\"\22\2\u00b0\u00b4\5$\23\2\u00b1\u00b4\5&\24\2\u00b2\u00b4\5"+
		"\36\20\2\u00b3\u00ad\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3"+
		"\u00b0\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\35\3\2\2"+
		"\2\u00b5\u00b6\7\20\2\2\u00b6\u00b7\5\22\n\2\u00b7\u00b9\7\21\2\2\u00b8"+
		"\u00ba\5*\26\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\37\3\2\2"+
		"\2\u00bb\u00bc\7\7\2\2\u00bc!\3\2\2\2\u00bd\u00be\7\b\2\2\u00be#\3\2\2"+
		"\2\u00bf\u00c0\7\t\2\2\u00c0%\3\2\2\2\u00c1\u00c3\7\r\2\2\u00c2\u00c4"+
		"\5*\26\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\'\3\2\2\2\u00c5"+
		"\u00c7\7\4\2\2\u00c6\u00c8\5*\26\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8)\3\2\2\2\u00c9\u00cb\7\22\2\2\u00ca\u00cc\5,\27\2\u00cb\u00ca"+
		"\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\23\2\2\u00d0+\3\2\2\2\u00d1\u00d4\7\30\2"+
		"\2\u00d2\u00d4\5\22\n\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"-\3\2\2\2\u00d5\u00da\5\60\31\2\u00d6\u00d8\7$\2\2\u00d7\u00d9\5\62\32"+
		"\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d6"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db/\3\2\2\2\u00dc\u00dd\b\31\1\2\u00dd"+
		"\u00de\7%\2\2\u00de\u00e5\5\60\31\4\u00df\u00e1\7\16\2\2\u00e0\u00e2\5"+
		"\62\32\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e5\5\64\33\2\u00e4\u00dc\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e3\3"+
		"\2\2\2\u00e5\u00eb\3\2\2\2\u00e6\u00e7\f\6\2\2\u00e7\u00e8\7\3\2\2\u00e8"+
		"\u00ea\5\60\31\7\u00e9\u00e6\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\61\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00ef\7\22\2\2\u00ef\u00f0\5\22\n\2\u00f0\u00f1\7\23\2\2\u00f1\63\3\2"+
		"\2\2\u00f2\u00f4\7\24\2\2\u00f3\u00f5\5\2\2\2\u00f4\u00f3\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00fb\3\2\2\2\u00f6\u00f7\5\66\34\2\u00f7\u00f8\5"+
		"\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f6\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fe\u0100\5\22\n\2\u00ff\u0101\5\2\2\2\u0100\u00ff\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\25\2\2\u0103\65\3\2\2"+
		"\2\u0104\u0107\58\35\2\u0105\u0107\5\24\13\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\67\3\2\2\2\u0108\u0109\5\22\n\2\u0109\u010a\7\26"+
		"\2\2\u010a\u010b\5\22\n\2\u010b9\3\2\2\2#>@CGPX`gkqs\u0084\u008d\u0094"+
		"\u0099\u00a0\u00a6\u00ab\u00b3\u00b9\u00c3\u00c7\u00cd\u00d3\u00d8\u00da"+
		"\u00e1\u00e4\u00eb\u00f4\u00fb\u0100\u0106";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}