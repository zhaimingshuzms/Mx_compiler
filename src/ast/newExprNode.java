package ast;

import util.position;

public class newExprNode extends ExprNode{
    public scaledTypeNode type;
    public newExprNode(scaledTypeNode type,position pos){
        super(pos);
        this.type=type;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
