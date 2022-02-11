package IR.operand;

import IR.IRTypes.intType;

public class intConstant extends IRConstant{
    public int value;

    public intConstant(int val,int width){
        value=val;
        type=new intType(width);
    }

    public intConstant(int val){
        this(val,32);
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }

    @Override
    public IROperand copy(String arg){
        return new intConstant(value,((intType)type).size);
    }

    @Override
    public boolean sameConstant(IRConstant rhs){
        return rhs instanceof intConstant &&((intConstant)rhs).value==value;
    }
}
