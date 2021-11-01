package ast;
import MIR.entity;
import util.Type;
import util.position;

abstract public class ExprNode extends ASTNode{
    public enum ExprType{
        LVALUE,RVALUE,CLASS,FUNCTION
    }
    public ExprType exprType;
    public Type type;
    public entity val;

    public ExprNode(position pos){
        super(pos);
    }

    public boolean isAssignable(){
        return false;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
