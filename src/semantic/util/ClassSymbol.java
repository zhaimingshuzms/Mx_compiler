package semantic.util;

import semantic.ast.ASTNode;

public class ClassSymbol extends Symbol{
    public FuncSymbol constructer;
    public ClassSymbol(position pos, String identifier, Type type, ASTNode definition){
        super(pos,identifier,type,definition);
    }
    public ClassSymbol(position pos, String identifier, Type type, Scope scope){
        super(pos,identifier,type,scope);
    }
}
