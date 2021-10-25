package ast;

import util.Symbol;
import util.position;

import java.util.ArrayList;

public class funcExprNode extends ExprNode{
    public ExprNode expression;
    public ArrayList<ExprNode> parameterlist;
    public Symbol symbol;
    public funcExprNode(ExprNode expression, ArrayList<ExprNode> parameterlist, position pos){
        super(pos);
        this.expression=expression;
        this.parameterlist=parameterlist;
        this.pos=pos;
        this.symbol=null;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
