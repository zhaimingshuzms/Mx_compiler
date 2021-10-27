package ast;

import util.position;

public class subarrayExprNode extends ExprNode{
    public ExprNode identifier;
    public ExprNode index;
    public subarrayExprNode(ExprNode identifier, ExprNode index, position pos){
        super(pos);
        this.identifier=identifier;
        this.index=index;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
