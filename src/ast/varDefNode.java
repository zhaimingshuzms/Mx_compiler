package ast;

import util.position;

public class varDefNode extends StmtNode{
    public varTypeNode type;
    public String identifier;
    public ExprNode expression;

    public varDefNode(varTypeNode type, String identifier, position pos){
        super(pos);
        this.type=type;
        this.identifier=identifier;
    }
    @Override
    public void accept(ASTVisitor visitor){
        vistor.visit(this);
    }
}
