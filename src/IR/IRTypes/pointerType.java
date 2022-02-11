package IR.IRTypes;

public class pointerType extends IRType{
    public IRType baseType;
    private int dim;
    
    public pointerType(IRType base) {
        assert base != null;
        if (base instanceof pointerType) {
            baseType = ((pointerType)base).baseType;
            dim = ((pointerType)base).dim + 1;
        }
        else {
            baseType = base;
            dim = 1;
        }
    }

    public pointerType(IRType base , int dim) {
        assert !(base instanceof pointerType);
        baseType = base;
        this.dim = dim;
    }

    public IRType subType() {
        return dim == 1 ? baseType : new pointerType(baseType , dim - 1);
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public String toString(){
        return baseType + "*".repeat(dim);
    }

    @Override
    public IROperand defaultValue() {
        return new nullptrConstant(new pointerType(baseType));
    }

    @Override
    public boolean matches(IRType rhs) {
        return rhs instanceof pointerType && baseType.matches(((pointerType)rhs).baseType);
    }
}
