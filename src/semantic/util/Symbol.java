package semantic.util;

import semantic.ast.ASTNode;

public class Symbol {
    public String identifier;
    public Type type;
    public Scope scope;
    public ASTNode definition;
    public position pos;
    public Symbol(position pos,String identifier,Type type,ASTNode definition){
        this.pos=pos;
        this.identifier=identifier;
        this.type=type;
        this.definition=definition;
        this.scope=null;
    }

    public Symbol(position pos,String identifier,Type type,Scope scope){
        this.pos=pos;
        this.identifier=identifier;
        this.type=type;
        this.definition=null;
        this.scope=scope;
    }
}
