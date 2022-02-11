package IR.IRTypes;

public class arrayType extends IRType{
    public IRType baseType;
    public int length;

    public arrayType(IRType baseType,int length){
        this.baseType=baseType;
        this.length=length;
    }

    @Override
    public int size(){
        return baseType.size()*length;
    }

    @Override
    public String toString(){
        return "["+length+" x "+baseType.toString()+"]";
    }

    @Override
    public IROperand defaultValue(){
        
    }
}
