package IR.IRTypes;

public class boolType extends IRType{

    @Override
    public int size(){
        return 1;
    }

    @Override
    public String toString(){
        return "i1";
    }

    @Override
    public IROperand defaultValue() {
        return new boolConstant(false);
    }

    @Override
    public boolean matches(IRType rhs) {
        return rhs instanceof boolType;
    }
}
