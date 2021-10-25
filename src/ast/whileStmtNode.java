package ast;

import util.position;

public class whileStmtNode extends StmtNode{
    public ExprNode condition;
    public StmtNode loopbody;

    public whileStmtNode(ExprNode condition,StmtNode loopbody,position pos){
        super(pos);
        this.condition=condition;
        this.loopbody=loopbody;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
