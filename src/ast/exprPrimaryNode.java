package ast;

import util.position;

public class exprPrimaryNode extends primaryExprNode{
    public ExprNode expression;

    public exprPrimaryNode(ExprNode expression, position pos){
        super(pos);
        this.expression=expression;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
