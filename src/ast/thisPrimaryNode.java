package ast;

import util.Symbol;
import util.position;

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
