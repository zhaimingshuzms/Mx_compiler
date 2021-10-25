package ast;

import util.position;

public class varTypeNode extends ASTNode{
    public String type;
    public int dim;
    public varTypeNode(String type, position pos){
        super(pos);
        this.type=type;
        dim=0;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
