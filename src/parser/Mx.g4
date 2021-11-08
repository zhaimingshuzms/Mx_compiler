grammar Mx;

program : (varDef | functionDef | classDef)*;

functionDef : returnType Identifier '(' functionParameterDef ')' suite;

functionParameterDef : (varType Identifier (',' varType Identifier)* )?;

parameterList : expression(',' expression)*;

suite : '{' statement * '}';

statement
    : suite                                                                                #block
    | varDef                                                                               #varDefStmt
    | If '(' expression ')' trueStmt=statement
        (Else falseStmt=statement)?                                                        #ifStmt
    | For '(' ((prework=expression ';')| (prevar=varDef)| ';') (condition=expression)? ';' (loopexpression=expression)? ')' statement     #forStmt
    | Continue ';'                                                                         #continueStmt
    | Break ';'                                                                            #breakStmt
    | Return expression? ';'                                                               #returnStmt
    | While expression ? statement                                                         #whileStmt
    | expression ';'                                                                       #expressionStmt
    ;

varDef : varType varDeclaration (',' varDeclaration)* ';';

varDeclaration : Identifier ('=' expression)?;

classDef
    : Class Identifier '{' (classMemberDef | classFunctionDef) * '}' ';';

classMemberDef : varDef;

classFunctionDef : functionDef
                 | classConstructFuncDef
                 ;

classConstructFuncDef : Identifier '(' functionParameterDef ')' suite;

expression
    : primary                                                                              #atomExpr
    | New scaledType                                                                       #newExpr
    | expression '[' expression ']'                                                        #subarrayExpr
    | expression '(' parameterList? ')'                                                    #funcExpr
    | expression op=('++'|'--')                                                            #suffixExpr
    | expression '.' Identifier                                                            #memberExpr
    | expression op=('+'|'-') expression                                                   #binaryExpr
    | expression op=('*'|'/'|'%') expression                                               #binaryExpr
    | expression op=('<<'|'>>') expression                                                 #binaryExpr
    | expression op=('<'|'<='|'>'|'>=') expression                                         #binaryExpr
    | expression op=('=='|'!=') expression                                                 #binaryExpr
    | expression op=('&'|'^'|'|') expression                                               #binaryExpr
    | expression op='&&' expression                                                        #binaryExpr
    | expression op='||' expression                                                        #binaryExpr
    | <assoc=right> op=('++'|'--') expression                                              #prefixExpr
    | <assoc=right> op=('+'|'-') expression                                                #prefixExpr
    | <assoc=right> op=('!'|'~') expression                                                #prefixExpr
    | <assoc=right> expression '=' expression                                              #assignExpr
    | lamdaexpression                                                                      #lambdaExpr
    ;

lamdaexpression :'[&]' ('(' functionParameterDef ')')? '->' suite;

returnType : Void | varType;
varType : builtinType | Identifier | varType ('[' ']')+;
scaledType
    : (builtinType | Identifier) ('[' expression ']')+('[' ']')*                                        #arrayType
    | (builtinType | Identifier)                                                                        #basicType
    ;
builtinType : Int | Bool | String;

primary
    : '(' expression ')'
    | This
    | literal
    | Identifier
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
Null : 'null';
While : 'while';

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