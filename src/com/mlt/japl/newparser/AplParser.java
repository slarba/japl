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
		T__0=1, ID=2, SIGN=3, INT=4, FLOAT=5, COMPLEX=6, COMMENT=7, WS=8, NL=9, 
		STRING=10, FUNC=11, ASSIGN=12, LPAREN=13, RPAREN=14, LBRACKET=15, RBRACKET=16, 
		LBRACE=17, RBRACE=18, COLON=19, DIAMOND=20, IF=21, ENDIF=22, ELSE=23, 
		ELSEIF=24, WHILE=25, ENDWHILE=26, REPEAT=27, ENDREPEAT=28, FOR=29, IN=30, 
		ENDFOR=31, OPERATOR=32, OUTERPRODUCT=33;
	public static final int
		RULE_sep = 0, RULE_toplevel = 1, RULE_toplevelexpr = 2, RULE_expr_list = 3, 
		RULE_if_expr = 4, RULE_for_expr = 5, RULE_while_expr = 6, RULE_repeat_expr = 7, 
		RULE_arrayexpr = 8, RULE_assignment = 9, RULE_monadic_call_or_niladic = 10, 
		RULE_dyadic_call_or_array = 11, RULE_array = 12, RULE_arrayitem = 13, 
		RULE_subarrayexpr = 14, RULE_integer = 15, RULE_floating = 16, RULE_complexnum = 17, 
		RULE_string = 18, RULE_ident = 19, RULE_index = 20, RULE_func_operator = 21, 
		RULE_func = 22, RULE_outerproduct = 23, RULE_lambdafunc = 24, RULE_guard_or_assignment = 25, 
		RULE_guard = 26;
	public static final String[] ruleNames = {
		"sep", "toplevel", "toplevelexpr", "expr_list", "if_expr", "for_expr", 
		"while_expr", "repeat_expr", "arrayexpr", "assignment", "monadic_call_or_niladic", 
		"dyadic_call_or_array", "array", "arrayitem", "subarrayexpr", "integer", 
		"floating", "complexnum", "string", "ident", "index", "func_operator", 
		"func", "outerproduct", "lambdafunc", "guard_or_assignment", "guard"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", null, "'\\u00af'", null, null, null, null, null, "'\n'", 
		null, null, "'\\u2190'", "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", 
		"'\\u22C4'", "':If'", null, "':Else'", "':ElseIf'", "':While'", null, 
		"':Repeat'", null, "':For'", "':In'", null, null, "'\\u2218.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ID", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", "WS", 
		"NL", "STRING", "FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
		"LBRACE", "RBRACE", "COLON", "DIAMOND", "IF", "ENDIF", "ELSE", "ELSEIF", 
		"WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", "FOR", "IN", "ENDFOR", "OPERATOR", 
		"OUTERPRODUCT"
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
			setState(60);
			switch (_input.LA(1)) {
			case DIAMOND:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(DIAMOND);
				}
				break;
			case COMMENT:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(55);
					_la = _input.LA(1);
					if ( !(_la==COMMENT || _la==NL) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(58); 
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
			setState(63);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(62);
				sep();
				}
			}

			setState(65);
			expr_list();
			setState(67);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(66);
				sep();
				}
			}

			setState(69);
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
			setState(76);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				if_expr();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				while_expr();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				repeat_expr();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
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
				setState(75);
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
			setState(78);
			toplevelexpr();
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(79);
					sep();
					setState(80);
					toplevelexpr();
					}
					} 
				}
				setState(86);
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
			setState(87);
			match(IF);
			setState(88);
			((If_exprContext)_localctx).condition = arrayexpr();
			setState(89);
			sep();
			setState(90);
			((If_exprContext)_localctx).thenbranch = expr_list();
			setState(92);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(91);
				sep();
				}
			}

			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(94);
				match(ELSEIF);
				setState(95);
				((If_exprContext)_localctx).elifcondition = arrayexpr();
				setState(96);
				sep();
				setState(97);
				((If_exprContext)_localctx).elifthenbranch = expr_list();
				setState(99);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(98);
					sep();
					}
				}

				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(106);
				match(ELSE);
				setState(107);
				((If_exprContext)_localctx).elsebranch = expr_list();
				setState(109);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(108);
					sep();
					}
				}

				}
			}

			setState(113);
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
			setState(115);
			match(FOR);
			setState(116);
			match(ID);
			setState(117);
			match(IN);
			setState(118);
			arrayexpr();
			setState(119);
			sep();
			setState(120);
			expr_list();
			setState(121);
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
			setState(123);
			match(WHILE);
			setState(124);
			arrayexpr();
			setState(125);
			sep();
			setState(126);
			expr_list();
			setState(128);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(127);
				sep();
				}
			}

			setState(130);
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
			setState(132);
			match(REPEAT);
			setState(133);
			arrayexpr();
			setState(134);
			sep();
			setState(135);
			expr_list();
			setState(137);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(136);
				sep();
				}
			}

			setState(139);
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
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				monadic_call_or_niladic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
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
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				match(ID);
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(151);
			match(ASSIGN);
			setState(152);
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
			setState(154);
			func_operator();
			setState(156);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << FUNC) | (1L << LPAREN) | (1L << LBRACE) | (1L << OUTERPRODUCT))) != 0)) {
				{
				setState(155);
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
			setState(158);
			((Dyadic_call_or_arrayContext)_localctx).l = array();
			setState(162);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC) | (1L << LBRACE) | (1L << OUTERPRODUCT))) != 0)) {
				{
				setState(159);
				((Dyadic_call_or_arrayContext)_localctx).fn = func_operator();
				setState(160);
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
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				arrayitem();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << LPAREN))) != 0) );
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
			setState(175);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				ident();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				floating();
				}
				break;
			case COMPLEX:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				complexnum();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				string();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
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
			setState(177);
			match(LPAREN);
			setState(178);
			arrayexpr();
			setState(179);
			match(RPAREN);
			setState(181);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(180);
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
			setState(183);
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
			setState(185);
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
			setState(187);
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
			setState(189);
			match(STRING);
			setState(191);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(190);
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
			setState(193);
			match(ID);
			setState(195);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(194);
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
		enterRule(_localctx, 40, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(LBRACKET);
			setState(198);
			arrayexpr();
			setState(199);
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
		enterRule(_localctx, 42, RULE_func_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			func(0);
			setState(203);
			_la = _input.LA(1);
			if (_la==OPERATOR) {
				{
				setState(202);
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
		public OuterproductContext outerproduct() {
			return getRuleContext(OuterproductContext.class,0);
		}
		public LambdafuncContext lambdafunc() {
			return getRuleContext(LambdafuncContext.class,0);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
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
		return func(0);
	}

	private FuncContext func(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FuncContext _localctx = new FuncContext(_ctx, _parentState);
		FuncContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_func, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch (_input.LA(1)) {
			case FUNC:
				{
				setState(206);
				match(FUNC);
				}
				break;
			case OUTERPRODUCT:
				{
				setState(207);
				outerproduct();
				}
				break;
			case LBRACE:
				{
				setState(208);
				lambdafunc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FuncContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_func);
					setState(211);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(212);
					match(T__0);
					setState(213);
					func(5);
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class OuterproductContext extends ParserRuleContext {
		public TerminalNode OUTERPRODUCT() { return getToken(AplParser.OUTERPRODUCT, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public OuterproductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerproduct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitOuterproduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OuterproductContext outerproduct() throws RecognitionException {
		OuterproductContext _localctx = new OuterproductContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_outerproduct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(OUTERPRODUCT);
			setState(220);
			func(0);
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
		enterRule(_localctx, 48, RULE_lambdafunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(LBRACE);
			setState(224);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(223);
				sep();
				}
			}

			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(226);
					guard_or_assignment();
					setState(227);
					sep();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(234);
			arrayexpr();
			setState(236);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(235);
				sep();
				}
			}

			setState(238);
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
		enterRule(_localctx, 50, RULE_guard_or_assignment);
		try {
			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				guard();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
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
		enterRule(_localctx, 52, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			arrayexpr();
			setState(245);
			match(COLON);
			setState(246);
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
		case 22:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u00fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\6\2;\n\2\r\2\16\2<\5\2?\n\2\3\3"+
		"\5\3B\n\3\3\3\3\3\5\3F\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3"+
		"\5\3\5\3\5\7\5U\n\5\f\5\16\5X\13\5\3\6\3\6\3\6\3\6\3\6\5\6_\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6f\n\6\7\6h\n\6\f\6\16\6k\13\6\3\6\3\6\3\6\5\6p\n\6\5"+
		"\6r\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u0083\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\t\3\t\3\n\3\n"+
		"\3\n\5\n\u0093\n\n\3\13\6\13\u0096\n\13\r\13\16\13\u0097\3\13\3\13\3\13"+
		"\3\f\3\f\5\f\u009f\n\f\3\r\3\r\3\r\3\r\5\r\u00a5\n\r\3\16\6\16\u00a8\n"+
		"\16\r\16\16\16\u00a9\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b2\n\17\3\20"+
		"\3\20\3\20\3\20\5\20\u00b8\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\5\24\u00c2\n\24\3\25\3\25\5\25\u00c6\n\25\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\5\27\u00ce\n\27\3\30\3\30\3\30\3\30\5\30\u00d4\n\30\3\30\3\30\3\30"+
		"\7\30\u00d9\n\30\f\30\16\30\u00dc\13\30\3\31\3\31\3\31\3\32\3\32\5\32"+
		"\u00e3\n\32\3\32\3\32\3\32\7\32\u00e8\n\32\f\32\16\32\u00eb\13\32\3\32"+
		"\3\32\5\32\u00ef\n\32\3\32\3\32\3\33\3\33\5\33\u00f5\n\33\3\34\3\34\3"+
		"\34\3\34\3\34\2\3.\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\66\2\3\4\2\t\t\13\13\u0105\2>\3\2\2\2\4A\3\2\2\2\6N\3\2\2\2"+
		"\bP\3\2\2\2\nY\3\2\2\2\fu\3\2\2\2\16}\3\2\2\2\20\u0086\3\2\2\2\22\u0092"+
		"\3\2\2\2\24\u0095\3\2\2\2\26\u009c\3\2\2\2\30\u00a0\3\2\2\2\32\u00a7\3"+
		"\2\2\2\34\u00b1\3\2\2\2\36\u00b3\3\2\2\2 \u00b9\3\2\2\2\"\u00bb\3\2\2"+
		"\2$\u00bd\3\2\2\2&\u00bf\3\2\2\2(\u00c3\3\2\2\2*\u00c7\3\2\2\2,\u00cb"+
		"\3\2\2\2.\u00d3\3\2\2\2\60\u00dd\3\2\2\2\62\u00e0\3\2\2\2\64\u00f4\3\2"+
		"\2\2\66\u00f6\3\2\2\28?\7\26\2\29;\t\2\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2"+
		"\2<=\3\2\2\2=?\3\2\2\2>8\3\2\2\2>:\3\2\2\2?\3\3\2\2\2@B\5\2\2\2A@\3\2"+
		"\2\2AB\3\2\2\2BC\3\2\2\2CE\5\b\5\2DF\5\2\2\2ED\3\2\2\2EF\3\2\2\2FG\3\2"+
		"\2\2GH\7\2\2\3H\5\3\2\2\2IO\5\n\6\2JO\5\16\b\2KO\5\20\t\2LO\5\f\7\2MO"+
		"\5\22\n\2NI\3\2\2\2NJ\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\7\3\2\2\2"+
		"PV\5\6\4\2QR\5\2\2\2RS\5\6\4\2SU\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2W\t\3\2\2\2XV\3\2\2\2YZ\7\27\2\2Z[\5\22\n\2[\\\5\2\2\2\\^\5"+
		"\b\5\2]_\5\2\2\2^]\3\2\2\2^_\3\2\2\2_i\3\2\2\2`a\7\32\2\2ab\5\22\n\2b"+
		"c\5\2\2\2ce\5\b\5\2df\5\2\2\2ed\3\2\2\2ef\3\2\2\2fh\3\2\2\2g`\3\2\2\2"+
		"hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jq\3\2\2\2ki\3\2\2\2lm\7\31\2\2mo\5\b\5"+
		"\2np\5\2\2\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2ql\3\2\2\2qr\3\2\2\2rs\3\2\2"+
		"\2st\7\30\2\2t\13\3\2\2\2uv\7\37\2\2vw\7\4\2\2wx\7 \2\2xy\5\22\n\2yz\5"+
		"\2\2\2z{\5\b\5\2{|\7!\2\2|\r\3\2\2\2}~\7\33\2\2~\177\5\22\n\2\177\u0080"+
		"\5\2\2\2\u0080\u0082\5\b\5\2\u0081\u0083\5\2\2\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\34\2\2\u0085\17\3\2\2"+
		"\2\u0086\u0087\7\35\2\2\u0087\u0088\5\22\n\2\u0088\u0089\5\2\2\2\u0089"+
		"\u008b\5\b\5\2\u008a\u008c\5\2\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\36\2\2\u008e\21\3\2\2\2\u008f\u0093"+
		"\5\26\f\2\u0090\u0093\5\24\13\2\u0091\u0093\5\30\r\2\u0092\u008f\3\2\2"+
		"\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\23\3\2\2\2\u0094\u0096"+
		"\7\4\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\16\2\2\u009a\u009b\5"+
		"\22\n\2\u009b\25\3\2\2\2\u009c\u009e\5,\27\2\u009d\u009f\5\22\n\2\u009e"+
		"\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u00a4\5\32\16"+
		"\2\u00a1\u00a2\5,\27\2\u00a2\u00a3\5\22\n\2\u00a3\u00a5\3\2\2\2\u00a4"+
		"\u00a1\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a8\5\34\17"+
		"\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\33\3\2\2\2\u00ab\u00b2\5(\25\2\u00ac\u00b2\5 \21\2\u00ad"+
		"\u00b2\5\"\22\2\u00ae\u00b2\5$\23\2\u00af\u00b2\5&\24\2\u00b0\u00b2\5"+
		"\36\20\2\u00b1\u00ab\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1"+
		"\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\35\3\2\2"+
		"\2\u00b3\u00b4\7\17\2\2\u00b4\u00b5\5\22\n\2\u00b5\u00b7\7\20\2\2\u00b6"+
		"\u00b8\5*\26\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\37\3\2\2"+
		"\2\u00b9\u00ba\7\6\2\2\u00ba!\3\2\2\2\u00bb\u00bc\7\7\2\2\u00bc#\3\2\2"+
		"\2\u00bd\u00be\7\b\2\2\u00be%\3\2\2\2\u00bf\u00c1\7\f\2\2\u00c0\u00c2"+
		"\5*\26\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\'\3\2\2\2\u00c3"+
		"\u00c5\7\4\2\2\u00c4\u00c6\5*\26\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6)\3\2\2\2\u00c7\u00c8\7\21\2\2\u00c8\u00c9\5\22\n\2\u00c9\u00ca"+
		"\7\22\2\2\u00ca+\3\2\2\2\u00cb\u00cd\5.\30\2\u00cc\u00ce\7\"\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce-\3\2\2\2\u00cf\u00d0\b\30\1\2"+
		"\u00d0\u00d4\7\r\2\2\u00d1\u00d4\5\60\31\2\u00d2\u00d4\5\62\32\2\u00d3"+
		"\u00cf\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00da\3\2"+
		"\2\2\u00d5\u00d6\f\6\2\2\u00d6\u00d7\7\3\2\2\u00d7\u00d9\5.\30\7\u00d8"+
		"\u00d5\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db/\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7#\2\2\u00de\u00df"+
		"\5.\30\2\u00df\61\3\2\2\2\u00e0\u00e2\7\23\2\2\u00e1\u00e3\5\2\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e9\3\2\2\2\u00e4\u00e5\5\64"+
		"\33\2\u00e5\u00e6\5\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\5\22\n\2\u00ed\u00ef\5\2\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7\24"+
		"\2\2\u00f1\63\3\2\2\2\u00f2\u00f5\5\66\34\2\u00f3\u00f5\5\24\13\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\65\3\2\2\2\u00f6\u00f7\5\22\n"+
		"\2\u00f7\u00f8\7\25\2\2\u00f8\u00f9\5\22\n\2\u00f9\67\3\2\2\2\37<>AEN"+
		"V^eioq\u0082\u008b\u0092\u0097\u009e\u00a4\u00a9\u00b1\u00b7\u00c1\u00c5"+
		"\u00cd\u00d3\u00da\u00e2\u00e9\u00ee\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}