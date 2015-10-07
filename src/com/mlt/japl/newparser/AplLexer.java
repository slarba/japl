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
		ID=1, INT=2, FLOAT=3, COMMENT=4, WS=5, NL=6, STRING=7, FUNC=8, ASSIGN=9, 
		LPAREN=10, RPAREN=11, LBRACKET=12, RBRACKET=13, LBRACE=14, RBRACE=15, 
		COLON=16, DIAMOND=17, IF=18, ENDIF=19, ELSE=20, ELSEIF=21, WHILE=22, ENDWHILE=23, 
		REPEAT=24, ENDREPEAT=25, FOR=26, IN=27, ENDFOR=28, OPERATOR=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ID", "INT", "FLOAT", "COMMENT", "WS", "NL", "STRING", "EXPONENT", "HEX_DIGIT", 
		"ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "FUNC", "ASSIGN", "LPAREN", "RPAREN", 
		"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COLON", "DIAMOND", "IF", 
		"ENDIF", "ELSE", "ELSEIF", "WHILE", "ENDWHILE", "REPEAT", "ENDREPEAT", 
		"FOR", "IN", "ENDFOR", "OPERATOR"
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


	boolean isFnSymbol(String sym) {
	   System.out.println("foo");
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
		case 0:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u012c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\6\3"+
		"R\n\3\r\3\16\3S\3\4\6\4W\n\4\r\4\16\4X\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4"+
		"\3\4\5\4c\n\4\3\4\3\4\6\4g\n\4\r\4\16\4h\3\4\5\4l\n\4\3\4\6\4o\n\4\r\4"+
		"\16\4p\3\4\5\4t\n\4\3\5\3\5\7\5x\n\5\f\5\16\5{\13\5\3\5\5\5~\n\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b\u008e\13"+
		"\b\3\b\3\b\3\t\3\t\5\t\u0094\n\t\3\t\6\t\u0097\n\t\r\t\16\t\u0098\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\5\13\u00a1\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00ac\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\5\31\u00d7\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fb\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0113\n\37\3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0129\n"+
		"\"\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31\2\33"+
		"\n\35\13\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65\27\67\30"+
		"9\31;\32=\33?\34A\35C\36E\37\3\2\r\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17"+
		"\17\5\2\13\13\17\17\"\"\4\2))^^\4\2GGgg\4\2--//\5\2\62;CHch\n\2$$))^^"+
		"ddhhppttvv\r\2--//>@\u00d9\u00d9\u00f9\u00f9\u220c\u220c\u2229\u222c\u2262"+
		"\u2262\u2266\u2267\u2284\u2285\u2373\u2374\5\2\61\61^^\u00aa\u00aa\u013e"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G"+
		"\3\2\2\2\5Q\3\2\2\2\7s\3\2\2\2\tu\3\2\2\2\13\u0081\3\2\2\2\r\u0085\3\2"+
		"\2\2\17\u0087\3\2\2\2\21\u0091\3\2\2\2\23\u009a\3\2\2\2\25\u00a0\3\2\2"+
		"\2\27\u00ab\3\2\2\2\31\u00ad\3\2\2\2\33\u00b4\3\2\2\2\35\u00b6\3\2\2\2"+
		"\37\u00b8\3\2\2\2!\u00ba\3\2\2\2#\u00bc\3\2\2\2%\u00be\3\2\2\2\'\u00c0"+
		"\3\2\2\2)\u00c2\3\2\2\2+\u00c4\3\2\2\2-\u00c6\3\2\2\2/\u00c8\3\2\2\2\61"+
		"\u00d6\3\2\2\2\63\u00d8\3\2\2\2\65\u00de\3\2\2\2\67\u00e6\3\2\2\29\u00fa"+
		"\3\2\2\2;\u00fc\3\2\2\2=\u0112\3\2\2\2?\u0114\3\2\2\2A\u0119\3\2\2\2C"+
		"\u0128\3\2\2\2E\u012a\3\2\2\2GK\t\2\2\2HJ\t\3\2\2IH\3\2\2\2JM\3\2\2\2"+
		"KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\b\2\2\2O\4\3\2\2\2PR\4\62;"+
		"\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\6\3\2\2\2UW\4\62;\2VU\3\2"+
		"\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z^\7\60\2\2[]\4\62;\2\\[\3"+
		"\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2ac\5\21\t\2b"+
		"a\3\2\2\2bc\3\2\2\2ct\3\2\2\2df\7\60\2\2eg\4\62;\2fe\3\2\2\2gh\3\2\2\2"+
		"hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jl\5\21\t\2kj\3\2\2\2kl\3\2\2\2lt\3\2\2"+
		"\2mo\4\62;\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rt\5\21"+
		"\t\2sV\3\2\2\2sd\3\2\2\2sn\3\2\2\2t\b\3\2\2\2uy\7\u235f\2\2vx\n\4\2\2"+
		"wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3\2\2\2{y\3\2\2\2|~\7\17\2"+
		"\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\f\2\2\u0080\n\3\2\2\2"+
		"\u0081\u0082\t\5\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\6\3\2\u0084\f\3"+
		"\2\2\2\u0085\u0086\7\f\2\2\u0086\16\3\2\2\2\u0087\u008c\7)\2\2\u0088\u008b"+
		"\5\25\13\2\u0089\u008b\n\6\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2"+
		"\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7)\2\2\u0090\20\3\2\2\2\u0091"+
		"\u0093\t\7\2\2\u0092\u0094\t\b\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0096\3\2\2\2\u0095\u0097\4\62;\2\u0096\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\22\3\2\2"+
		"\2\u009a\u009b\t\t\2\2\u009b\24\3\2\2\2\u009c\u009d\7^\2\2\u009d\u00a1"+
		"\t\n\2\2\u009e\u00a1\5\31\r\2\u009f\u00a1\5\27\f\2\u00a0\u009c\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\26\3\2\2\2\u00a2\u00a3"+
		"\7^\2\2\u00a3\u00a4\4\62\65\2\u00a4\u00a5\4\629\2\u00a5\u00ac\4\629\2"+
		"\u00a6\u00a7\7^\2\2\u00a7\u00a8\4\629\2\u00a8\u00ac\4\629\2\u00a9\u00aa"+
		"\7^\2\2\u00aa\u00ac\4\629\2\u00ab\u00a2\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7^\2\2\u00ae\u00af\7w\2\2"+
		"\u00af\u00b0\5\23\n\2\u00b0\u00b1\5\23\n\2\u00b1\u00b2\5\23\n\2\u00b2"+
		"\u00b3\5\23\n\2\u00b3\32\3\2\2\2\u00b4\u00b5\t\13\2\2\u00b5\34\3\2\2\2"+
		"\u00b6\u00b7\7\u2192\2\2\u00b7\36\3\2\2\2\u00b8\u00b9\7*\2\2\u00b9 \3"+
		"\2\2\2\u00ba\u00bb\7+\2\2\u00bb\"\3\2\2\2\u00bc\u00bd\7]\2\2\u00bd$\3"+
		"\2\2\2\u00be\u00bf\7_\2\2\u00bf&\3\2\2\2\u00c0\u00c1\7}\2\2\u00c1(\3\2"+
		"\2\2\u00c2\u00c3\7\177\2\2\u00c3*\3\2\2\2\u00c4\u00c5\7<\2\2\u00c5,\3"+
		"\2\2\2\u00c6\u00c7\7\u22c6\2\2\u00c7.\3\2\2\2\u00c8\u00c9\7<\2\2\u00c9"+
		"\u00ca\7K\2\2\u00ca\u00cb\7h\2\2\u00cb\60\3\2\2\2\u00cc\u00cd\7<\2\2\u00cd"+
		"\u00ce\7G\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7f\2\2\u00d0\u00d1\7K\2\2"+
		"\u00d1\u00d7\7h\2\2\u00d2\u00d3\7<\2\2\u00d3\u00d4\7G\2\2\u00d4\u00d5"+
		"\7p\2\2\u00d5\u00d7\7f\2\2\u00d6\u00cc\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d7"+
		"\62\3\2\2\2\u00d8\u00d9\7<\2\2\u00d9\u00da\7G\2\2\u00da\u00db\7n\2\2\u00db"+
		"\u00dc\7u\2\2\u00dc\u00dd\7g\2\2\u00dd\64\3\2\2\2\u00de\u00df\7<\2\2\u00df"+
		"\u00e0\7G\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2"+
		"\u00e3\u00e4\7K\2\2\u00e4\u00e5\7h\2\2\u00e5\66\3\2\2\2\u00e6\u00e7\7"+
		"<\2\2\u00e7\u00e8\7Y\2\2\u00e8\u00e9\7j\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb"+
		"\7n\2\2\u00eb\u00ec\7g\2\2\u00ec8\3\2\2\2\u00ed\u00ee\7<\2\2\u00ee\u00ef"+
		"\7G\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7f\2\2\u00f1\u00f2\7Y\2\2\u00f2"+
		"\u00f3\7j\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7n\2\2\u00f5\u00fb\7g\2\2"+
		"\u00f6\u00f7\7<\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fb"+
		"\7f\2\2\u00fa\u00ed\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb:\3\2\2\2\u00fc\u00fd"+
		"\7<\2\2\u00fd\u00fe\7T\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7r\2\2\u0100"+
		"\u0101\7g\2\2\u0101\u0102\7c\2\2\u0102\u0103\7v\2\2\u0103<\3\2\2\2\u0104"+
		"\u0105\7<\2\2\u0105\u0106\7G\2\2\u0106\u0107\7p\2\2\u0107\u0108\7f\2\2"+
		"\u0108\u0109\7T\2\2\u0109\u010a\7g\2\2\u010a\u010b\7r\2\2\u010b\u010c"+
		"\7g\2\2\u010c\u010d\7c\2\2\u010d\u0113\7v\2\2\u010e\u010f\7<\2\2\u010f"+
		"\u0110\7G\2\2\u0110\u0111\7p\2\2\u0111\u0113\7f\2\2\u0112\u0104\3\2\2"+
		"\2\u0112\u010e\3\2\2\2\u0113>\3\2\2\2\u0114\u0115\7<\2\2\u0115\u0116\7"+
		"H\2\2\u0116\u0117\7q\2\2\u0117\u0118\7t\2\2\u0118@\3\2\2\2\u0119\u011a"+
		"\7<\2\2\u011a\u011b\7K\2\2\u011b\u011c\7p\2\2\u011cB\3\2\2\2\u011d\u011e"+
		"\7<\2\2\u011e\u011f\7G\2\2\u011f\u0120\7p\2\2\u0120\u0121\7f\2\2\u0121"+
		"\u0122\7H\2\2\u0122\u0123\7q\2\2\u0123\u0129\7t\2\2\u0124\u0125\7<\2\2"+
		"\u0125\u0126\7G\2\2\u0126\u0127\7p\2\2\u0127\u0129\7f\2\2\u0128\u011d"+
		"\3\2\2\2\u0128\u0124\3\2\2\2\u0129D\3\2\2\2\u012a\u012b\t\f\2\2\u012b"+
		"F\3\2\2\2\30\2KSX^bhkpsy}\u008a\u008c\u0093\u0098\u00a0\u00ab\u00d6\u00fa"+
		"\u0112\u0128\4\3\2\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}