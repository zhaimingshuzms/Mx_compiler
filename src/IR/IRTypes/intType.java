package IR.IRTypes;

public class intType extends IRType{
    public int size;

    public intType(int size){
        this.size=size;
    }
    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        return "i"+size;
    }
}
