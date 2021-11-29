package IR.IRTypes;

public class voidType extends IRType {
    @Override
    public int size(){
        return 0;
    }

    @Override
    public String toString(){
        return "void";
    }
}