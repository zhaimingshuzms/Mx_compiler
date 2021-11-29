package semantic.ast;


import semantic.util.position;
import semantic.util.Symbol;

public class identifierPrimaryNode extends primaryExprNode{
    public String identifier;
    public Symbol symbol;

    public identifierPrimaryNode(String identifier, position pos){
        super(pos);
        this.identifier=identifier;
        symbol=null;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
