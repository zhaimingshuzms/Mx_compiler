package util;

import ast.ASTNode;

public class ClassSymbol extends Symbol{
    public FuncSymbol constructer;
    public ClassSymbol(position pos, String identifier, Type type, ASTNode definition){
        super(pos,identifier,type,definition);
    }
}
