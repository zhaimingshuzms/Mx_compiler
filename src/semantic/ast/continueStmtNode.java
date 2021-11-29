package semantic.ast;

import semantic.util.position;

public class continueStmtNode extends StmtNode{
    public StmtNode loopNode;
    public continueStmtNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
