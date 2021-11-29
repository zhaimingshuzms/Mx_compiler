package semantic.ast;

import semantic.util.position;

public class varDefStmt extends StmtNode{
    public varDefListNode varDefList;

    public varDefStmt(varDefListNode varDefList, position pos){
        super(pos);
        this.varDefList=varDefList;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
