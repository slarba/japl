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
		T__0=1, ID=2, LABEL=3, SIGN=4, INT=5, FLOAT=6, COMPLEX=7, COMMENT=8, WS=9, 
		NL=10, STRING=11, FUNC=12, ASSIGN=13, LPAREN=14, RPAREN=15, LBRACKET=16, 
		RBRACKET=17, LBRACE=18, RBRACE=19, COLON=20, DIAMOND=21, SEMICOLON=22, 
		IF=23, ENDIF=24, ELSE=25, ELSEIF=26, WHILE=27, ENDWHILE=28, REPEAT=29, 
		ENDREPEAT=30, FOR=31, IN=32, ENDFOR=33, OPERATOR=34, OUTERPRODUCT=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "ID", "LABEL", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", "WS", 
		"NL", "STRING", "EXPONENT", "HEX_DIGIT", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", 
		"FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", 
		"RBRACE", "COLON", "DIAMOND", "SEMICOLON", "IF", "ENDIF", "ELSE", "ELSEIF", 
		"WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", "FOR", "IN", "ENDFOR", "OPERATOR", 
		"OUTERPRODUCT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2%\u0159\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\7\3X\n\3\f\3\16\3[\13\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\5\6e\n\6\3"+
		"\6\6\6h\n\6\r\6\16\6i\3\7\5\7m\n\7\3\7\6\7p\n\7\r\7\16\7q\3\7\3\7\7\7"+
		"v\n\7\f\7\16\7y\13\7\3\7\5\7|\n\7\3\7\5\7\177\n\7\3\7\3\7\6\7\u0083\n"+
		"\7\r\7\16\7\u0084\3\7\5\7\u0088\n\7\3\7\5\7\u008b\n\7\3\7\6\7\u008e\n"+
		"\7\r\7\16\7\u008f\3\7\5\7\u0093\n\7\3\b\3\b\5\b\u0097\n\b\3\b\3\b\3\b"+
		"\5\b\u009c\n\b\3\t\3\t\7\t\u00a0\n\t\f\t\16\t\u00a3\13\t\3\t\5\t\u00a6"+
		"\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\f\u00b3\n\f\f\f\16"+
		"\f\u00b6\13\f\3\f\3\f\3\r\3\r\5\r\u00bc\n\r\3\r\6\r\u00bf\n\r\r\r\16\r"+
		"\u00c0\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00c9\n\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d4\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0101\n\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0125\n\"\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u013d"+
		"\n$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\5\'\u0153\n\'\3(\3(\3)\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\2\33\2\35\2\37\2!\2#\16%\17\'\20)\21+\22-\23/\24"+
		"\61\25\63\26\65\27\67\309\31;\32=\33?\34A\35C\36E\37G I!K\"M#O$Q%\3\2"+
		"\r\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\13\17\17\"\"\4\2))^"+
		"^\4\2GGgg\4\2--//\5\2\62;CHch\n\2$$))^^ddhhppttvv\r\2--//>@\u00d9\u00d9"+
		"\u00f9\u00f9\u220c\u220c\u2229\u222c\u2262\u2262\u2266\u2267\u2284\u2285"+
		"\u2373\u2374\6\2\61\61^^\u00aa\u00aa\u2341\u2342\u0171\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7"+
		"^\3\2\2\2\ta\3\2\2\2\13d\3\2\2\2\r\u0092\3\2\2\2\17\u0096\3\2\2\2\21\u009d"+
		"\3\2\2\2\23\u00a9\3\2\2\2\25\u00ad\3\2\2\2\27\u00af\3\2\2\2\31\u00b9\3"+
		"\2\2\2\33\u00c2\3\2\2\2\35\u00c8\3\2\2\2\37\u00d3\3\2\2\2!\u00d5\3\2\2"+
		"\2#\u00dc\3\2\2\2%\u00de\3\2\2\2\'\u00e0\3\2\2\2)\u00e2\3\2\2\2+\u00e4"+
		"\3\2\2\2-\u00e6\3\2\2\2/\u00e8\3\2\2\2\61\u00ea\3\2\2\2\63\u00ec\3\2\2"+
		"\2\65\u00ee\3\2\2\2\67\u00f0\3\2\2\29\u00f2\3\2\2\2;\u0100\3\2\2\2=\u0102"+
		"\3\2\2\2?\u0108\3\2\2\2A\u0110\3\2\2\2C\u0124\3\2\2\2E\u0126\3\2\2\2G"+
		"\u013c\3\2\2\2I\u013e\3\2\2\2K\u0143\3\2\2\2M\u0152\3\2\2\2O\u0154\3\2"+
		"\2\2Q\u0156\3\2\2\2ST\7\60\2\2T\4\3\2\2\2UY\t\2\2\2VX\t\3\2\2WV\3\2\2"+
		"\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\b\3\2\2]\6\3"+
		"\2\2\2^_\5\5\3\2_`\7<\2\2`\b\3\2\2\2ab\7\u00b1\2\2b\n\3\2\2\2ce\5\t\5"+
		"\2dc\3\2\2\2de\3\2\2\2eg\3\2\2\2fh\4\62;\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2"+
		"\2ij\3\2\2\2j\f\3\2\2\2km\5\t\5\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2\2np\4\62"+
		";\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2sw\7\60\2\2tv\4\62"+
		";\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2z|\5\31"+
		"\r\2{z\3\2\2\2{|\3\2\2\2|\u0093\3\2\2\2}\177\5\t\5\2~}\3\2\2\2~\177\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080\u0082\7\60\2\2\u0081\u0083\4\62;\2\u0082"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0087\3\2\2\2\u0086\u0088\5\31\r\2\u0087\u0086\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0093\3\2\2\2\u0089\u008b\5\t\5\2\u008a\u0089\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\4\62;\2\u008d"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0093\5\31\r\2\u0092l\3\2\2\2\u0092~\3"+
		"\2\2\2\u0092\u008a\3\2\2\2\u0093\16\3\2\2\2\u0094\u0097\5\13\6\2\u0095"+
		"\u0097\5\r\7\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009b\7L\2\2\u0099\u009c\5\13\6\2\u009a\u009c\5\r\7\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\20\3\2\2\2\u009d\u00a1\7\u235f"+
		"\2\2\u009e\u00a0\n\4\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a4\u00a6\7\17\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\7\f\2\2\u00a8\22\3\2\2\2\u00a9\u00aa\t\5\2"+
		"\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\n\3\2\u00ac\24\3\2\2\2\u00ad\u00ae"+
		"\7\f\2\2\u00ae\26\3\2\2\2\u00af\u00b4\7)\2\2\u00b0\u00b3\5\35\17\2\u00b1"+
		"\u00b3\n\6\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b8\7)\2\2\u00b8\30\3\2\2\2\u00b9\u00bb\t\7\2\2"+
		"\u00ba\u00bc\t\b\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be"+
		"\3\2\2\2\u00bd\u00bf\4\62;\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\32\3\2\2\2\u00c2\u00c3\t\t\2"+
		"\2\u00c3\34\3\2\2\2\u00c4\u00c5\7^\2\2\u00c5\u00c9\t\n\2\2\u00c6\u00c9"+
		"\5!\21\2\u00c7\u00c9\5\37\20\2\u00c8\u00c4\3\2\2\2\u00c8\u00c6\3\2\2\2"+
		"\u00c8\u00c7\3\2\2\2\u00c9\36\3\2\2\2\u00ca\u00cb\7^\2\2\u00cb\u00cc\4"+
		"\62\65\2\u00cc\u00cd\4\629\2\u00cd\u00d4\4\629\2\u00ce\u00cf\7^\2\2\u00cf"+
		"\u00d0\4\629\2\u00d0\u00d4\4\629\2\u00d1\u00d2\7^\2\2\u00d2\u00d4\4\62"+
		"9\2\u00d3\u00ca\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		" \3\2\2\2\u00d5\u00d6\7^\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\5\33\16\2"+
		"\u00d8\u00d9\5\33\16\2\u00d9\u00da\5\33\16\2\u00da\u00db\5\33\16\2\u00db"+
		"\"\3\2\2\2\u00dc\u00dd\t\13\2\2\u00dd$\3\2\2\2\u00de\u00df\7\u2192\2\2"+
		"\u00df&\3\2\2\2\u00e0\u00e1\7*\2\2\u00e1(\3\2\2\2\u00e2\u00e3\7+\2\2\u00e3"+
		"*\3\2\2\2\u00e4\u00e5\7]\2\2\u00e5,\3\2\2\2\u00e6\u00e7\7_\2\2\u00e7."+
		"\3\2\2\2\u00e8\u00e9\7}\2\2\u00e9\60\3\2\2\2\u00ea\u00eb\7\177\2\2\u00eb"+
		"\62\3\2\2\2\u00ec\u00ed\7<\2\2\u00ed\64\3\2\2\2\u00ee\u00ef\7\u22c6\2"+
		"\2\u00ef\66\3\2\2\2\u00f0\u00f1\7=\2\2\u00f18\3\2\2\2\u00f2\u00f3\7<\2"+
		"\2\u00f3\u00f4\7K\2\2\u00f4\u00f5\7h\2\2\u00f5:\3\2\2\2\u00f6\u00f7\7"+
		"<\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7f\2\2\u00fa\u00fb"+
		"\7K\2\2\u00fb\u0101\7h\2\2\u00fc\u00fd\7<\2\2\u00fd\u00fe\7G\2\2\u00fe"+
		"\u00ff\7p\2\2\u00ff\u0101\7f\2\2\u0100\u00f6\3\2\2\2\u0100\u00fc\3\2\2"+
		"\2\u0101<\3\2\2\2\u0102\u0103\7<\2\2\u0103\u0104\7G\2\2\u0104\u0105\7"+
		"n\2\2\u0105\u0106\7u\2\2\u0106\u0107\7g\2\2\u0107>\3\2\2\2\u0108\u0109"+
		"\7<\2\2\u0109\u010a\7G\2\2\u010a\u010b\7n\2\2\u010b\u010c\7u\2\2\u010c"+
		"\u010d\7g\2\2\u010d\u010e\7K\2\2\u010e\u010f\7h\2\2\u010f@\3\2\2\2\u0110"+
		"\u0111\7<\2\2\u0111\u0112\7Y\2\2\u0112\u0113\7j\2\2\u0113\u0114\7k\2\2"+
		"\u0114\u0115\7n\2\2\u0115\u0116\7g\2\2\u0116B\3\2\2\2\u0117\u0118\7<\2"+
		"\2\u0118\u0119\7G\2\2\u0119\u011a\7p\2\2\u011a\u011b\7f\2\2\u011b\u011c"+
		"\7Y\2\2\u011c\u011d\7j\2\2\u011d\u011e\7k\2\2\u011e\u011f\7n\2\2\u011f"+
		"\u0125\7g\2\2\u0120\u0121\7<\2\2\u0121\u0122\7G\2\2\u0122\u0123\7p\2\2"+
		"\u0123\u0125\7f\2\2\u0124\u0117\3\2\2\2\u0124\u0120\3\2\2\2\u0125D\3\2"+
		"\2\2\u0126\u0127\7<\2\2\u0127\u0128\7T\2\2\u0128\u0129\7g\2\2\u0129\u012a"+
		"\7r\2\2\u012a\u012b\7g\2\2\u012b\u012c\7c\2\2\u012c\u012d\7v\2\2\u012d"+
		"F\3\2\2\2\u012e\u012f\7<\2\2\u012f\u0130\7G\2\2\u0130\u0131\7p\2\2\u0131"+
		"\u0132\7f\2\2\u0132\u0133\7T\2\2\u0133\u0134\7g\2\2\u0134\u0135\7r\2\2"+
		"\u0135\u0136\7g\2\2\u0136\u0137\7c\2\2\u0137\u013d\7v\2\2\u0138\u0139"+
		"\7<\2\2\u0139\u013a\7G\2\2\u013a\u013b\7p\2\2\u013b\u013d\7f\2\2\u013c"+
		"\u012e\3\2\2\2\u013c\u0138\3\2\2\2\u013dH\3\2\2\2\u013e\u013f\7<\2\2\u013f"+
		"\u0140\7H\2\2\u0140\u0141\7q\2\2\u0141\u0142\7t\2\2\u0142J\3\2\2\2\u0143"+
		"\u0144\7<\2\2\u0144\u0145\7K\2\2\u0145\u0146\7p\2\2\u0146L\3\2\2\2\u0147"+
		"\u0148\7<\2\2\u0148\u0149\7G\2\2\u0149\u014a\7p\2\2\u014a\u014b\7f\2\2"+
		"\u014b\u014c\7H\2\2\u014c\u014d\7q\2\2\u014d\u0153\7t\2\2\u014e\u014f"+
		"\7<\2\2\u014f\u0150\7G\2\2\u0150\u0151\7p\2\2\u0151\u0153\7f\2\2\u0152"+
		"\u0147\3\2\2\2\u0152\u014e\3\2\2\2\u0153N\3\2\2\2\u0154\u0155\t\f\2\2"+
		"\u0155P\3\2\2\2\u0156\u0157\7\u221a\2\2\u0157\u0158\7\60\2\2\u0158R\3"+
		"\2\2\2\36\2Ydilqw{~\u0084\u0087\u008a\u008f\u0092\u0096\u009b\u00a1\u00a5"+
		"\u00b2\u00b4\u00bb\u00c0\u00c8\u00d3\u0100\u0124\u013c\u0152\4\3\3\2\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}