package semantic.ast;

import semantic.util.FuncSymbol;
import semantic.util.position;

public class funcExprNode extends ExprNode{
    public ExprNode expression;
    public exprListNode parameterList;
    public FuncSymbol symbol;
    public funcExprNode(ExprNode expression, exprListNode parameterList, position pos){
        super(pos);
        this.expression=expression;
        this.parameterList=parameterList;
        this.pos=pos;
        this.symbol=null;
    }

    public funcExprNode(ExprNode expression,position pos){
        super(pos);
        this.expression=expression;
        this.parameterList=new exprListNode(pos);
        this.pos=pos;
        this.symbol=null;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
