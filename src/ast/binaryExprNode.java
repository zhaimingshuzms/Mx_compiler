package ast;

import util.Type;
import util.position;

public class binaryExprNode extends ExprNode{
    public ExprNode lhs,rhs;
    public enum binaryOpType{
        add,sub,mul,div,mod,shl,shr,less,lessequal,greater,greaterequal,
        equal,notequal,ariAnd,ariOr,ariXor,logicAnd,logicOr
    }
    public binaryOpType opCode;

    public binaryExprNode(ExprNode lhs,ExprNode rhs,binaryOpType opCode,position pos){
        super(pos);
        this.lhs=lhs;
        this.rhs=rhs;
        this.opCode=opCode;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
