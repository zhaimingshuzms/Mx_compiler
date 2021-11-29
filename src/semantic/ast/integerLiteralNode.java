package semantic.ast;

import semantic.util.position;

public class integerLiteralNode extends literalPrimaryNode{
    public int val;
    public integerLiteralNode(int val,position pos){
        super(pos);
        this.val=val;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
