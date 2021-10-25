package ast;

import util.position;
public class nullLiteralNode extends literalPrimaryNode{
    public nullLiteralNode(String val,position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}

