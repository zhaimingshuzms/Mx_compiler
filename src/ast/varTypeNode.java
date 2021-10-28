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
    public varTypeNode(String type, int dim,position pos){
        super(pos);
        this.type=type;
        this.dim=dim;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
