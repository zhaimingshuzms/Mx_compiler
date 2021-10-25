package ast;

import util.position;

public class ifStmtNode extends StmtNode{
    ExprNode condition;
    StmtNode thenStmt,elseStmt;

    public ifStmtNode(ExprNode condition,StmtNode thenStmt,StmtNode elseStmt,position pos){
        super(pos);
        this.condition=condition;
        this.thenStmt=thenStmt;
        this.elseStmt==elseStmt;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
