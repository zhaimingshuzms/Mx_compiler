package IR.operand;

import IR.IRTypes.IRType;

public abstract class IROperand {
    public IRType type;
    
    public abstract IROperand copy(String arg);
    public abstract String toString();
}
