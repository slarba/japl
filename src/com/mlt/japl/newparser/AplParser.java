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
		ENDREPEAT=30, FOR=31, IN=32, ENDFOR=33, OPERATOR=34, POWEROPERATOR=35, 
		BOUNDWITH=36, OUTERPRODUCT=37, DEL=38;
	public static final int
		RULE_sep = 0, RULE_toplevel = 1, RULE_interactive = 2, RULE_toplevelexpr = 3, 
		RULE_expr_list = 4, RULE_if_expr = 5, RULE_for_expr = 6, RULE_while_expr = 7, 
		RULE_repeat_expr = 8, RULE_arrayexpr = 9, RULE_toplevelassignment = 10, 
		RULE_array = 11, RULE_arrayitem = 12, RULE_subarrayexpr = 13, RULE_integer = 14, 
		RULE_floating = 15, RULE_complexnum = 16, RULE_string = 17, RULE_ident = 18, 
		RULE_index = 19, RULE_indexelement = 20, RULE_func_operator = 21, RULE_func = 22, 
		RULE_axis = 23, RULE_lambdafunc = 24, RULE_toplevelfunc = 25, RULE_localslist = 26, 
		RULE_guard_or_assignment = 27, RULE_guard = 28;
	public static final String[] ruleNames = {
		"sep", "toplevel", "interactive", "toplevelexpr", "expr_list", "if_expr", 
		"for_expr", "while_expr", "repeat_expr", "arrayexpr", "toplevelassignment", 
		"array", "arrayitem", "subarrayexpr", "integer", "floating", "complexnum", 
		"string", "ident", "index", "indexelement", "func_operator", "func", "axis", 
		"lambdafunc", "toplevelfunc", "localslist", "guard_or_assignment", "guard"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", null, null, "'\\u00af'", null, null, null, null, null, "'\n'", 
		null, null, "'\\u2190'", "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", 
		"'\\u22C4'", "';'", "':If'", null, "':Else'", "':ElseIf'", "':While'", 
		null, "':Repeat'", null, "':For'", "':In'", null, null, "'\\u2363'", "'\\u2218'", 
		null, "'\\u2207'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ID", "LABEL", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", 
		"WS", "NL", "STRING", "FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", 
		"RBRACKET", "LBRACE", "RBRACE", "COLON", "DIAMOND", "SEMICOLON", "IF", 
		"ENDIF", "ELSE", "ELSEIF", "WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", 
		"FOR", "IN", "ENDFOR", "OPERATOR", "POWEROPERATOR", "BOUNDWITH", "OUTERPRODUCT", 
		"DEL"
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
			setState(64);
			switch (_input.LA(1)) {
			case DIAMOND:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(DIAMOND);
				}
				break;
			case COMMENT:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
				setState(60); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(59);
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
					setState(62); 
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
			setState(67);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(66);
				sep();
				}
				break;
			}
			setState(69);
			expr_list();
			setState(71);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(70);
				sep();
				}
			}

			setState(73);
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

	public static class InteractiveContext extends ParserRuleContext {
		public ToplevelexprContext toplevelexpr() {
			return getRuleContext(ToplevelexprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AplParser.EOF, 0); }
		public InteractiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interactive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitInteractive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InteractiveContext interactive() throws RecognitionException {
		InteractiveContext _localctx = new InteractiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_interactive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			toplevelexpr();
			setState(76);
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
		public ToplevelassignmentContext toplevelassignment() {
			return getRuleContext(ToplevelassignmentContext.class,0);
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
		enterRule(_localctx, 6, RULE_toplevelexpr);
		try {
			setState(85);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				toplevelfunc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				toplevelassignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				if_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				while_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				repeat_expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				for_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
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
		enterRule(_localctx, 8, RULE_expr_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(87);
				match(LABEL);
				}
				break;
			}
			setState(90);
			toplevelexpr();
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					sep();
					setState(93);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(92);
						match(LABEL);
						}
						break;
					}
					setState(95);
					toplevelexpr();
					}
					} 
				}
				setState(101);
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
		enterRule(_localctx, 10, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(IF);
			setState(103);
			((If_exprContext)_localctx).condition = arrayexpr();
			setState(104);
			sep();
			setState(105);
			((If_exprContext)_localctx).thenbranch = expr_list();
			setState(107);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(106);
				sep();
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(109);
				match(ELSEIF);
				setState(110);
				((If_exprContext)_localctx).elifcondition = arrayexpr();
				setState(111);
				sep();
				setState(112);
				((If_exprContext)_localctx).elifthenbranch = expr_list();
				setState(114);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(113);
					sep();
					}
				}

				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(121);
				match(ELSE);
				setState(122);
				((If_exprContext)_localctx).elsebranch = expr_list();
				setState(124);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
					{
					setState(123);
					sep();
					}
				}

				}
			}

			setState(128);
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
		enterRule(_localctx, 12, RULE_for_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(FOR);
			setState(131);
			match(ID);
			setState(132);
			match(IN);
			setState(133);
			arrayexpr();
			setState(134);
			sep();
			setState(135);
			expr_list();
			setState(136);
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
		enterRule(_localctx, 14, RULE_while_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(WHILE);
			setState(139);
			arrayexpr();
			setState(140);
			sep();
			setState(141);
			expr_list();
			setState(143);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(142);
				sep();
				}
			}

			setState(145);
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
		enterRule(_localctx, 16, RULE_repeat_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(REPEAT);
			setState(148);
			arrayexpr();
			setState(149);
			sep();
			setState(150);
			expr_list();
			setState(152);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(151);
				sep();
				}
			}

			setState(154);
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
		public ArrayexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayexpr; }
	 
		public ArrayexprContext() { }
		public void copyFrom(ArrayexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr_assignContext extends ArrayexprContext {
		public TerminalNode ID() { return getToken(AplParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public Expr_assignContext(ArrayexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitExpr_assign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Dyadic_call_or_arrayContext extends ArrayexprContext {
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
		public Dyadic_call_or_arrayContext(ArrayexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitDyadic_call_or_array(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Monadic_call_or_niladicContext extends ArrayexprContext {
		public Func_operatorContext func_operator() {
			return getRuleContext(Func_operatorContext.class,0);
		}
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public Monadic_call_or_niladicContext(ArrayexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitMonadic_call_or_niladic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayexprContext arrayexpr() throws RecognitionException {
		ArrayexprContext _localctx = new ArrayexprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arrayexpr);
		try {
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new Expr_assignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(ID);
				setState(157);
				match(ASSIGN);
				setState(158);
				arrayexpr();
				}
				break;
			case 2:
				_localctx = new Monadic_call_or_niladicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				func_operator();
				setState(161);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(160);
					arrayexpr();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new Dyadic_call_or_arrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				((Dyadic_call_or_arrayContext)_localctx).l = array();
				setState(167);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(164);
					((Dyadic_call_or_arrayContext)_localctx).fn = func_operator();
					setState(165);
					((Dyadic_call_or_arrayContext)_localctx).r = arrayexpr();
					}
					break;
				}
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

	public static class ToplevelassignmentContext extends ParserRuleContext {
		public ToplevelassignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toplevelassignment; }
	 
		public ToplevelassignmentContext() { }
		public void copyFrom(ToplevelassignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrandassignmentContext extends ToplevelassignmentContext {
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public ArrayexprContext arrayexpr() {
			return getRuleContext(ArrayexprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AplParser.ID, i);
		}
		public StrandassignmentContext(ToplevelassignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitStrandassignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FnassignmentContext extends ToplevelassignmentContext {
		public Token ID;
		public TerminalNode ID() { return getToken(AplParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(AplParser.ASSIGN, 0); }
		public Func_operatorContext func_operator() {
			return getRuleContext(Func_operatorContext.class,0);
		}
		public FnassignmentContext(ToplevelassignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFnassignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToplevelassignmentContext toplevelassignment() throws RecognitionException {
		ToplevelassignmentContext _localctx = new ToplevelassignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_toplevelassignment);
		int _la;
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new FnassignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				((FnassignmentContext)_localctx).ID = match(ID);
				setState(172);
				match(ASSIGN);
				 registerLocalFunction((((FnassignmentContext)_localctx).ID!=null?((FnassignmentContext)_localctx).ID.getText():null), null); 
				setState(174);
				func_operator();
				}
				break;
			case 2:
				_localctx = new StrandassignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(175);
					match(ID);
					}
					}
					setState(178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(180);
				match(ASSIGN);
				setState(181);
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
		enterRule(_localctx, 22, RULE_array);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(184);
					arrayitem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(187); 
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
		enterRule(_localctx, 24, RULE_arrayitem);
		try {
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				integer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				floating();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				complexnum();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				string();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
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
		enterRule(_localctx, 26, RULE_subarrayexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(LPAREN);
			setState(198);
			arrayexpr();
			setState(199);
			match(RPAREN);
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(200);
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
		enterRule(_localctx, 28, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
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
		enterRule(_localctx, 30, RULE_floating);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
		enterRule(_localctx, 32, RULE_complexnum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		enterRule(_localctx, 34, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(STRING);
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(210);
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
		enterRule(_localctx, 36, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			if (!(!isFnSymbol())) throw new FailedPredicateException(this, "!isFnSymbol()");
			setState(214);
			match(ID);
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(215);
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
		enterRule(_localctx, 38, RULE_index);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(LBRACKET);
			setState(220); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(219);
					indexelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(222); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(224);
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
		enterRule(_localctx, 40, RULE_indexelement);
		try {
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
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
		public Func_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_operator; }
	 
		public Func_operatorContext() { }
		public void copyFrom(Func_operatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Func_oper_with_parensContext extends Func_operatorContext {
		public TerminalNode LPAREN() { return getToken(AplParser.LPAREN, 0); }
		public Func_operatorContext func_operator() {
			return getRuleContext(Func_operatorContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AplParser.RPAREN, 0); }
		public Func_oper_with_parensContext(Func_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFunc_oper_with_parens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Func_oper_no_parensContext extends Func_operatorContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(AplParser.OPERATOR, 0); }
		public AxisContext axis() {
			return getRuleContext(AxisContext.class,0);
		}
		public Func_oper_no_parensContext(Func_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFunc_oper_no_parens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_operatorContext func_operator() throws RecognitionException {
		Func_operatorContext _localctx = new Func_operatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func_operator);
		try {
			setState(241);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new Func_oper_no_parensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				func(0);
				setState(235);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(231);
					match(OPERATOR);
					setState(233);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(232);
						axis();
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new Func_oper_with_parensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(LPAREN);
				setState(238);
				func_operator();
				setState(239);
				match(RPAREN);
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
	public static class PowerfuncContext extends FuncContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode POWEROPERATOR() { return getToken(AplParser.POWEROPERATOR, 0); }
		public ArrayitemContext arrayitem() {
			return getRuleContext(ArrayitemContext.class,0);
		}
		public PowerfuncContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitPowerfunc(this);
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
	public static class BoundfuncContext extends FuncContext {
		public ArrayitemContext arrayitem() {
			return getRuleContext(ArrayitemContext.class,0);
		}
		public TerminalNode BOUNDWITH() { return getToken(AplParser.BOUNDWITH, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public BoundfuncContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitBoundfunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Func_with_parensContext extends FuncContext {
		public TerminalNode LPAREN() { return getToken(AplParser.LPAREN, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AplParser.RPAREN, 0); }
		public Func_with_parensContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AplVisitor ) return ((AplVisitor<? extends T>)visitor).visitFunc_with_parens(this);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_func, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new OuterproductContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(244);
				match(OUTERPRODUCT);
				setState(245);
				func(5);
				}
				break;
			case 2:
				{
				_localctx = new BoundfuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				arrayitem();
				setState(247);
				match(BOUNDWITH);
				setState(248);
				func(4);
				}
				break;
			case 3:
				{
				_localctx = new SimplefuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				match(FUNC);
				setState(252);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(251);
					axis();
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new IdfuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				if (!(isFnSymbol())) throw new FailedPredicateException(this, "isFnSymbol()");
				setState(255);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new LambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				lambdafunc();
				}
				break;
			case 6:
				{
				_localctx = new Func_with_parensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				match(LPAREN);
				setState(258);
				func(0);
				setState(259);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new InnerprodContext(new FuncContext(_parentctx, _parentState));
						((InnerprodContext)_localctx).outer = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_func);
						setState(263);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(264);
						match(T__0);
						setState(265);
						((InnerprodContext)_localctx).inner = func(9);
						}
						break;
					case 2:
						{
						_localctx = new PowerfuncContext(new FuncContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_func);
						setState(266);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(267);
						match(POWEROPERATOR);
						setState(268);
						arrayitem();
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 46, RULE_axis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(LBRACKET);
			setState(275);
			arrayexpr();
			setState(276);
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
		enterRule(_localctx, 48, RULE_lambdafunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(LBRACE);
			 enterLambdaContext(); 
			setState(281);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(280);
				sep();
				}
				break;
			}
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283);
					guard_or_assignment();
					setState(284);
					sep();
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(291);
			arrayexpr();
			setState(293);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(292);
				sep();
				}
			}

			setState(295);
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
		enterRule(_localctx, 50, RULE_toplevelfunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(DEL);
			setState(301);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(299);
				((ToplevelfuncContext)_localctx).ret = match(ID);
				setState(300);
				match(ASSIGN);
				}
				break;
			}
			setState(303);
			((ToplevelfuncContext)_localctx).a = match(ID);
			setState(304);
			((ToplevelfuncContext)_localctx).b = match(ID);
			setState(306);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(305);
				((ToplevelfuncContext)_localctx).c = match(ID);
				}
			}

			setState(308);
			localslist();
			setState(309);
			sep();
			 enterLambdaContext(); 
			setState(311);
			expr_list();
			setState(313);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << NL) | (1L << DIAMOND))) != 0)) {
				{
				setState(312);
				sep();
				}
			}

			setState(315);
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
		enterRule(_localctx, 52, RULE_localslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(318);
				match(SEMICOLON);
				setState(319);
				match(ID);
				}
				}
				setState(324);
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
		public ToplevelassignmentContext toplevelassignment() {
			return getRuleContext(ToplevelassignmentContext.class,0);
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
		enterRule(_localctx, 54, RULE_guard_or_assignment);
		try {
			setState(327);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				guard();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				toplevelassignment();
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
		enterRule(_localctx, 56, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			arrayexpr();
			setState(330);
			match(COLON);
			setState(331);
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
		case 18:
			return ident_sempred((IdentContext)_localctx, predIndex);
		case 22:
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
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u0150\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\6\2?\n\2\r"+
		"\2\16\2@\5\2C\n\2\3\3\5\3F\n\3\3\3\3\3\5\3J\n\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5X\n\5\3\6\5\6[\n\6\3\6\3\6\3\6\5\6`\n\6"+
		"\3\6\3\6\7\6d\n\6\f\6\16\6g\13\6\3\7\3\7\3\7\3\7\3\7\5\7n\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7u\n\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\7\5\7\177\n\7"+
		"\5\7\u0081\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u0092\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u00a4\n\13\3\13\3\13\3\13\3\13\5\13\u00aa"+
		"\n\13\5\13\u00ac\n\13\3\f\3\f\3\f\3\f\3\f\6\f\u00b3\n\f\r\f\16\f\u00b4"+
		"\3\f\3\f\5\f\u00b9\n\f\3\r\6\r\u00bc\n\r\r\r\16\r\u00bd\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00c6\n\16\3\17\3\17\3\17\3\17\5\17\u00cc\n\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\5\23\u00d6\n\23\3\24\3\24\3\24"+
		"\5\24\u00db\n\24\3\25\3\25\6\25\u00df\n\25\r\25\16\25\u00e0\3\25\3\25"+
		"\3\26\3\26\5\26\u00e7\n\26\3\27\3\27\3\27\5\27\u00ec\n\27\5\27\u00ee\n"+
		"\27\3\27\3\27\3\27\3\27\5\27\u00f4\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u00ff\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0108\n\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0110\n\30\f\30\16\30\u0113"+
		"\13\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\5\32\u011c\n\32\3\32\3\32\3"+
		"\32\7\32\u0121\n\32\f\32\16\32\u0124\13\32\3\32\3\32\5\32\u0128\n\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\5\33\u0130\n\33\3\33\3\33\3\33\5\33\u0135"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\5\33\u013c\n\33\3\33\3\33\3\33\3\34\3\34"+
		"\7\34\u0143\n\34\f\34\16\34\u0146\13\34\3\35\3\35\5\35\u014a\n\35\3\36"+
		"\3\36\3\36\3\36\3\36\2\3.\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:\2\3\4\2\n\n\f\f\u016a\2B\3\2\2\2\4E\3\2\2\2\6M\3"+
		"\2\2\2\bW\3\2\2\2\nZ\3\2\2\2\fh\3\2\2\2\16\u0084\3\2\2\2\20\u008c\3\2"+
		"\2\2\22\u0095\3\2\2\2\24\u00ab\3\2\2\2\26\u00b8\3\2\2\2\30\u00bb\3\2\2"+
		"\2\32\u00c5\3\2\2\2\34\u00c7\3\2\2\2\36\u00cd\3\2\2\2 \u00cf\3\2\2\2\""+
		"\u00d1\3\2\2\2$\u00d3\3\2\2\2&\u00d7\3\2\2\2(\u00dc\3\2\2\2*\u00e6\3\2"+
		"\2\2,\u00f3\3\2\2\2.\u0107\3\2\2\2\60\u0114\3\2\2\2\62\u0118\3\2\2\2\64"+
		"\u012c\3\2\2\2\66\u0144\3\2\2\28\u0149\3\2\2\2:\u014b\3\2\2\2<C\7\27\2"+
		"\2=?\t\2\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B<\3\2\2"+
		"\2B>\3\2\2\2C\3\3\2\2\2DF\5\2\2\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GI\5\n"+
		"\6\2HJ\5\2\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\2\2\3L\5\3\2\2\2MN\5"+
		"\b\5\2NO\7\2\2\3O\7\3\2\2\2PX\5\64\33\2QX\5\26\f\2RX\5\f\7\2SX\5\20\t"+
		"\2TX\5\22\n\2UX\5\16\b\2VX\5\24\13\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3"+
		"\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\t\3\2\2\2Y[\7\5\2\2ZY\3\2\2\2Z["+
		"\3\2\2\2[\\\3\2\2\2\\e\5\b\5\2]_\5\2\2\2^`\7\5\2\2_^\3\2\2\2_`\3\2\2\2"+
		"`a\3\2\2\2ab\5\b\5\2bd\3\2\2\2c]\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"f\13\3\2\2\2ge\3\2\2\2hi\7\31\2\2ij\5\24\13\2jk\5\2\2\2km\5\n\6\2ln\5"+
		"\2\2\2ml\3\2\2\2mn\3\2\2\2nx\3\2\2\2op\7\34\2\2pq\5\24\13\2qr\5\2\2\2"+
		"rt\5\n\6\2su\5\2\2\2ts\3\2\2\2tu\3\2\2\2uw\3\2\2\2vo\3\2\2\2wz\3\2\2\2"+
		"xv\3\2\2\2xy\3\2\2\2y\u0080\3\2\2\2zx\3\2\2\2{|\7\33\2\2|~\5\n\6\2}\177"+
		"\5\2\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080{\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\32\2\2\u0083\r\3\2\2"+
		"\2\u0084\u0085\7!\2\2\u0085\u0086\7\4\2\2\u0086\u0087\7\"\2\2\u0087\u0088"+
		"\5\24\13\2\u0088\u0089\5\2\2\2\u0089\u008a\5\n\6\2\u008a\u008b\7#\2\2"+
		"\u008b\17\3\2\2\2\u008c\u008d\7\35\2\2\u008d\u008e\5\24\13\2\u008e\u008f"+
		"\5\2\2\2\u008f\u0091\5\n\6\2\u0090\u0092\5\2\2\2\u0091\u0090\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\36\2\2\u0094\21\3\2\2"+
		"\2\u0095\u0096\7\37\2\2\u0096\u0097\5\24\13\2\u0097\u0098\5\2\2\2\u0098"+
		"\u009a\5\n\6\2\u0099\u009b\5\2\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7 \2\2\u009d\23\3\2\2\2\u009e\u009f"+
		"\7\4\2\2\u009f\u00a0\7\17\2\2\u00a0\u00ac\5\24\13\2\u00a1\u00a3\5,\27"+
		"\2\u00a2\u00a4\5\24\13\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00ac\3\2\2\2\u00a5\u00a9\5\30\r\2\u00a6\u00a7\5,\27\2\u00a7\u00a8\5"+
		"\24\13\2\u00a8\u00aa\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u009e\3\2\2\2\u00ab\u00a1\3\2\2\2\u00ab\u00a5\3\2"+
		"\2\2\u00ac\25\3\2\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00af\7\17\2\2\u00af\u00b0"+
		"\b\f\1\2\u00b0\u00b9\5,\27\2\u00b1\u00b3\7\4\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b7\7\17\2\2\u00b7\u00b9\5\24\13\2\u00b8\u00ad\3\2\2\2\u00b8"+
		"\u00b2\3\2\2\2\u00b9\27\3\2\2\2\u00ba\u00bc\5\32\16\2\u00bb\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\31\3\2\2\2\u00bf\u00c6\5&\24\2\u00c0\u00c6\5\36\20\2\u00c1\u00c6\5 \21"+
		"\2\u00c2\u00c6\5\"\22\2\u00c3\u00c6\5$\23\2\u00c4\u00c6\5\34\17\2\u00c5"+
		"\u00bf\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c2\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\33\3\2\2\2\u00c7\u00c8"+
		"\7\20\2\2\u00c8\u00c9\5\24\13\2\u00c9\u00cb\7\21\2\2\u00ca\u00cc\5(\25"+
		"\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\35\3\2\2\2\u00cd\u00ce"+
		"\7\7\2\2\u00ce\37\3\2\2\2\u00cf\u00d0\7\b\2\2\u00d0!\3\2\2\2\u00d1\u00d2"+
		"\7\t\2\2\u00d2#\3\2\2\2\u00d3\u00d5\7\r\2\2\u00d4\u00d6\5(\25\2\u00d5"+
		"\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6%\3\2\2\2\u00d7\u00d8\6\24\2\2"+
		"\u00d8\u00da\7\4\2\2\u00d9\u00db\5(\25\2\u00da\u00d9\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\'\3\2\2\2\u00dc\u00de\7\22\2\2\u00dd\u00df\5*\26\2\u00de"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7\23\2\2\u00e3)\3\2\2\2\u00e4\u00e7"+
		"\7\30\2\2\u00e5\u00e7\5\24\13\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2"+
		"\2\u00e7+\3\2\2\2\u00e8\u00ed\5.\30\2\u00e9\u00eb\7$\2\2\u00ea\u00ec\5"+
		"\60\31\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed"+
		"\u00e9\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f4\3\2\2\2\u00ef\u00f0\7\20"+
		"\2\2\u00f0\u00f1\5,\27\2\u00f1\u00f2\7\21\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00e8\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4-\3\2\2\2\u00f5\u00f6\b\30\1\2"+
		"\u00f6\u00f7\7\'\2\2\u00f7\u0108\5.\30\7\u00f8\u00f9\5\32\16\2\u00f9\u00fa"+
		"\7&\2\2\u00fa\u00fb\5.\30\6\u00fb\u0108\3\2\2\2\u00fc\u00fe\7\16\2\2\u00fd"+
		"\u00ff\5\60\31\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0108\3"+
		"\2\2\2\u0100\u0101\6\30\3\2\u0101\u0108\7\4\2\2\u0102\u0108\5\62\32\2"+
		"\u0103\u0104\7\20\2\2\u0104\u0105\5.\30\2\u0105\u0106\7\21\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u00f5\3\2\2\2\u0107\u00f8\3\2\2\2\u0107\u00fc\3\2\2\2\u0107"+
		"\u0100\3\2\2\2\u0107\u0102\3\2\2\2\u0107\u0103\3\2\2\2\u0108\u0111\3\2"+
		"\2\2\u0109\u010a\f\n\2\2\u010a\u010b\7\3\2\2\u010b\u0110\5.\30\13\u010c"+
		"\u010d\f\5\2\2\u010d\u010e\7%\2\2\u010e\u0110\5\32\16\2\u010f\u0109\3"+
		"\2\2\2\u010f\u010c\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112/\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7\22\2\2"+
		"\u0115\u0116\5\24\13\2\u0116\u0117\7\23\2\2\u0117\61\3\2\2\2\u0118\u0119"+
		"\7\24\2\2\u0119\u011b\b\32\1\2\u011a\u011c\5\2\2\2\u011b\u011a\3\2\2\2"+
		"\u011b\u011c\3\2\2\2\u011c\u0122\3\2\2\2\u011d\u011e\58\35\2\u011e\u011f"+
		"\5\2\2\2\u011f\u0121\3\2\2\2\u0120\u011d\3\2\2\2\u0121\u0124\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0125\u0127\5\24\13\2\u0126\u0128\5\2\2\2\u0127\u0126\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\7\25\2\2\u012a\u012b\b"+
		"\32\1\2\u012b\63\3\2\2\2\u012c\u012f\7(\2\2\u012d\u012e\7\4\2\2\u012e"+
		"\u0130\7\17\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3"+
		"\2\2\2\u0131\u0132\7\4\2\2\u0132\u0134\7\4\2\2\u0133\u0135\7\4\2\2\u0134"+
		"\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\5\66"+
		"\34\2\u0137\u0138\5\2\2\2\u0138\u0139\b\33\1\2\u0139\u013b\5\n\6\2\u013a"+
		"\u013c\5\2\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\7(\2\2\u013e\u013f\b\33\1\2\u013f\65\3\2\2\2\u0140\u0141"+
		"\7\30\2\2\u0141\u0143\7\4\2\2\u0142\u0140\3\2\2\2\u0143\u0146\3\2\2\2"+
		"\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\67\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0147\u014a\5:\36\2\u0148\u014a\5\26\f\2\u0149\u0147\3\2\2\2"+
		"\u0149\u0148\3\2\2\2\u014a9\3\2\2\2\u014b\u014c\5\24\13\2\u014c\u014d"+
		"\7\26\2\2\u014d\u014e\5\24\13\2\u014e;\3\2\2\2,@BEIWZ_emtx~\u0080\u0091"+
		"\u009a\u00a3\u00a9\u00ab\u00b4\u00b8\u00bd\u00c5\u00cb\u00d5\u00da\u00e0"+
		"\u00e6\u00eb\u00ed\u00f3\u00fe\u0107\u010f\u0111\u011b\u0122\u0127\u012f"+
		"\u0134\u013b\u0144\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}