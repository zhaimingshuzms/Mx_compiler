package util;

import error.semanticError;

public class nullType implements Type{
    @Override
    public String getType(){
        return "null";
    }
    @Override
    public int getDim(){
        return 0;
    }
    @Override
    public void check(Type t,position pos){
        if (!t.getType().equals("null")) throw new semanticError("nullType check error",pos);
    }
}
