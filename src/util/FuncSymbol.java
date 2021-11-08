package util;

import ast.ASTNode;

public class FuncSymbol extends Symbol{
    public boolean member=false;
    public FuncSymbol(position pos, String identifier, Type type, ASTNode definition){
        super(pos,identifier,type,definition);
    }

    public FuncSymbol(position pos, String identifier, Type type, Scope scope){
        super(pos,identifier,type,scope);
    }
}
