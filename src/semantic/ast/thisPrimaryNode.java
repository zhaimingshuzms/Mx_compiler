package semantic.ast;

import semantic.util.position;
import semantic.util.Symbol;

public class thisPrimaryNode extends primaryExprNode{
    public Symbol symbol;
    public thisPrimaryNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
