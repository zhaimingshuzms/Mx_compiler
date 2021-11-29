package semantic.ast;

import semantic.util.Symbol;
import semantic.util.position;

public class memberExprNode extends ExprNode{
    public String identifier;
    public ExprNode expression;
    public Symbol symbol;
    public memberExprNode(ExprNode expression, String identifier, position pos){
        super(pos);
        this.expression=expression;
        this.identifier=identifier;
        this.symbol=null;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
