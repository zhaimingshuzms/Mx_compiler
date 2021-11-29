package semantic.ast;

import semantic.util.position;
public class stringLiteralNode extends literalPrimaryNode{
    public String val;
    public stringLiteralNode(String val,position pos){
        super(pos);
        this.val=val;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
