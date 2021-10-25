package ast;

import util.position;

public class returnTypeNode extends ASTNode{
    public varTypeNode type;
    public returnTypeNode(position pos){
        super(pos);
        type=null;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
