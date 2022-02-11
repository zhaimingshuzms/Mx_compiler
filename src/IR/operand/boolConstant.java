package IR.operand;

import IR.IRTypes.boolType;

public class boolConstant extends IRConstant{
    public boolean value;
    public boolConstant(boolean val){
        type = new boolType();
        value = val;
    }
    @Override
    public String toString(){
        return value?"true":"false";
    }

    @Override
    public IROperand copy(String arg){
        return new boolConstant(value);
    }

    @Override
    public boolean sameConstant(IRConstant rhs){
        return rhs instanceof boolConstant&&((boolConstant)rhs).value==value;
    }
}
