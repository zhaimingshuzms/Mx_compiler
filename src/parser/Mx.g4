grammar Mx;

program : (declarationStmt | functionDef | classDef)*;

functionDef : returnType Identifier '(' functionParameterDef ')' suite;

functionParameterDef : (varType Identifier (',' varType Identifier)* )?;

parameterList : expression(',' expression)*;

suite : '{' statement * '}';

statement
    : suite
    | declarationStmt
    | If '(' expression ')' trueStmt=statement
        (Else falseStmt=statement)?
    | For '(' (expression | varDef)? ';' (expression)? ';' (expression)? ')' statement
    | Continue ';'
    | Break ';'
    | Return expression? ';'
    | expression?';'
    ;

declarationStmt
    : varDef ';'
    | classDef ';'
    ;


varDef : varType varDeclaration (',' varDeclaration)*;

varDeclaration : Identifier ('=' expression)?;

classDef
    : Class Identifier '{' (classMemberDef | classFunctionDef) * '}';

classMemberDef : varDef ';';

classFunctionDef : functionDef
                 | classConstructFuncDef
                 ;

classConstructFuncDef : Identifier '(' ')' suite;

expression
    : primary
    | New scaledType
    | expression '[' expression ']'
    | expression '(' parameterList? ')'
    | expression op=('++'|'--')
    | expression '.' Identifier
    | expression op=('+'|'-') expression
    | expression op=('*'|'/'|'%') expression
    | expression op=('<<'|'>>') expression
    | expression op=('<'|'<='|'>'|'>=') expression
    | expression op=('=='|'!=') expression
    | expression op=('&'|'^'|'|') expression
    | expression op='&&' expression
    | expression op='||' expression
    | <assoc=right> op=('++'|'--') expression
    | <assoc=right> op=('+'|'-') expression
    | <assoc=right> op=('!'|'~') expression
    | <assoc=right> expression '=' expression
    | lamdaexpression
    ;

lamdaexpression :'[&]' ('(' functionParameterDef ')')? '->' suite;

returnType : Void | varType;
varType : builtinType | Identifier | varType ('[]')+;
scaledType
    : (builtinType | Identifier)
    | (builtinType | Identifier) ('[' expression ']')+('[]')*
    ;
builtinType : Int | Bool | String;

primary
    : '(' expression ')'
    | Identifier
    | This
    | literal
    ;

literal
    : DecimalInteger
    | StringLiteral
    | Null
    | True
    | False
    ;

Int : 'int';
Bool : 'bool';
String : 'string';
Class : 'class';
Void : 'void';
True : 'true';
False : 'false';
If : 'if';
Else : 'else';
For : 'for';
Return : 'return';
New : 'new';
This : 'this';
Continue : 'continue';
Break : 'break';
Null : 'NULL';

Dot : '.';
LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
SelfPlus : '++';
Minus : '-';
SelfMinus : '--';

Mul : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd :'&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';
Equal : '==';
NotEqual : '!=';

BackSlash : '\\\\';
DbQuotation : '\\';

Identifier
    : [a-zA-Z] [a-zA-Z_0-9]*
    ;

DecimalInteger
    : [1-9] [0-9]*
    | '0'
    ;

StringLiteral : '"' (~["\n\\] | '\\' ["n\\])*? '"';

Whitespace
    : [ \t]+
        ->skip
    ;

Newline
    : ( '\r' '\n'?|'\n')
        ->skip
    ;

BlockComment
    :   '/*' .*? '*/'
        ->skip
    ;

LineComment
    :   '//' ~[\r\n]*
        ->skip
    ;