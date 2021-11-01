package util;

import ast.ASTNode;

public class VarSymbol extends Symbol{
    public boolean member=false;
    public VarSymbol(position pos, String identifier, Type type, ASTNode definition){
        super(pos,identifier,type,definition);
    }
}
