package ast;

import util.position;

public class literalPrimaryNode extends primaryExprNode{
    public literalPrimaryNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
