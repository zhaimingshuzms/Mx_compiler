package IR.operand;

import IR.IRTypes.pointerType;

public class nullptrConstant extends IRConstant{
    public nullptrConstant(pointerType type){
        this.type=type;
    }

    @Override
    public String toString(){
        return "null";
    }

    @Override
    public IROperand copy(String arg){
        return new nullptrConstant((pointerType)type);
    }

    @Override
    public boolean sameConstant(IRConstant rhs){
        return rhs instanceof nullptrConstant;
    }
}
