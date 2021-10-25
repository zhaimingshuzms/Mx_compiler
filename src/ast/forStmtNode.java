package ast;

import util.position;

public class forStmtNode extends StmtNode{
    public ExprNode prework,condition,loopwork;
    public varDefNode varDef;
    public suiteNode loopsuite;
    public forStmtNode(ExprNode prework,ExprNode condition,ExprNode loopwork,suiteNode loopsuite,position pos){
        super(pos);
        this.prework=prework;
        this.varDef=null;
        this.condition=condition;
        this.loopwork=loopwork;
        this.loopsuite=loopsuite;
    }
    public forStmtNode(varDefNode varDef,ExprNode condition,ExprNode loopwork,suiteNode loopsuite,position pos){
        super(pos);
        this.prework=null;
        this.varDef=varDef;
        this.condition=condition;
        this.loopwork=loopwork;
        this.loopsuite=loopsuite;
    }
    public forStmtNode(ExprNode condition,ExprNode loopwork,suiteNode loopsuite,position pos){
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
