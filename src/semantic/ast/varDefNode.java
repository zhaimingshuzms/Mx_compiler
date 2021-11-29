package semantic.ast;

import semantic.util.Symbol;
import semantic.util.position;

public class varDefNode extends ASTNode{
    public varTypeNode type;
    public String identifier;
    public ExprNode expression;
    public Symbol symbol;

    public varDefNode(varTypeNode type,String identifier, ExprNode expression,position pos){
        super(pos);
        this.type=type;
        this.identifier=identifier;
        this.expression=expression;
    }
    public varDefNode(varTypeNode type,String identifier,position pos){
        super(pos);
        this.type=type;
        this.identifier=identifier;
        this.expression=null;
    }
    public varDefNode(String identifier, ExprNode expression,position pos){
        super(pos);
        this.type=null;
        this.identifier=identifier;
        this.expression=expression;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
