// Generated from /Users/markolau/IdeaProjects/Japl/src/com/mlt/japl/newparser/Apl.g4 by ANTLR 4.5.1
package com.mlt.japl.newparser;

import java.util.*;
import com.mlt.japl.workspace.EvalContext;
import com.mlt.japl.newast.AstFunc;

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
		ENDREPEAT=30, FOR=31, IN=32, ENDFOR=33, OPERATOR=34, OUTERPRODUCT=35, 
		DEL=36;
	public static final int
		RULE_sep = 0, RULE_toplevel = 1, RULE_toplevelexpr = 2, RULE_expr_list = 3, 
		RULE_if_expr = 4, RULE_for_expr = 5, RULE_while_expr = 6, RULE_repeat_expr = 7, 
		RULE_arrayexpr = 8, RULE_assignment = 9, RULE_monadic_call_or_niladic = 10, 
		RULE_dyadic_call_or_array = 11, RULE_array = 12, RULE_arrayitem = 13, 
		RULE_subarrayexpr = 14, RULE_integer = 15, RULE_floating = 16, RULE_complexnum = 17, 
		RULE_string = 18, RULE_ident = 19, RULE_index = 20, RULE_indexelement = 21, 
		RULE_func_operator = 22, RULE_func = 23, RULE_axis = 24, RULE_lambdafunc = 25, 
		RULE_toplevelfunc = 26, RULE_localslist = 27, RULE_guard_or_assignment = 28, 
		RULE_guard = 29;
	public static final String[] ruleNames = {
		"sep", "toplevel", "toplevelexpr", "expr_list", "if_expr", "for_expr", 
		"while_expr", "repeat_expr", "arrayexpr", "assignment", "monadic_call_or_niladic", 
		"dyadic_call_or_array", "array", "arrayitem", "subarrayexpr", "integer", 
		"floating", "complexnum", "string", "ident", "index", "indexelement", 
		"func_operator", "func", "axis", "lambdafunc", "toplevelfunc", "localslist", 
		"guard_or_assignment", "guard"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", null, null, "'\\u00af'", null, null, null, null, null, "'\n'", 
		null, null, "'\\u2190'", "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", 
		"'\\u22C4'", "';'", "':If'", null, "':Else'", "':ElseIf'", "':While'", 
		null, "':Repeat'", null, "':For'", "':In'", null, null, "'\\u2218.'", 
		"'\\u2207'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ID", "LABEL", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", 
		"WS", "NL", "STRING", "FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", 
		"RBRACKET", "LBRACE", "RBRACE", "COLON", "DIAMOND", "SEMICOLON", "IF", 
		"ENDIF", "ELSE", "ELSEIF", "WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", 
		"FOR", "IN", "ENDFOR", "OPERATOR", "OUTERPRODUCT", "DEL"
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


	    EvalContext context;
	    Stack<HashSet<String>> localFunctions;

	    public AplParser(TokenStream input, EvalContext context) {
	        this(input);
	        this.context = context;
	        localFunctions = new Stack<HashSet<String>>();
	        localFunctions.push(new HashSet<String>());
	    }

	    private void enterLambdaContext() {
	        localFunctions.push(new HashSet<String>(localFunctions.peek()));
	    }

	    private void exitLambdaContext() {
	        localFunctions.pop();
	    }

	    private void registerLocalFunction(String name, AstFunc fn) {
	        localFunctions.peek().add(name);
	    }

	    private boolean isFnSymbol() {
	        String sym = getCurrentToken().getText();
	        return context.isBoundToFunction(sym) || localFunctions.peek().contains(sym);
	    }

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
			int _alt;
			setState(66);
			switch (_input.LA(1)) {
			case DIAMOND:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(DIAMOND);
				}
				break;
			case COMMENT:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(61);
						_la = _input.LA(1);
						if ( !(_la==COMMENT || _la==NL) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(64); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(68);
				sep();
				}
				break;
			}
			setState(71);
			expr_list();
			setState(73);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(72);
				sep();
				}
			}

			setState(75);
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
		public ToplevelfuncContext toplevelfunc() {
			return getRuleContext(ToplevelfuncContext.class,0);
		}
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
			setState(83);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				toplevelfunc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				if_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				while_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				repeat_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				for_expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				arrayexpr();
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

	public static class Expr_listContext extends ParserRuleContext {
		public List<ToplevelexprContext> toplevelexpr() {
			return getRuleContexts(ToplevelexprContext.class);
		}
		public ToplevelexprContext toplevelexpr(int i) {
			return getRuleContext(ToplevelexprContext.class,i);
		}
		public List<TerminalNode> LABEL() { return getTokens(AplParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(AplParser.LABEL, i);
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
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(85);
				match(LABEL);
				}
				break;
			}
			setState(88);
			toplevelexpr();
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					sep();
					setState(91);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(90);
						match(LABEL);
						}
						break;
					}
					setState(93);
					toplevelexpr();
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			setState(100);
			match(IF);
			setState(101);
			((If_exprContext)_localctx).condition = arrayexpr();
			setState(102);
			sep();
			setState(103);
			((If_exprContext)_localctx).thenbranch = expr_list();
			setState(105);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(104);
				sep();
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(107);
				match(ELSEIF);
				setState(108);
				((If_exprContext)_localctx).elifcondition = arrayexpr();
				setState(109);
				sep();
				setState(110);
				((If_exprContext)_localctx).elifthenbranch = expr_list();
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(111);
					sep();
					}
				}

				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(119);
				match(ELSE);
				setState(120);
				((If_exprContext)_localctx).elsebranch = expr_list();
				setState(122);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(121);
					sep();
					}
				}

				}
			}

			setState(126);
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
			setState(128);
			match(FOR);
			setState(129);
			match(ID);
			setState(130);
			match(IN);
			setState(131);
			arrayexpr();
			setState(132);
			sep();
			setState(133);
			expr_list();
			setState(134);
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
			setState(136);
			match(WHILE);
			setState(137);
			arrayexpr();
			setState(138);
			sep();
			setState(139);
			expr_list();
			setState(141);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(140);
				sep();
				}
			}

			setState(143);
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
			setState(145);
			match(REPEAT);
			setState(146);
			arrayexpr();
			setState(147);
			sep();
			setState(148);
			expr_list();
			setState(150);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(149);
				sep();
				}
			}

			setState(152);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Monadic_call_or_niladicContext monadic_call_or_niladic() {
			return getRuleContext(Monadic_call_or_niladicContext.class,0);
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
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				monadic_call_or_niladic();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
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
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrandassignmentContext extends AssignmentContext {
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AplParser.ID, i);
		}
		public StrandassignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitStrandassignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FnassignmentContext extends AssignmentContext {
		public Token ID;
		public TerminalNode ID() { return getToken(AplParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public Func_operatorContext func_operator() {
			return getRuleContext(Func_operatorContext.class,0);
		}
		public FnassignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFnassignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		int _la;
		try {
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new FnassignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				((FnassignmentContext)_localctx).ID = match(ID);
				setState(160);
				match(ASSIGN);
				 registerLocalFunction((((FnassignmentContext)_localctx).ID!=null?((FnassignmentContext)_localctx).ID.getText():null), null); 
				setState(162);
				func_operator();
				}
				break;
			case 2:
				_localctx = new StrandassignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(163);
					match(ID);
					}
					}
					setState(166); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(168);
				match(ASSIGN);
				setState(169);
				arrayexpr();
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
			setState(172);
			func_operator();
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(173);
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
			setState(176);
			((Dyadic_call_or_arrayContext)_localctx).l = array();
			setState(180);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(177);
				((Dyadic_call_or_arrayContext)_localctx).fn = func_operator();
				setState(178);
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
			setState(183); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(182);
					arrayitem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(185); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				integer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				floating();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				complexnum();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				string();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(192);
				subarrayexpr();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(LPAREN);
			setState(196);
			arrayexpr();
			setState(197);
			match(RPAREN);
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(198);
				index();
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
			setState(201);
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
			setState(203);
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
			setState(205);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(STRING);
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(208);
				index();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			if (!(!isFnSymbol())) throw new FailedPredicateException(this, "!isFnSymbol()");
			setState(212);
			match(ID);
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(213);
				index();
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(LBRACKET);
			setState(218); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(217);
					indexelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(220); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(222);
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
			setState(226);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				arrayexpr();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			func(0);
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(229);
				match(OPERATOR);
				setState(231);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(230);
					axis();
					}
					break;
				}
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
	public static class IdfuncContext extends FuncContext {
		public TerminalNode ID() { return getToken(AplParser.ID, 0); }
		public IdfuncContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitIdfunc(this);
			else return visitor.visitChildren(this);
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
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new OuterproductContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(236);
				match(OUTERPRODUCT);
				setState(237);
				func(2);
				}
				break;
			case 2:
				{
				_localctx = new SimplefuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(FUNC);
				setState(240);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(239);
					axis();
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new IdfuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				if (!(isFnSymbol())) throw new FailedPredicateException(this, "isFnSymbol()");
				setState(243);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new LambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				lambdafunc();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InnerprodContext(new FuncContext(_parentctx, _parentState));
					((InnerprodContext)_localctx).outer = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_func);
					setState(247);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(248);
					match(T__0);
					setState(249);
					((InnerprodContext)_localctx).inner = func(6);
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
			setState(255);
			match(LBRACKET);
			setState(256);
			arrayexpr();
			setState(257);
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
			setState(259);
			match(LBRACE);
			 enterLambdaContext(); 
			setState(262);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(261);
				sep();
				}
				break;
			}
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(264);
					guard_or_assignment();
					setState(265);
					sep();
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(272);
			arrayexpr();
			setState(274);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(273);
				sep();
				}
			}

			setState(276);
			match(RBRACE);
			 exitLambdaContext(); 
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

	public static class ToplevelfuncContext extends ParserRuleContext {
		public Token ret;
		public Token a;
		public Token b;
		public Token c;
		public List<TerminalNode> DEL() { return getTokens(AplParser.DEL); }
		public TerminalNode DEL(int i) {
			return getToken(AplParser.DEL, i);
		}
		public LocalslistContext localslist() {
			return getRuleContext(LocalslistContext.class,0);
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
		public List<TerminalNode> ID() { return getTokens(AplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AplParser.ID, i);
		}
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public ToplevelfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toplevelfunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitToplevelfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToplevelfuncContext toplevelfunc() throws RecognitionException {
		ToplevelfuncContext _localctx = new ToplevelfuncContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_toplevelfunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(DEL);
			setState(282);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(280);
				((ToplevelfuncContext)_localctx).ret = match(ID);
				setState(281);
				match(ASSIGN);
				}
				break;
			}
			setState(284);
			((ToplevelfuncContext)_localctx).a = match(ID);
			setState(285);
			((ToplevelfuncContext)_localctx).b = match(ID);
			setState(287);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(286);
				((ToplevelfuncContext)_localctx).c = match(ID);
				}
			}

			setState(289);
			localslist();
			setState(290);
			sep();
			 enterLambdaContext(); 
			setState(292);
			expr_list();
			setState(294);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(293);
				sep();
				}
			}

			setState(296);
			match(DEL);
			 exitLambdaContext(); 
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

	public static class LocalslistContext extends ParserRuleContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(AplParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AplParser.SEMICOLON, i);
		}
		public List<TerminalNode> ID() { return getTokens(AplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AplParser.ID, i);
		}
		public LocalslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localslist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitLocalslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalslistContext localslist() throws RecognitionException {
		LocalslistContext _localctx = new LocalslistContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_localslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(299);
				match(SEMICOLON);
				setState(300);
				match(ID);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		enterRule(_localctx, 56, RULE_guard_or_assignment);
		try {
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				guard();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
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
		enterRule(_localctx, 58, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			arrayexpr();
			setState(311);
			match(COLON);
			setState(312);
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
		case 19:
			return ident_sempred((IdentContext)_localctx, predIndex);
		case 23:
			return func_sempred((FuncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ident_sempred(IdentContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return !isFnSymbol();
		}
		return true;
	}
	private boolean func_sempred(FuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isFnSymbol();
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u013d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\6"+
		"\2A\n\2\r\2\16\2B\5\2E\n\2\3\3\5\3H\n\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4V\n\4\3\5\5\5Y\n\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5"+
		"\7\5b\n\5\f\5\16\5e\13\5\3\6\3\6\3\6\3\6\3\6\5\6l\n\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6s\n\6\7\6u\n\6\f\6\16\6x\13\6\3\6\3\6\3\6\5\6}\n\6\5\6\177\n\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\u0090"+
		"\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u0099\n\t\3\t\3\t\3\n\3\n\3\n\5\n"+
		"\u00a0\n\n\3\13\3\13\3\13\3\13\3\13\6\13\u00a7\n\13\r\13\16\13\u00a8\3"+
		"\13\3\13\5\13\u00ad\n\13\3\f\3\f\5\f\u00b1\n\f\3\r\3\r\3\r\3\r\5\r\u00b7"+
		"\n\r\3\16\6\16\u00ba\n\16\r\16\16\16\u00bb\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00c4\n\17\3\20\3\20\3\20\3\20\5\20\u00ca\n\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\5\24\u00d4\n\24\3\25\3\25\3\25\5\25\u00d9\n"+
		"\25\3\26\3\26\6\26\u00dd\n\26\r\26\16\26\u00de\3\26\3\26\3\27\3\27\5\27"+
		"\u00e5\n\27\3\30\3\30\3\30\5\30\u00ea\n\30\5\30\u00ec\n\30\3\31\3\31\3"+
		"\31\3\31\3\31\5\31\u00f3\n\31\3\31\3\31\3\31\5\31\u00f8\n\31\3\31\3\31"+
		"\3\31\7\31\u00fd\n\31\f\31\16\31\u0100\13\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\5\33\u0109\n\33\3\33\3\33\3\33\7\33\u010e\n\33\f\33\16\33\u0111"+
		"\13\33\3\33\3\33\5\33\u0115\n\33\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u011d"+
		"\n\34\3\34\3\34\3\34\5\34\u0122\n\34\3\34\3\34\3\34\3\34\3\34\5\34\u0129"+
		"\n\34\3\34\3\34\3\34\3\35\3\35\7\35\u0130\n\35\f\35\16\35\u0133\13\35"+
		"\3\36\3\36\5\36\u0137\n\36\3\37\3\37\3\37\3\37\3\37\2\3\60 \2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\3\4\2\n\n\f\f"+
		"\u0151\2D\3\2\2\2\4G\3\2\2\2\6U\3\2\2\2\bX\3\2\2\2\nf\3\2\2\2\f\u0082"+
		"\3\2\2\2\16\u008a\3\2\2\2\20\u0093\3\2\2\2\22\u009f\3\2\2\2\24\u00ac\3"+
		"\2\2\2\26\u00ae\3\2\2\2\30\u00b2\3\2\2\2\32\u00b9\3\2\2\2\34\u00c3\3\2"+
		"\2\2\36\u00c5\3\2\2\2 \u00cb\3\2\2\2\"\u00cd\3\2\2\2$\u00cf\3\2\2\2&\u00d1"+
		"\3\2\2\2(\u00d5\3\2\2\2*\u00da\3\2\2\2,\u00e4\3\2\2\2.\u00e6\3\2\2\2\60"+
		"\u00f7\3\2\2\2\62\u0101\3\2\2\2\64\u0105\3\2\2\2\66\u0119\3\2\2\28\u0131"+
		"\3\2\2\2:\u0136\3\2\2\2<\u0138\3\2\2\2>E\7\27\2\2?A\t\2\2\2@?\3\2\2\2"+
		"AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2D>\3\2\2\2D@\3\2\2\2E\3\3\2\2"+
		"\2FH\5\2\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IK\5\b\5\2JL\5\2\2\2KJ\3\2\2"+
		"\2KL\3\2\2\2LM\3\2\2\2MN\7\2\2\3N\5\3\2\2\2OV\5\66\34\2PV\5\n\6\2QV\5"+
		"\16\b\2RV\5\20\t\2SV\5\f\7\2TV\5\22\n\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2"+
		"UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\7\3\2\2\2WY\7\5\2\2XW\3\2\2\2XY\3\2\2"+
		"\2YZ\3\2\2\2Zc\5\6\4\2[]\5\2\2\2\\^\7\5\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2"+
		"\2\2_`\5\6\4\2`b\3\2\2\2a[\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\t\3"+
		"\2\2\2ec\3\2\2\2fg\7\31\2\2gh\5\22\n\2hi\5\2\2\2ik\5\b\5\2jl\5\2\2\2k"+
		"j\3\2\2\2kl\3\2\2\2lv\3\2\2\2mn\7\34\2\2no\5\22\n\2op\5\2\2\2pr\5\b\5"+
		"\2qs\5\2\2\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tm\3\2\2\2ux\3\2\2\2vt\3\2\2"+
		"\2vw\3\2\2\2w~\3\2\2\2xv\3\2\2\2yz\7\33\2\2z|\5\b\5\2{}\5\2\2\2|{\3\2"+
		"\2\2|}\3\2\2\2}\177\3\2\2\2~y\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\7\32\2\2\u0081\13\3\2\2\2\u0082\u0083\7!\2\2\u0083\u0084\7\4\2"+
		"\2\u0084\u0085\7\"\2\2\u0085\u0086\5\22\n\2\u0086\u0087\5\2\2\2\u0087"+
		"\u0088\5\b\5\2\u0088\u0089\7#\2\2\u0089\r\3\2\2\2\u008a\u008b\7\35\2\2"+
		"\u008b\u008c\5\22\n\2\u008c\u008d\5\2\2\2\u008d\u008f\5\b\5\2\u008e\u0090"+
		"\5\2\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\7\36\2\2\u0092\17\3\2\2\2\u0093\u0094\7\37\2\2\u0094\u0095\5\22"+
		"\n\2\u0095\u0096\5\2\2\2\u0096\u0098\5\b\5\2\u0097\u0099\5\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7 "+
		"\2\2\u009b\21\3\2\2\2\u009c\u00a0\5\24\13\2\u009d\u00a0\5\26\f\2\u009e"+
		"\u00a0\5\30\r\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3"+
		"\2\2\2\u00a0\23\3\2\2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a3\7\17\2\2\u00a3"+
		"\u00a4\b\13\1\2\u00a4\u00ad\5.\30\2\u00a5\u00a7\7\4\2\2\u00a6\u00a5\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\7\17\2\2\u00ab\u00ad\5\22\n\2\u00ac\u00a1\3"+
		"\2\2\2\u00ac\u00a6\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00b0\5.\30\2\u00af"+
		"\u00b1\5\22\n\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\27\3\2\2"+
		"\2\u00b2\u00b6\5\32\16\2\u00b3\u00b4\5.\30\2\u00b4\u00b5\5\22\n\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\31\3\2\2"+
		"\2\u00b8\u00ba\5\34\17\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\33\3\2\2\2\u00bd\u00c4\5(\25"+
		"\2\u00be\u00c4\5 \21\2\u00bf\u00c4\5\"\22\2\u00c0\u00c4\5$\23\2\u00c1"+
		"\u00c4\5&\24\2\u00c2\u00c4\5\36\20\2\u00c3\u00bd\3\2\2\2\u00c3\u00be\3"+
		"\2\2\2\u00c3\u00bf\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c2\3\2\2\2\u00c4\35\3\2\2\2\u00c5\u00c6\7\20\2\2\u00c6\u00c7\5\22"+
		"\n\2\u00c7\u00c9\7\21\2\2\u00c8\u00ca\5*\26\2\u00c9\u00c8\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\37\3\2\2\2\u00cb\u00cc\7\7\2\2\u00cc!\3\2\2\2\u00cd"+
		"\u00ce\7\b\2\2\u00ce#\3\2\2\2\u00cf\u00d0\7\t\2\2\u00d0%\3\2\2\2\u00d1"+
		"\u00d3\7\r\2\2\u00d2\u00d4\5*\26\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\'\3\2\2\2\u00d5\u00d6\6\25\2\2\u00d6\u00d8\7\4\2\2\u00d7\u00d9"+
		"\5*\26\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9)\3\2\2\2\u00da"+
		"\u00dc\7\22\2\2\u00db\u00dd\5,\27\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3"+
		"\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\7\23\2\2\u00e1+\3\2\2\2\u00e2\u00e5\7\30\2\2\u00e3\u00e5\5\22\n"+
		"\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5-\3\2\2\2\u00e6\u00eb"+
		"\5\60\31\2\u00e7\u00e9\7$\2\2\u00e8\u00ea\5\62\32\2\u00e9\u00e8\3\2\2"+
		"\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec/\3\2\2\2\u00ed\u00ee\b\31\1\2\u00ee\u00ef\7%\2\2\u00ef"+
		"\u00f8\5\60\31\4\u00f0\u00f2\7\16\2\2\u00f1\u00f3\5\62\32\2\u00f2\u00f1"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f8\3\2\2\2\u00f4\u00f5\6\31\3\2"+
		"\u00f5\u00f8\7\4\2\2\u00f6\u00f8\5\64\33\2\u00f7\u00ed\3\2\2\2\u00f7\u00f0"+
		"\3\2\2\2\u00f7\u00f4\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fe\3\2\2\2\u00f9"+
		"\u00fa\f\7\2\2\u00fa\u00fb\7\3\2\2\u00fb\u00fd\5\60\31\b\u00fc\u00f9\3"+
		"\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\61\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\7\22\2\2\u0102\u0103\5\22"+
		"\n\2\u0103\u0104\7\23\2\2\u0104\63\3\2\2\2\u0105\u0106\7\24\2\2\u0106"+
		"\u0108\b\33\1\2\u0107\u0109\5\2\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3"+
		"\2\2\2\u0109\u010f\3\2\2\2\u010a\u010b\5:\36\2\u010b\u010c\5\2\2\2\u010c"+
		"\u010e\3\2\2\2\u010d\u010a\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0114\5\22\n\2\u0113\u0115\5\2\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3"+
		"\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\25\2\2\u0117\u0118\b\33\1\2\u0118"+
		"\65\3\2\2\2\u0119\u011c\7&\2\2\u011a\u011b\7\4\2\2\u011b\u011d\7\17\2"+
		"\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f"+
		"\7\4\2\2\u011f\u0121\7\4\2\2\u0120\u0122\7\4\2\2\u0121\u0120\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\58\35\2\u0124\u0125\5\2"+
		"\2\2\u0125\u0126\b\34\1\2\u0126\u0128\5\b\5\2\u0127\u0129\5\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7&"+
		"\2\2\u012b\u012c\b\34\1\2\u012c\67\3\2\2\2\u012d\u012e\7\30\2\2\u012e"+
		"\u0130\7\4\2\2\u012f\u012d\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u01329\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0137"+
		"\5<\37\2\u0135\u0137\5\24\13\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2"+
		"\u0137;\3\2\2\2\u0138\u0139\5\22\n\2\u0139\u013a\7\26\2\2\u013a\u013b"+
		"\5\22\n\2\u013b=\3\2\2\2*BDGKUX]ckrv|~\u008f\u0098\u009f\u00a8\u00ac\u00b0"+
		"\u00b6\u00bb\u00c3\u00c9\u00d3\u00d8\u00de\u00e4\u00e9\u00eb\u00f2\u00f7"+
		"\u00fe\u0108\u010f\u0114\u011c\u0121\u0128\u0131\u0136";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}