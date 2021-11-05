package util;

import error.semanticError;

public class ArrayType implements Type{
    public Type elementType;
    public int dim;

    public ArrayType(Type elementType,int dim){
        this.elementType=elementType;
        this.dim=dim;
    }
    public ArrayType(Type elementType){
        this.elementType=elementType;
    }

    @Override
    public String getType(){
        return elementType.getType()+'['+dim+']';
    }

    @Override
    public int getDim(){
        return dim;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals(getType())) return;
        throw new semanticError("arrayType check error",pos);
    }

    @Override
    public void checkEqual(Type t,position pos){
        if (t.getType().equals(getType())||t.getType().equals("null")) return;
        throw new semanticError("arrayType check error",pos);
    }
}
