package semantic.ast;

import semantic.util.position;

import java.util.ArrayList;

public class suiteStmtNode extends StmtNode{
    public ArrayList<StmtNode> innerStmt;
    public suiteStmtNode(position pos){
        super(pos);
        this.innerStmt=new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
