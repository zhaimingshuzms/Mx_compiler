package semantic.ast;

import semantic.util.position;

public class suffixExprNode extends ExprNode{
    public enum suffixOpType{
        SelfPlus,SelfMinus
    };
    public ExprNode expr;
    public suffixOpType op;
    public suffixExprNode(ExprNode expr, suffixOpType op, position pos){
        super(pos);
        this.expr=expr;
        this.op=op;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
