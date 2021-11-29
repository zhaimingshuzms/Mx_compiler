package semantic.ast;

import semantic.util.position;

public class prefixExprNode extends ExprNode{
    public enum prefixOpType{
        SelfPlus,SelfMinus,Plus,Minus,Not,Tilde
    }
    public prefixOpType op;
    public ExprNode expr;
    public prefixExprNode(prefixOpType op, ExprNode expr, position pos){
        super(pos);
        this.op=op;
        this.expr=expr;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
