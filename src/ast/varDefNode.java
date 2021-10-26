package ast;

import util.position;

public class varDefNode extends StmtNode{
    public varTypeNode type;
    public String identifier;
    public ExprNode expression;

    public varDefNode(String identifier, ExprNode expression,position pos){
        super(pos);
        this.type=null;
        this.identifier=identifier;
        this.expression=expression;
    }
    @Override
    public void accept(ASTVisitor visitor){
        vistor.visit(this);
    }
}
