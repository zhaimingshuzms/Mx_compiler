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
		Break=18, Null=19, While=20, Dot=21, LeftParen=22, RightParen=23, LeftBracket=24, 
		RightBracket=25, LeftBrace=26, RightBrace=27, Less=28, LessEqual=29, Greater=30, 
		GreaterEqual=31, LeftShift=32, RightShift=33, Plus=34, SelfPlus=35, Minus=36, 
		SelfMinus=37, Mul=38, Div=39, Mod=40, And=41, Or=42, AndAnd=43, OrOr=44, 
		Caret=45, Not=46, Tilde=47, Question=48, Colon=49, Semi=50, Comma=51, 
		Assign=52, Equal=53, NotEqual=54, BackSlash=55, DbQuotation=56, Identifier=57, 
		DecimalInteger=58, StringLiteral=59, Whitespace=60, Newline=61, BlockComment=62, 
		LineComment=63;
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
			"Null", "While", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
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
			"'new'", "'this'", "'continue'", "'break'", "'NULL'", "'while'", "'.'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", 
			"'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", 
			"'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", 
			"'='", "'=='", "'!='", "'\\\\'", "'\\'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "Int", "Bool", "String", "Class", "Void", "True", 
			"False", "If", "Else", "For", "Return", "New", "This", "Continue", "Break", 
			"Null", "While", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u017f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\7:\u013d\n:\f:\16:\u0140"+
		"\13:\3;\3;\7;\u0144\n;\f;\16;\u0147\13;\3;\5;\u014a\n;\3<\3<\3<\3<\7<"+
		"\u0150\n<\f<\16<\u0153\13<\3<\3<\3=\6=\u0158\n=\r=\16=\u0159\3=\3=\3>"+
		"\3>\5>\u0160\n>\3>\5>\u0163\n>\3>\3>\3?\3?\3?\3?\7?\u016b\n?\f?\16?\u016e"+
		"\13?\3?\3?\3?\3?\3?\3@\3@\3@\3@\7@\u0179\n@\f@\16@\u017c\13@\3@\3@\4\u0151"+
		"\u016c\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=y>{?}@\177A\3\2\n\4\2C\\c|\6\2\62;C\\aac|\3\2\63;"+
		"\3\2\62;\5\2\f\f$$^^\5\2$$^^pp\4\2\13\13\"\"\4\2\f\f\17\17\2\u0188\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u0085\3\2\2\2\7\u0088"+
		"\3\2\2\2\t\u008b\3\2\2\2\13\u008f\3\2\2\2\r\u0094\3\2\2\2\17\u009b\3\2"+
		"\2\2\21\u00a1\3\2\2\2\23\u00a6\3\2\2\2\25\u00ab\3\2\2\2\27\u00b1\3\2\2"+
		"\2\31\u00b4\3\2\2\2\33\u00b9\3\2\2\2\35\u00bd\3\2\2\2\37\u00c4\3\2\2\2"+
		"!\u00c8\3\2\2\2#\u00cd\3\2\2\2%\u00d6\3\2\2\2\'\u00dc\3\2\2\2)\u00e1\3"+
		"\2\2\2+\u00e7\3\2\2\2-\u00e9\3\2\2\2/\u00eb\3\2\2\2\61\u00ed\3\2\2\2\63"+
		"\u00ef\3\2\2\2\65\u00f1\3\2\2\2\67\u00f3\3\2\2\29\u00f5\3\2\2\2;\u00f7"+
		"\3\2\2\2=\u00fa\3\2\2\2?\u00fc\3\2\2\2A\u00ff\3\2\2\2C\u0102\3\2\2\2E"+
		"\u0105\3\2\2\2G\u0107\3\2\2\2I\u010a\3\2\2\2K\u010c\3\2\2\2M\u010f\3\2"+
		"\2\2O\u0111\3\2\2\2Q\u0113\3\2\2\2S\u0115\3\2\2\2U\u0117\3\2\2\2W\u0119"+
		"\3\2\2\2Y\u011c\3\2\2\2[\u011f\3\2\2\2]\u0121\3\2\2\2_\u0123\3\2\2\2a"+
		"\u0125\3\2\2\2c\u0127\3\2\2\2e\u0129\3\2\2\2g\u012b\3\2\2\2i\u012d\3\2"+
		"\2\2k\u012f\3\2\2\2m\u0132\3\2\2\2o\u0135\3\2\2\2q\u0138\3\2\2\2s\u013a"+
		"\3\2\2\2u\u0149\3\2\2\2w\u014b\3\2\2\2y\u0157\3\2\2\2{\u0162\3\2\2\2}"+
		"\u0166\3\2\2\2\177\u0174\3\2\2\2\u0081\u0082\7]\2\2\u0082\u0083\7(\2\2"+
		"\u0083\u0084\7_\2\2\u0084\4\3\2\2\2\u0085\u0086\7/\2\2\u0086\u0087\7@"+
		"\2\2\u0087\6\3\2\2\2\u0088\u0089\7]\2\2\u0089\u008a\7_\2\2\u008a\b\3\2"+
		"\2\2\u008b\u008c\7k\2\2\u008c\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\n"+
		"\3\2\2\2\u008f\u0090\7d\2\2\u0090\u0091\7q\2\2\u0091\u0092\7q\2\2\u0092"+
		"\u0093\7n\2\2\u0093\f\3\2\2\2\u0094\u0095\7u\2\2\u0095\u0096\7v\2\2\u0096"+
		"\u0097\7t\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\u009a\7i\2\2"+
		"\u009a\16\3\2\2\2\u009b\u009c\7e\2\2\u009c\u009d\7n\2\2\u009d\u009e\7"+
		"c\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7u\2\2\u00a0\20\3\2\2\2\u00a1\u00a2"+
		"\7x\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7f\2\2\u00a5"+
		"\22\3\2\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7w\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\24\3\2\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad\7c\2\2\u00ad"+
		"\u00ae\7n\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0\26\3\2\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b3\30\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7g\2\2\u00b8\32\3\2\2\2\u00b9"+
		"\u00ba\7h\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7t\2\2\u00bc\34\3\2\2\2\u00bd"+
		"\u00be\7t\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7w\2\2"+
		"\u00c1\u00c2\7t\2\2\u00c2\u00c3\7p\2\2\u00c3\36\3\2\2\2\u00c4\u00c5\7"+
		"p\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7y\2\2\u00c7 \3\2\2\2\u00c8\u00c9"+
		"\7v\2\2\u00c9\u00ca\7j\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7u\2\2\u00cc"+
		"\"\3\2\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7p\2\2\u00d0"+
		"\u00d1\7v\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7w\2\2"+
		"\u00d4\u00d5\7g\2\2\u00d5$\3\2\2\2\u00d6\u00d7\7d\2\2\u00d7\u00d8\7t\2"+
		"\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7m\2\2\u00db&\3\2"+
		"\2\2\u00dc\u00dd\7P\2\2\u00dd\u00de\7W\2\2\u00de\u00df\7N\2\2\u00df\u00e0"+
		"\7N\2\2\u00e0(\3\2\2\2\u00e1\u00e2\7y\2\2\u00e2\u00e3\7j\2\2\u00e3\u00e4"+
		"\7k\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7g\2\2\u00e6*\3\2\2\2\u00e7\u00e8"+
		"\7\60\2\2\u00e8,\3\2\2\2\u00e9\u00ea\7*\2\2\u00ea.\3\2\2\2\u00eb\u00ec"+
		"\7+\2\2\u00ec\60\3\2\2\2\u00ed\u00ee\7]\2\2\u00ee\62\3\2\2\2\u00ef\u00f0"+
		"\7_\2\2\u00f0\64\3\2\2\2\u00f1\u00f2\7}\2\2\u00f2\66\3\2\2\2\u00f3\u00f4"+
		"\7\177\2\2\u00f48\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6:\3\2\2\2\u00f7\u00f8"+
		"\7>\2\2\u00f8\u00f9\7?\2\2\u00f9<\3\2\2\2\u00fa\u00fb\7@\2\2\u00fb>\3"+
		"\2\2\2\u00fc\u00fd\7@\2\2\u00fd\u00fe\7?\2\2\u00fe@\3\2\2\2\u00ff\u0100"+
		"\7>\2\2\u0100\u0101\7>\2\2\u0101B\3\2\2\2\u0102\u0103\7@\2\2\u0103\u0104"+
		"\7@\2\2\u0104D\3\2\2\2\u0105\u0106\7-\2\2\u0106F\3\2\2\2\u0107\u0108\7"+
		"-\2\2\u0108\u0109\7-\2\2\u0109H\3\2\2\2\u010a\u010b\7/\2\2\u010bJ\3\2"+
		"\2\2\u010c\u010d\7/\2\2\u010d\u010e\7/\2\2\u010eL\3\2\2\2\u010f\u0110"+
		"\7,\2\2\u0110N\3\2\2\2\u0111\u0112\7\61\2\2\u0112P\3\2\2\2\u0113\u0114"+
		"\7\'\2\2\u0114R\3\2\2\2\u0115\u0116\7(\2\2\u0116T\3\2\2\2\u0117\u0118"+
		"\7~\2\2\u0118V\3\2\2\2\u0119\u011a\7(\2\2\u011a\u011b\7(\2\2\u011bX\3"+
		"\2\2\2\u011c\u011d\7~\2\2\u011d\u011e\7~\2\2\u011eZ\3\2\2\2\u011f\u0120"+
		"\7`\2\2\u0120\\\3\2\2\2\u0121\u0122\7#\2\2\u0122^\3\2\2\2\u0123\u0124"+
		"\7\u0080\2\2\u0124`\3\2\2\2\u0125\u0126\7A\2\2\u0126b\3\2\2\2\u0127\u0128"+
		"\7<\2\2\u0128d\3\2\2\2\u0129\u012a\7=\2\2\u012af\3\2\2\2\u012b\u012c\7"+
		".\2\2\u012ch\3\2\2\2\u012d\u012e\7?\2\2\u012ej\3\2\2\2\u012f\u0130\7?"+
		"\2\2\u0130\u0131\7?\2\2\u0131l\3\2\2\2\u0132\u0133\7#\2\2\u0133\u0134"+
		"\7?\2\2\u0134n\3\2\2\2\u0135\u0136\7^\2\2\u0136\u0137\7^\2\2\u0137p\3"+
		"\2\2\2\u0138\u0139\7^\2\2\u0139r\3\2\2\2\u013a\u013e\t\2\2\2\u013b\u013d"+
		"\t\3\2\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013ft\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0145\t\4\2\2"+
		"\u0142\u0144\t\5\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143"+
		"\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u014a\3\2\2\2\u0147\u0145\3\2\2\2\u0148"+
		"\u014a\7\62\2\2\u0149\u0141\3\2\2\2\u0149\u0148\3\2\2\2\u014av\3\2\2\2"+
		"\u014b\u0151\7$\2\2\u014c\u0150\n\6\2\2\u014d\u014e\7^\2\2\u014e\u0150"+
		"\t\7\2\2\u014f\u014c\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0153\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2"+
		"\2\2\u0154\u0155\7$\2\2\u0155x\3\2\2\2\u0156\u0158\t\b\2\2\u0157\u0156"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\b=\2\2\u015cz\3\2\2\2\u015d\u015f\7\17\2\2"+
		"\u015e\u0160\7\f\2\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0163"+
		"\3\2\2\2\u0161\u0163\7\f\2\2\u0162\u015d\3\2\2\2\u0162\u0161\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0165\b>\2\2\u0165|\3\2\2\2\u0166\u0167\7\61\2\2"+
		"\u0167\u0168\7,\2\2\u0168\u016c\3\2\2\2\u0169\u016b\13\2\2\2\u016a\u0169"+
		"\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7,\2\2\u0170\u0171\7\61"+
		"\2\2\u0171\u0172\3\2\2\2\u0172\u0173\b?\2\2\u0173~\3\2\2\2\u0174\u0175"+
		"\7\61\2\2\u0175\u0176\7\61\2\2\u0176\u017a\3\2\2\2\u0177\u0179\n\t\2\2"+
		"\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\b@\2\2\u017e"+
		"\u0080\3\2\2\2\r\2\u013e\u0145\u0149\u014f\u0151\u0159\u015f\u0162\u016c"+
		"\u017a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}