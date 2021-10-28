package ast;

import util.position;

public class returnTypeNode extends ASTNode{
    public varTypeNode type;
    public returnTypeNode(varTypeNode type,position pos){
        super(pos);
        this.type=type;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
