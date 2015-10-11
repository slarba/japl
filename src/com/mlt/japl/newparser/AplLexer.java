// Generated from /Users/markolau/IdeaProjects/Japl/src/com/mlt/japl/newparser/Apl.g4 by ANTLR 4.5.1
package com.mlt.japl.newparser;
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
		ENDREPEAT=30, FOR=31, IN=32, ENDFOR=33, OPERATOR=34, POWEROPERATOR=35, 
		BOUNDWITH=36, OUTERPRODUCT=37, DEL=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "ID", "LABEL", "SIGN", "INT", "FLOAT", "COMPLEX", "COMMENT", "WS", 
		"NL", "STRING", "EXPONENT", "HEX_DIGIT", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", 
		"FUNC", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", 
		"RBRACE", "COLON", "DIAMOND", "SEMICOLON", "IF", "ENDIF", "ELSE", "ELSEIF", 
		"WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", "FOR", "IN", "ENDFOR", "OPERATOR", 
		"POWEROPERATOR", "BOUNDWITH", "OUTERPRODUCT", "DEL"
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u0163\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\7\3^\n\3\f\3\16\3a\13\3\3\4\3\4\3\4\3\5\3\5\3\6\5"+
		"\6i\n\6\3\6\6\6l\n\6\r\6\16\6m\3\7\5\7q\n\7\3\7\6\7t\n\7\r\7\16\7u\3\7"+
		"\3\7\7\7z\n\7\f\7\16\7}\13\7\3\7\5\7\u0080\n\7\3\7\5\7\u0083\n\7\3\7\3"+
		"\7\6\7\u0087\n\7\r\7\16\7\u0088\3\7\5\7\u008c\n\7\3\7\5\7\u008f\n\7\3"+
		"\7\6\7\u0092\n\7\r\7\16\7\u0093\3\7\5\7\u0097\n\7\3\b\3\b\5\b\u009b\n"+
		"\b\3\b\3\b\3\b\5\b\u00a0\n\b\3\t\3\t\7\t\u00a4\n\t\f\t\16\t\u00a7\13\t"+
		"\3\t\5\t\u00aa\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\f\u00b7"+
		"\n\f\f\f\16\f\u00ba\13\f\3\f\3\f\3\r\3\r\5\r\u00c0\n\r\3\r\6\r\u00c3\n"+
		"\r\r\r\16\r\u00c4\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00cd\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d8\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0105"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0129"+
		"\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\5$\u0141\n$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\5\'\u0157\n\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\2\2-\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35\2\37\2!\2"+
		"#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65\27\67\309\31;\32=\33?\34"+
		"A\35C\36E\37G I!K\"M#O$Q%S&U\'W(\3\2\r\7\2C\\aac|\u2377\u2377\u237c\u237c"+
		"\b\2\62;C\\aac|\u2377\u2377\u237c\u237c\4\2\f\f\17\17\5\2\13\13\17\17"+
		"\"\"\4\2))^^\4\2GGgg\4\2--//\5\2\62;CHch\n\2$$))^^ddhhppttvv \2##-/>A"+
		"\u00d9\u00d9\u00f9\u00f9\u2193\u2193\u2195\u2195\u220c\u220c\u2214\u2214"+
		"\u2225\u2225\u2229\u222c\u223e\u223e\u2262\u2263\u2266\u2267\u2284\u2285"+
		"\u2298\u2298\u22a6\u22a7\u22c8\u22c8\u230a\u230a\u230c\u230c\u233b\u233b"+
		"\u233f\u233f\u234b\u234b\u234d\u234d\u2350\u2350\u2354\u2354\u2357\u2357"+
		"\u2361\u2361\u2373\u2376\u25cd\u25cd\6\2\61\61^^\u00aa\u00aa\u2341\u2342"+
		"\u017b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7b\3\2\2\2\t"+
		"e\3\2\2\2\13h\3\2\2\2\r\u0096\3\2\2\2\17\u009a\3\2\2\2\21\u00a1\3\2\2"+
		"\2\23\u00ad\3\2\2\2\25\u00b1\3\2\2\2\27\u00b3\3\2\2\2\31\u00bd\3\2\2\2"+
		"\33\u00c6\3\2\2\2\35\u00cc\3\2\2\2\37\u00d7\3\2\2\2!\u00d9\3\2\2\2#\u00e0"+
		"\3\2\2\2%\u00e2\3\2\2\2\'\u00e4\3\2\2\2)\u00e6\3\2\2\2+\u00e8\3\2\2\2"+
		"-\u00ea\3\2\2\2/\u00ec\3\2\2\2\61\u00ee\3\2\2\2\63\u00f0\3\2\2\2\65\u00f2"+
		"\3\2\2\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u0104\3\2\2\2=\u0106\3\2\2\2"+
		"?\u010c\3\2\2\2A\u0114\3\2\2\2C\u0128\3\2\2\2E\u012a\3\2\2\2G\u0140\3"+
		"\2\2\2I\u0142\3\2\2\2K\u0147\3\2\2\2M\u0156\3\2\2\2O\u0158\3\2\2\2Q\u015a"+
		"\3\2\2\2S\u015c\3\2\2\2U\u015e\3\2\2\2W\u0161\3\2\2\2YZ\7\60\2\2Z\4\3"+
		"\2\2\2[_\t\2\2\2\\^\t\3\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`"+
		"\6\3\2\2\2a_\3\2\2\2bc\5\5\3\2cd\7<\2\2d\b\3\2\2\2ef\7\u00b1\2\2f\n\3"+
		"\2\2\2gi\5\t\5\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jl\4\62;\2kj\3\2\2\2lm\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2n\f\3\2\2\2oq\5\t\5\2po\3\2\2\2pq\3\2\2\2qs"+
		"\3\2\2\2rt\4\62;\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2w"+
		"{\7\60\2\2xz\4\62;\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2"+
		"\2\2}{\3\2\2\2~\u0080\5\31\r\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0097"+
		"\3\2\2\2\u0081\u0083\5\t\5\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\7\60\2\2\u0085\u0087\4\62;\2\u0086\u0085\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u008c\5\31\r\2\u008b\u008a\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u0097\3\2\2\2\u008d\u008f\5\t\5\2\u008e\u008d\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0092\4\62;\2\u0091\u0090\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0097\5\31\r\2\u0096p\3\2\2\2\u0096\u0082\3\2\2\2"+
		"\u0096\u008e\3\2\2\2\u0097\16\3\2\2\2\u0098\u009b\5\13\6\2\u0099\u009b"+
		"\5\r\7\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009f\7L\2\2\u009d\u00a0\5\13\6\2\u009e\u00a0\5\r\7\2\u009f\u009d\3\2"+
		"\2\2\u009f\u009e\3\2\2\2\u00a0\20\3\2\2\2\u00a1\u00a5\7\u235f\2\2\u00a2"+
		"\u00a4\n\4\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00aa\7\17\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00ac\7\f\2\2\u00ac\22\3\2\2\2\u00ad\u00ae\t\5\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\b\n\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\7\f\2"+
		"\2\u00b2\26\3\2\2\2\u00b3\u00b8\7)\2\2\u00b4\u00b7\5\35\17\2\u00b5\u00b7"+
		"\n\6\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00bc\7)\2\2\u00bc\30\3\2\2\2\u00bd\u00bf\t\7\2\2\u00be\u00c0"+
		"\t\b\2\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00c3\4\62;\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\32\3\2\2\2\u00c6\u00c7\t\t\2\2\u00c7\34"+
		"\3\2\2\2\u00c8\u00c9\7^\2\2\u00c9\u00cd\t\n\2\2\u00ca\u00cd\5!\21\2\u00cb"+
		"\u00cd\5\37\20\2\u00cc\u00c8\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3"+
		"\2\2\2\u00cd\36\3\2\2\2\u00ce\u00cf\7^\2\2\u00cf\u00d0\4\62\65\2\u00d0"+
		"\u00d1\4\629\2\u00d1\u00d8\4\629\2\u00d2\u00d3\7^\2\2\u00d3\u00d4\4\62"+
		"9\2\u00d4\u00d8\4\629\2\u00d5\u00d6\7^\2\2\u00d6\u00d8\4\629\2\u00d7\u00ce"+
		"\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8 \3\2\2\2\u00d9"+
		"\u00da\7^\2\2\u00da\u00db\7w\2\2\u00db\u00dc\5\33\16\2\u00dc\u00dd\5\33"+
		"\16\2\u00dd\u00de\5\33\16\2\u00de\u00df\5\33\16\2\u00df\"\3\2\2\2\u00e0"+
		"\u00e1\t\13\2\2\u00e1$\3\2\2\2\u00e2\u00e3\7\u2192\2\2\u00e3&\3\2\2\2"+
		"\u00e4\u00e5\7*\2\2\u00e5(\3\2\2\2\u00e6\u00e7\7+\2\2\u00e7*\3\2\2\2\u00e8"+
		"\u00e9\7]\2\2\u00e9,\3\2\2\2\u00ea\u00eb\7_\2\2\u00eb.\3\2\2\2\u00ec\u00ed"+
		"\7}\2\2\u00ed\60\3\2\2\2\u00ee\u00ef\7\177\2\2\u00ef\62\3\2\2\2\u00f0"+
		"\u00f1\7<\2\2\u00f1\64\3\2\2\2\u00f2\u00f3\7\u22c6\2\2\u00f3\66\3\2\2"+
		"\2\u00f4\u00f5\7=\2\2\u00f58\3\2\2\2\u00f6\u00f7\7<\2\2\u00f7\u00f8\7"+
		"K\2\2\u00f8\u00f9\7h\2\2\u00f9:\3\2\2\2\u00fa\u00fb\7<\2\2\u00fb\u00fc"+
		"\7G\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7f\2\2\u00fe\u00ff\7K\2\2\u00ff"+
		"\u0105\7h\2\2\u0100\u0101\7<\2\2\u0101\u0102\7G\2\2\u0102\u0103\7p\2\2"+
		"\u0103\u0105\7f\2\2\u0104\u00fa\3\2\2\2\u0104\u0100\3\2\2\2\u0105<\3\2"+
		"\2\2\u0106\u0107\7<\2\2\u0107\u0108\7G\2\2\u0108\u0109\7n\2\2\u0109\u010a"+
		"\7u\2\2\u010a\u010b\7g\2\2\u010b>\3\2\2\2\u010c\u010d\7<\2\2\u010d\u010e"+
		"\7G\2\2\u010e\u010f\7n\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111"+
		"\u0112\7K\2\2\u0112\u0113\7h\2\2\u0113@\3\2\2\2\u0114\u0115\7<\2\2\u0115"+
		"\u0116\7Y\2\2\u0116\u0117\7j\2\2\u0117\u0118\7k\2\2\u0118\u0119\7n\2\2"+
		"\u0119\u011a\7g\2\2\u011aB\3\2\2\2\u011b\u011c\7<\2\2\u011c\u011d\7G\2"+
		"\2\u011d\u011e\7p\2\2\u011e\u011f\7f\2\2\u011f\u0120\7Y\2\2\u0120\u0121"+
		"\7j\2\2\u0121\u0122\7k\2\2\u0122\u0123\7n\2\2\u0123\u0129\7g\2\2\u0124"+
		"\u0125\7<\2\2\u0125\u0126\7G\2\2\u0126\u0127\7p\2\2\u0127\u0129\7f\2\2"+
		"\u0128\u011b\3\2\2\2\u0128\u0124\3\2\2\2\u0129D\3\2\2\2\u012a\u012b\7"+
		"<\2\2\u012b\u012c\7T\2\2\u012c\u012d\7g\2\2\u012d\u012e\7r\2\2\u012e\u012f"+
		"\7g\2\2\u012f\u0130\7c\2\2\u0130\u0131\7v\2\2\u0131F\3\2\2\2\u0132\u0133"+
		"\7<\2\2\u0133\u0134\7G\2\2\u0134\u0135\7p\2\2\u0135\u0136\7f\2\2\u0136"+
		"\u0137\7T\2\2\u0137\u0138\7g\2\2\u0138\u0139\7r\2\2\u0139\u013a\7g\2\2"+
		"\u013a\u013b\7c\2\2\u013b\u0141\7v\2\2\u013c\u013d\7<\2\2\u013d\u013e"+
		"\7G\2\2\u013e\u013f\7p\2\2\u013f\u0141\7f\2\2\u0140\u0132\3\2\2\2\u0140"+
		"\u013c\3\2\2\2\u0141H\3\2\2\2\u0142\u0143\7<\2\2\u0143\u0144\7H\2\2\u0144"+
		"\u0145\7q\2\2\u0145\u0146\7t\2\2\u0146J\3\2\2\2\u0147\u0148\7<\2\2\u0148"+
		"\u0149\7K\2\2\u0149\u014a\7p\2\2\u014aL\3\2\2\2\u014b\u014c\7<\2\2\u014c"+
		"\u014d\7G\2\2\u014d\u014e\7p\2\2\u014e\u014f\7f\2\2\u014f\u0150\7H\2\2"+
		"\u0150\u0151\7q\2\2\u0151\u0157\7t\2\2\u0152\u0153\7<\2\2\u0153\u0154"+
		"\7G\2\2\u0154\u0155\7p\2\2\u0155\u0157\7f\2\2\u0156\u014b\3\2\2\2\u0156"+
		"\u0152\3\2\2\2\u0157N\3\2\2\2\u0158\u0159\t\f\2\2\u0159P\3\2\2\2\u015a"+
		"\u015b\7\u2365\2\2\u015bR\3\2\2\2\u015c\u015d\7\u221a\2\2\u015dT\3\2\2"+
		"\2\u015e\u015f\5S*\2\u015f\u0160\7\60\2\2\u0160V\3\2\2\2\u0161\u0162\7"+
		"\u2209\2\2\u0162X\3\2\2\2\36\2_hmpu{\177\u0082\u0088\u008b\u008e\u0093"+
		"\u0096\u009a\u009f\u00a5\u00a9\u00b6\u00b8\u00bf\u00c4\u00cc\u00d7\u0104"+
		"\u0128\u0140\u0156\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}