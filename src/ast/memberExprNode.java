package ast;

import util.Symbol;
import util.position;

public class memberExprNode extends ExprNode{
    public String identifier;
    public ExprNode expression;
    public Symbol symbol;
    public memberExprNode(ExprNode expression, String identifier,position pos){
        super(pos);
        this.expression=expression;
        this.identifier=identifier;
        this.symbol=null;
    }

    @Override
    public void accept(ASTVistor visitor){
        visitor.visit(this);
    }
}
