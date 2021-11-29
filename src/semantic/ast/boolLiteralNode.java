package semantic.ast;

import semantic.util.position;
public class boolLiteralNode extends literalPrimaryNode{
    public boolean val;
    public boolLiteralNode(boolean val,position pos){
        super(pos);
        this.val=val;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}

