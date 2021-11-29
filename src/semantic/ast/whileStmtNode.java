package semantic.ast;

import semantic.util.position;

public class whileStmtNode extends StmtNode{
    public ExprNode condition;
    public suiteStmtNode loopbody;

    public whileStmtNode(ExprNode condition, suiteStmtNode loopbody, position pos){
        super(pos);
        this.condition=condition;
        this.loopbody=loopbody;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
