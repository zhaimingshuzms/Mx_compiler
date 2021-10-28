package ast;

import util.position;
public class nullLiteralNode extends literalPrimaryNode{
    public nullLiteralNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}

