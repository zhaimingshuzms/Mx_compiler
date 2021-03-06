package semantic.ast;

import semantic.util.position;

abstract public class literalPrimaryNode extends primaryExprNode{
    public literalPrimaryNode(position pos){
        super(pos);
    }

    @Override
    abstract public void accept(ASTVisitor visitor);
}
