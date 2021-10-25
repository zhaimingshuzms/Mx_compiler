package ast;

import util.position;

public class primaryExprNode extends ExprNode{
    public primaryExprNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
