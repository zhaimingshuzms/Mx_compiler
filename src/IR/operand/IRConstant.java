package IR.operand;

public abstract class IRConstant extends IROperand{
    public abstract boolean sameConstant(IRConstant rhs);
}
