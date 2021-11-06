package ast;

import util.position;

abstract public class primaryExprNode extends ExprNode{
    public primaryExprNode(position pos){
        super(pos);
    }

    @Override
    abstract public void accept(ASTVisitor visitor);
}
