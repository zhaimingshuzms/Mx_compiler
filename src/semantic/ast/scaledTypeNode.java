package semantic.ast;

import semantic.util.position;

import java.util.ArrayList;

public class scaledTypeNode extends ASTNode{
    public varTypeNode baseType;
    public ArrayList<ExprNode> arraysize;

    public scaledTypeNode(varTypeNode baseType, position pos){
        super(pos);
        this.baseType=baseType;
        arraysize=new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
