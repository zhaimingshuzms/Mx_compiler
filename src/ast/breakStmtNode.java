package ast;

import util.position;

public class breakStmtNode extends StmtNode{
    public StmtNode loopNode;
    public breakStmtNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
