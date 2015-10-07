// Generated from /Users/markolau/IdeaProjects/Japl/src/com/mlt/japl/newparser/Apl.g4 by ANTLR 4.5.1
package com.mlt.japl.newparser;

import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AplLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "ID", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", "WS", "NL", 
		"STRING", "EXPONENT", "HEX_DIGIT", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", 
		"FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", 
		"RBRACE", "COLON", "DIAMOND", "IF", "ENDIF", "ELSE", "ELSEIF", "WHILE", 
		"ENDWHILE", "REPEAT", "ENDREPEAT", "FOR", "IN", "ENDFOR", "OPERATOR", 
		"OUTERPRODUCT"
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


	    boolean isFnSymbol(String sym) {
	       return sym.equals("specialsym");
	    }


	public AplLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Apl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			if(isFnSymbol(getText())) setType(AplParser.FUNC);
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u0150\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\7\3T\n\3\f"+
		"\3\16\3W\13\3\3\3\3\3\3\4\3\4\3\5\5\5^\n\5\3\5\6\5a\n\5\r\5\16\5b\3\6"+
		"\5\6f\n\6\3\6\6\6i\n\6\r\6\16\6j\3\6\3\6\7\6o\n\6\f\6\16\6r\13\6\3\6\5"+
		"\6u\n\6\3\6\5\6x\n\6\3\6\3\6\6\6|\n\6\r\6\16\6}\3\6\5\6\u0081\n\6\3\6"+
		"\5\6\u0084\n\6\3\6\6\6\u0087\n\6\r\6\16\6\u0088\3\6\5\6\u008c\n\6\3\7"+
		"\3\7\5\7\u0090\n\7\3\7\3\7\3\7\5\7\u0095\n\7\3\b\3\b\7\b\u0099\n\b\f\b"+
		"\16\b\u009c\13\b\3\b\5\b\u009f\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af\13\13\3\13\3\13\3\f\3\f\5"+
		"\f\u00b5\n\f\3\f\6\f\u00b8\n\f\r\f\16\f\u00b9\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\5\16\u00c2\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00cd\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u00f8\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \5 \u011c\n \3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0134\n\"\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u014a\n%\3&\3"+
		"&\3\'\3\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2"+
		"\31\2\33\2\35\2\37\2!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65\27"+
		"\67\309\31;\32=\33?\34A\35C\36E\37G I!K\"M#\3\2\r\5\2C\\aac|\6\2\62;C"+
		"\\aac|\4\2\f\f\17\17\5\2\13\13\17\17\"\"\4\2))^^\4\2GGgg\4\2--//\5\2\62"+
		";CHch\n\2$$))^^ddhhppttvv\r\2--//>@\u00d9\u00d9\u00f9\u00f9\u220c\u220c"+
		"\u2229\u222c\u2262\u2262\u2266\u2267\u2284\u2285\u2373\u2374\6\2\61\61"+
		"^^\u00aa\u00aa\u2341\u2342\u0168\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\3O\3\2\2\2\5Q\3\2\2\2\7Z\3\2\2\2\t]\3\2\2\2\13\u008b\3\2\2\2\r\u008f"+
		"\3\2\2\2\17\u0096\3\2\2\2\21\u00a2\3\2\2\2\23\u00a6\3\2\2\2\25\u00a8\3"+
		"\2\2\2\27\u00b2\3\2\2\2\31\u00bb\3\2\2\2\33\u00c1\3\2\2\2\35\u00cc\3\2"+
		"\2\2\37\u00ce\3\2\2\2!\u00d5\3\2\2\2#\u00d7\3\2\2\2%\u00d9\3\2\2\2\'\u00db"+
		"\3\2\2\2)\u00dd\3\2\2\2+\u00df\3\2\2\2-\u00e1\3\2\2\2/\u00e3\3\2\2\2\61"+
		"\u00e5\3\2\2\2\63\u00e7\3\2\2\2\65\u00e9\3\2\2\2\67\u00f7\3\2\2\29\u00f9"+
		"\3\2\2\2;\u00ff\3\2\2\2=\u0107\3\2\2\2?\u011b\3\2\2\2A\u011d\3\2\2\2C"+
		"\u0133\3\2\2\2E\u0135\3\2\2\2G\u013a\3\2\2\2I\u0149\3\2\2\2K\u014b\3\2"+
		"\2\2M\u014d\3\2\2\2OP\7\60\2\2P\4\3\2\2\2QU\t\2\2\2RT\t\3\2\2SR\3\2\2"+
		"\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\b\3\2\2Y\6\3\2"+
		"\2\2Z[\7\u00b1\2\2[\b\3\2\2\2\\^\5\7\4\2]\\\3\2\2\2]^\3\2\2\2^`\3\2\2"+
		"\2_a\4\62;\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\n\3\2\2\2df\5\7"+
		"\4\2ed\3\2\2\2ef\3\2\2\2fh\3\2\2\2gi\4\62;\2hg\3\2\2\2ij\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2kl\3\2\2\2lp\7\60\2\2mo\4\62;\2nm\3\2\2\2or\3\2\2\2pn\3"+
		"\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\5\27\f\2ts\3\2\2\2tu\3\2\2\2u\u008c"+
		"\3\2\2\2vx\5\7\4\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2y{\7\60\2\2z|\4\62;\2"+
		"{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177\u0081\5\27"+
		"\f\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u008c\3\2\2\2\u0082\u0084"+
		"\5\7\4\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0087\4\62;\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\5\27\f\2\u008b"+
		"e\3\2\2\2\u008bw\3\2\2\2\u008b\u0083\3\2\2\2\u008c\f\3\2\2\2\u008d\u0090"+
		"\5\t\5\2\u008e\u0090\5\13\6\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0094\7L\2\2\u0092\u0095\5\t\5\2\u0093\u0095"+
		"\5\13\6\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\16\3\2\2\2\u0096"+
		"\u009a\7\u235f\2\2\u0097\u0099\n\4\2\2\u0098\u0097\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009f\7\17\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1\20\3\2\2\2\u00a2"+
		"\u00a3\t\5\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\t\3\2\u00a5\22\3\2\2"+
		"\2\u00a6\u00a7\7\f\2\2\u00a7\24\3\2\2\2\u00a8\u00ad\7)\2\2\u00a9\u00ac"+
		"\5\33\16\2\u00aa\u00ac\n\6\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2"+
		"\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7)\2\2\u00b1\26\3\2\2\2\u00b2"+
		"\u00b4\t\7\2\2\u00b3\u00b5\t\b\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b8\4\62;\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\30\3\2\2"+
		"\2\u00bb\u00bc\t\t\2\2\u00bc\32\3\2\2\2\u00bd\u00be\7^\2\2\u00be\u00c2"+
		"\t\n\2\2\u00bf\u00c2\5\37\20\2\u00c0\u00c2\5\35\17\2\u00c1\u00bd\3\2\2"+
		"\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\34\3\2\2\2\u00c3\u00c4"+
		"\7^\2\2\u00c4\u00c5\4\62\65\2\u00c5\u00c6\4\629\2\u00c6\u00cd\4\629\2"+
		"\u00c7\u00c8\7^\2\2\u00c8\u00c9\4\629\2\u00c9\u00cd\4\629\2\u00ca\u00cb"+
		"\7^\2\2\u00cb\u00cd\4\629\2\u00cc\u00c3\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\36\3\2\2\2\u00ce\u00cf\7^\2\2\u00cf\u00d0\7w\2\2"+
		"\u00d0\u00d1\5\31\r\2\u00d1\u00d2\5\31\r\2\u00d2\u00d3\5\31\r\2\u00d3"+
		"\u00d4\5\31\r\2\u00d4 \3\2\2\2\u00d5\u00d6\t\13\2\2\u00d6\"\3\2\2\2\u00d7"+
		"\u00d8\7\u2192\2\2\u00d8$\3\2\2\2\u00d9\u00da\7*\2\2\u00da&\3\2\2\2\u00db"+
		"\u00dc\7+\2\2\u00dc(\3\2\2\2\u00dd\u00de\7]\2\2\u00de*\3\2\2\2\u00df\u00e0"+
		"\7_\2\2\u00e0,\3\2\2\2\u00e1\u00e2\7}\2\2\u00e2.\3\2\2\2\u00e3\u00e4\7"+
		"\177\2\2\u00e4\60\3\2\2\2\u00e5\u00e6\7<\2\2\u00e6\62\3\2\2\2\u00e7\u00e8"+
		"\7\u22c6\2\2\u00e8\64\3\2\2\2\u00e9\u00ea\7<\2\2\u00ea\u00eb\7K\2\2\u00eb"+
		"\u00ec\7h\2\2\u00ec\66\3\2\2\2\u00ed\u00ee\7<\2\2\u00ee\u00ef\7G\2\2\u00ef"+
		"\u00f0\7p\2\2\u00f0\u00f1\7f\2\2\u00f1\u00f2\7K\2\2\u00f2\u00f8\7h\2\2"+
		"\u00f3\u00f4\7<\2\2\u00f4\u00f5\7G\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f8"+
		"\7f\2\2\u00f7\u00ed\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f88\3\2\2\2\u00f9\u00fa"+
		"\7<\2\2\u00fa\u00fb\7G\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7u\2\2\u00fd"+
		"\u00fe\7g\2\2\u00fe:\3\2\2\2\u00ff\u0100\7<\2\2\u0100\u0101\7G\2\2\u0101"+
		"\u0102\7n\2\2\u0102\u0103\7u\2\2\u0103\u0104\7g\2\2\u0104\u0105\7K\2\2"+
		"\u0105\u0106\7h\2\2\u0106<\3\2\2\2\u0107\u0108\7<\2\2\u0108\u0109\7Y\2"+
		"\2\u0109\u010a\7j\2\2\u010a\u010b\7k\2\2\u010b\u010c\7n\2\2\u010c\u010d"+
		"\7g\2\2\u010d>\3\2\2\2\u010e\u010f\7<\2\2\u010f\u0110\7G\2\2\u0110\u0111"+
		"\7p\2\2\u0111\u0112\7f\2\2\u0112\u0113\7Y\2\2\u0113\u0114\7j\2\2\u0114"+
		"\u0115\7k\2\2\u0115\u0116\7n\2\2\u0116\u011c\7g\2\2\u0117\u0118\7<\2\2"+
		"\u0118\u0119\7G\2\2\u0119\u011a\7p\2\2\u011a\u011c\7f\2\2\u011b\u010e"+
		"\3\2\2\2\u011b\u0117\3\2\2\2\u011c@\3\2\2\2\u011d\u011e\7<\2\2\u011e\u011f"+
		"\7T\2\2\u011f\u0120\7g\2\2\u0120\u0121\7r\2\2\u0121\u0122\7g\2\2\u0122"+
		"\u0123\7c\2\2\u0123\u0124\7v\2\2\u0124B\3\2\2\2\u0125\u0126\7<\2\2\u0126"+
		"\u0127\7G\2\2\u0127\u0128\7p\2\2\u0128\u0129\7f\2\2\u0129\u012a\7T\2\2"+
		"\u012a\u012b\7g\2\2\u012b\u012c\7r\2\2\u012c\u012d\7g\2\2\u012d\u012e"+
		"\7c\2\2\u012e\u0134\7v\2\2\u012f\u0130\7<\2\2\u0130\u0131\7G\2\2\u0131"+
		"\u0132\7p\2\2\u0132\u0134\7f\2\2\u0133\u0125\3\2\2\2\u0133\u012f\3\2\2"+
		"\2\u0134D\3\2\2\2\u0135\u0136\7<\2\2\u0136\u0137\7H\2\2\u0137\u0138\7"+
		"q\2\2\u0138\u0139\7t\2\2\u0139F\3\2\2\2\u013a\u013b\7<\2\2\u013b\u013c"+
		"\7K\2\2\u013c\u013d\7p\2\2\u013dH\3\2\2\2\u013e\u013f\7<\2\2\u013f\u0140"+
		"\7G\2\2\u0140\u0141\7p\2\2\u0141\u0142\7f\2\2\u0142\u0143\7H\2\2\u0143"+
		"\u0144\7q\2\2\u0144\u014a\7t\2\2\u0145\u0146\7<\2\2\u0146\u0147\7G\2\2"+
		"\u0147\u0148\7p\2\2\u0148\u014a\7f\2\2\u0149\u013e\3\2\2\2\u0149\u0145"+
		"\3\2\2\2\u014aJ\3\2\2\2\u014b\u014c\t\f\2\2\u014cL\3\2\2\2\u014d\u014e"+
		"\7\u221a\2\2\u014e\u014f\7\60\2\2\u014fN\3\2\2\2\36\2U]bejptw}\u0080\u0083"+
		"\u0088\u008b\u008f\u0094\u009a\u009e\u00ab\u00ad\u00b4\u00b9\u00c1\u00cc"+
		"\u00f7\u011b\u0133\u0149\4\3\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}