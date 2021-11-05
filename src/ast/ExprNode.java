package ast;
import MIR.entity;
import error.semanticError;
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
    public void assertValue(){
        if (exprType!=ExprType.LVALUE&&exprType!=ExprType.RVALUE){
            throw new semanticError("expression is not a value",pos);
        }
    }
}
