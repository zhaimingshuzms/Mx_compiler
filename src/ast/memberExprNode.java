package ast;

import util.Symbol;
import util.position;

public class memberExprNode extends ExprNode{
    public String identifier;
    public ExprNode expression;
    public Symbol symbol;
    public memberExprNode(String identifier, ExprNode expression, position pos){
        super(pos);
        this.identifier=identifier;
        this.expression=expression;
        this.symbol=null;
    }

    @Override
    public void accept(ASTVistor visitor){
        visitor.visit(this);
    }
}
