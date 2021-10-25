package ast;
import MIR.entity;
import util.Type;
import util.position;

abstract public class ExprNode extends ASTNode{
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
