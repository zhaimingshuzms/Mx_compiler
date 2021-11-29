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
}
