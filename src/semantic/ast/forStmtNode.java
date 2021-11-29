package semantic.ast;

import semantic.util.position;

public class forStmtNode extends StmtNode{
    public ExprNode prework,condition,loopwork;
    public varDefListNode varDef;
    public suiteStmtNode loopsuite;
    public forStmtNode(ExprNode prework,ExprNode condition,ExprNode loopwork,suiteStmtNode loopsuite,position pos){
        super(pos);
        this.prework=prework;
        this.varDef=null;
        this.condition=condition;
        this.loopwork=loopwork;
        this.loopsuite=loopsuite;
    }
    public forStmtNode(varDefListNode varDef,ExprNode condition,ExprNode loopwork,suiteStmtNode loopsuite,position pos){
        super(pos);
        this.prework=null;
        this.varDef=varDef;
        this.condition=condition;
        this.loopwork=loopwork;
        this.loopsuite=loopsuite;
    }
    public forStmtNode(ExprNode condition,ExprNode loopwork,suiteStmtNode loopsuite,position pos){
        super(pos);
        this.prework=null;
        this.varDef=null;
        this.condition=condition;
        this.loopwork=loopwork;
        this.loopsuite=loopsuite;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
