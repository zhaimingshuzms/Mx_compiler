package IR.components;

import semantic.ast.binaryExprNode;

public class binary extends LLVMoperation{
    public Register lhs;
    public entity op1,op2;
    public binaryExprNode.binaryOpType op;
    public binary(Register lhs,entity op1,entity op2,binaryExprNode.binaryOpType op){
        this.lhs=lhs;
        this.op1=op1;
        this.op2=op2;
        this.op=op;
    }
    @Override
    public String toString(){
        //分类讨论各种
    }
}
