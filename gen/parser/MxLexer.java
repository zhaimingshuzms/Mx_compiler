// Generated from C:/Users/zhaimingshuzms/Desktop/Compiler/Mx_compiler/src/parser\Mx.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, Int=4, Bool=5, String=6, Class=7, Void=8, True=9, 
		False=10, If=11, Else=12, For=13, Return=14, New=15, This=16, Continue=17, 
		Break=18, Null=19, Dot=20, LeftParen=21, RightParen=22, LeftBracket=23, 
		RightBracket=24, LeftBrace=25, RightBrace=26, Less=27, LessEqual=28, Greater=29, 
		GreaterEqual=30, LeftShift=31, RightShift=32, Plus=33, SelfPlus=34, Minus=35, 
		SelfMinus=36, Mul=37, Div=38, Mod=39, And=40, Or=41, AndAnd=42, OrOr=43, 
		Caret=44, Not=45, Tilde=46, Question=47, Colon=48, Semi=49, Comma=50, 
		Assign=51, Equal=52, NotEqual=53, BackSlash=54, DbQuotation=55, Identifier=56, 
		DecimalInteger=57, StringLiteral=58, Whitespace=59, Newline=60, BlockComment=61, 
		LineComment=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "Int", "Bool", "String", "Class", "Void", "True", 
			"False", "If", "Else", "For", "Return", "New", "This", "Continue", "Break", 
			"Null", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "SelfPlus", "Minus", "SelfMinus", 
			"Mul", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", 
			"Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"BackSlash", "DbQuotation", "Identifier", "DecimalInteger", "StringLiteral", 
			"Whitespace", "Newline", "BlockComment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[&]'", "'->'", "'[]'", "'int'", "'bool'", "'string'", "'class'", 
			"'void'", "'true'", "'false'", "'if'", "'else'", "'for'", "'return'", 
			"'new'", "'this'", "'continue'", "'break'", "'NULL'", "'.'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", 
			"'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", 
			"'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", "'=='", 
			"'!='", "'\\\\'", "'\\'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "Int", "Bool", "String", "Class", "Void", "True", 
			"False", "If", "Else", "For", "Return", "New", "This", "Continue", "Break", 
			"Null", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "SelfPlus", "Minus", "SelfMinus", 
			"Mul", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", 
			"Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"BackSlash", "DbQuotation", "Identifier", "DecimalInteger", "StringLiteral", 
			"Whitespace", "Newline", "BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u0177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		"\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\38\38\39\39\79\u0135\n9\f9\169\u0138\139\3:\3:\7:\u013c\n:\f"+
		":\16:\u013f\13:\3:\5:\u0142\n:\3;\3;\3;\3;\7;\u0148\n;\f;\16;\u014b\13"+
		";\3;\3;\3<\6<\u0150\n<\r<\16<\u0151\3<\3<\3=\3=\5=\u0158\n=\3=\5=\u015b"+
		"\n=\3=\3=\3>\3>\3>\3>\7>\u0163\n>\f>\16>\u0166\13>\3>\3>\3>\3>\3>\3?\3"+
		"?\3?\3?\7?\u0171\n?\f?\16?\u0174\13?\3?\3?\4\u0149\u0164\2@\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w"+
		"=y>{?}@\3\2\n\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\5\2\f\f$$^^\5\2"+
		"$$^^pp\4\2\13\13\"\"\4\2\f\f\17\17\2\u0180\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177"+
		"\3\2\2\2\5\u0083\3\2\2\2\7\u0086\3\2\2\2\t\u0089\3\2\2\2\13\u008d\3\2"+
		"\2\2\r\u0092\3\2\2\2\17\u0099\3\2\2\2\21\u009f\3\2\2\2\23\u00a4\3\2\2"+
		"\2\25\u00a9\3\2\2\2\27\u00af\3\2\2\2\31\u00b2\3\2\2\2\33\u00b7\3\2\2\2"+
		"\35\u00bb\3\2\2\2\37\u00c2\3\2\2\2!\u00c6\3\2\2\2#\u00cb\3\2\2\2%\u00d4"+
		"\3\2\2\2\'\u00da\3\2\2\2)\u00df\3\2\2\2+\u00e1\3\2\2\2-\u00e3\3\2\2\2"+
		"/\u00e5\3\2\2\2\61\u00e7\3\2\2\2\63\u00e9\3\2\2\2\65\u00eb\3\2\2\2\67"+
		"\u00ed\3\2\2\29\u00ef\3\2\2\2;\u00f2\3\2\2\2=\u00f4\3\2\2\2?\u00f7\3\2"+
		"\2\2A\u00fa\3\2\2\2C\u00fd\3\2\2\2E\u00ff\3\2\2\2G\u0102\3\2\2\2I\u0104"+
		"\3\2\2\2K\u0107\3\2\2\2M\u0109\3\2\2\2O\u010b\3\2\2\2Q\u010d\3\2\2\2S"+
		"\u010f\3\2\2\2U\u0111\3\2\2\2W\u0114\3\2\2\2Y\u0117\3\2\2\2[\u0119\3\2"+
		"\2\2]\u011b\3\2\2\2_\u011d\3\2\2\2a\u011f\3\2\2\2c\u0121\3\2\2\2e\u0123"+
		"\3\2\2\2g\u0125\3\2\2\2i\u0127\3\2\2\2k\u012a\3\2\2\2m\u012d\3\2\2\2o"+
		"\u0130\3\2\2\2q\u0132\3\2\2\2s\u0141\3\2\2\2u\u0143\3\2\2\2w\u014f\3\2"+
		"\2\2y\u015a\3\2\2\2{\u015e\3\2\2\2}\u016c\3\2\2\2\177\u0080\7]\2\2\u0080"+
		"\u0081\7(\2\2\u0081\u0082\7_\2\2\u0082\4\3\2\2\2\u0083\u0084\7/\2\2\u0084"+
		"\u0085\7@\2\2\u0085\6\3\2\2\2\u0086\u0087\7]\2\2\u0087\u0088\7_\2\2\u0088"+
		"\b\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2\2\u008b\u008c\7v\2\2\u008c"+
		"\n\3\2\2\2\u008d\u008e\7d\2\2\u008e\u008f\7q\2\2\u008f\u0090\7q\2\2\u0090"+
		"\u0091\7n\2\2\u0091\f\3\2\2\2\u0092\u0093\7u\2\2\u0093\u0094\7v\2\2\u0094"+
		"\u0095\7t\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\u0098\7i\2\2"+
		"\u0098\16\3\2\2\2\u0099\u009a\7e\2\2\u009a\u009b\7n\2\2\u009b\u009c\7"+
		"c\2\2\u009c\u009d\7u\2\2\u009d\u009e\7u\2\2\u009e\20\3\2\2\2\u009f\u00a0"+
		"\7x\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7f\2\2\u00a3"+
		"\22\3\2\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7w\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\24\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7c\2\2\u00ab"+
		"\u00ac\7n\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7g\2\2\u00ae\26\3\2\2\2\u00af"+
		"\u00b0\7k\2\2\u00b0\u00b1\7h\2\2\u00b1\30\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\u00b4\7n\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2\u00b6\32\3\2\2\2\u00b7"+
		"\u00b8\7h\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7t\2\2\u00ba\34\3\2\2\2\u00bb"+
		"\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7w\2\2"+
		"\u00bf\u00c0\7t\2\2\u00c0\u00c1\7p\2\2\u00c1\36\3\2\2\2\u00c2\u00c3\7"+
		"p\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7y\2\2\u00c5 \3\2\2\2\u00c6\u00c7"+
		"\7v\2\2\u00c7\u00c8\7j\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7u\2\2\u00ca"+
		"\"\3\2\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7p\2\2\u00ce"+
		"\u00cf\7v\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7w\2\2"+
		"\u00d2\u00d3\7g\2\2\u00d3$\3\2\2\2\u00d4\u00d5\7d\2\2\u00d5\u00d6\7t\2"+
		"\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7m\2\2\u00d9&\3\2"+
		"\2\2\u00da\u00db\7P\2\2\u00db\u00dc\7W\2\2\u00dc\u00dd\7N\2\2\u00dd\u00de"+
		"\7N\2\2\u00de(\3\2\2\2\u00df\u00e0\7\60\2\2\u00e0*\3\2\2\2\u00e1\u00e2"+
		"\7*\2\2\u00e2,\3\2\2\2\u00e3\u00e4\7+\2\2\u00e4.\3\2\2\2\u00e5\u00e6\7"+
		"]\2\2\u00e6\60\3\2\2\2\u00e7\u00e8\7_\2\2\u00e8\62\3\2\2\2\u00e9\u00ea"+
		"\7}\2\2\u00ea\64\3\2\2\2\u00eb\u00ec\7\177\2\2\u00ec\66\3\2\2\2\u00ed"+
		"\u00ee\7>\2\2\u00ee8\3\2\2\2\u00ef\u00f0\7>\2\2\u00f0\u00f1\7?\2\2\u00f1"+
		":\3\2\2\2\u00f2\u00f3\7@\2\2\u00f3<\3\2\2\2\u00f4\u00f5\7@\2\2\u00f5\u00f6"+
		"\7?\2\2\u00f6>\3\2\2\2\u00f7\u00f8\7>\2\2\u00f8\u00f9\7>\2\2\u00f9@\3"+
		"\2\2\2\u00fa\u00fb\7@\2\2\u00fb\u00fc\7@\2\2\u00fcB\3\2\2\2\u00fd\u00fe"+
		"\7-\2\2\u00feD\3\2\2\2\u00ff\u0100\7-\2\2\u0100\u0101\7-\2\2\u0101F\3"+
		"\2\2\2\u0102\u0103\7/\2\2\u0103H\3\2\2\2\u0104\u0105\7/\2\2\u0105\u0106"+
		"\7/\2\2\u0106J\3\2\2\2\u0107\u0108\7,\2\2\u0108L\3\2\2\2\u0109\u010a\7"+
		"\61\2\2\u010aN\3\2\2\2\u010b\u010c\7\'\2\2\u010cP\3\2\2\2\u010d\u010e"+
		"\7(\2\2\u010eR\3\2\2\2\u010f\u0110\7~\2\2\u0110T\3\2\2\2\u0111\u0112\7"+
		"(\2\2\u0112\u0113\7(\2\2\u0113V\3\2\2\2\u0114\u0115\7~\2\2\u0115\u0116"+
		"\7~\2\2\u0116X\3\2\2\2\u0117\u0118\7`\2\2\u0118Z\3\2\2\2\u0119\u011a\7"+
		"#\2\2\u011a\\\3\2\2\2\u011b\u011c\7\u0080\2\2\u011c^\3\2\2\2\u011d\u011e"+
		"\7A\2\2\u011e`\3\2\2\2\u011f\u0120\7<\2\2\u0120b\3\2\2\2\u0121\u0122\7"+
		"=\2\2\u0122d\3\2\2\2\u0123\u0124\7.\2\2\u0124f\3\2\2\2\u0125\u0126\7?"+
		"\2\2\u0126h\3\2\2\2\u0127\u0128\7?\2\2\u0128\u0129\7?\2\2\u0129j\3\2\2"+
		"\2\u012a\u012b\7#\2\2\u012b\u012c\7?\2\2\u012cl\3\2\2\2\u012d\u012e\7"+
		"^\2\2\u012e\u012f\7^\2\2\u012fn\3\2\2\2\u0130\u0131\7^\2\2\u0131p\3\2"+
		"\2\2\u0132\u0136\t\2\2\2\u0133\u0135\t\3\2\2\u0134\u0133\3\2\2\2\u0135"+
		"\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137r\3\2\2\2"+
		"\u0138\u0136\3\2\2\2\u0139\u013d\t\4\2\2\u013a\u013c\t\5\2\2\u013b\u013a"+
		"\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0142\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0142\7\62\2\2\u0141\u0139\3"+
		"\2\2\2\u0141\u0140\3\2\2\2\u0142t\3\2\2\2\u0143\u0149\7$\2\2\u0144\u0148"+
		"\n\6\2\2\u0145\u0146\7^\2\2\u0146\u0148\t\7\2\2\u0147\u0144\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u014a\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7$\2\2\u014d"+
		"v\3\2\2\2\u014e\u0150\t\b\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2"+
		"\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154"+
		"\b<\2\2\u0154x\3\2\2\2\u0155\u0157\7\17\2\2\u0156\u0158\7\f\2\2\u0157"+
		"\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u015b\7\f"+
		"\2\2\u015a\u0155\3\2\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015d\b=\2\2\u015dz\3\2\2\2\u015e\u015f\7\61\2\2\u015f\u0160\7,\2\2\u0160"+
		"\u0164\3\2\2\2\u0161\u0163\13\2\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3"+
		"\2\2\2\u0164\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0167\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0167\u0168\7,\2\2\u0168\u0169\7\61\2\2\u0169\u016a\3\2"+
		"\2\2\u016a\u016b\b>\2\2\u016b|\3\2\2\2\u016c\u016d\7\61\2\2\u016d\u016e"+
		"\7\61\2\2\u016e\u0172\3\2\2\2\u016f\u0171\n\t\2\2\u0170\u016f\3\2\2\2"+
		"\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175"+
		"\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\b?\2\2\u0176~\3\2\2\2\r\2\u0136"+
		"\u013d\u0141\u0147\u0149\u0151\u0157\u015a\u0164\u0172\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}