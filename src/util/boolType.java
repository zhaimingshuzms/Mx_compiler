package util;

import error.semanticError;

public class boolType implements Type{
    @Override
    public String getType(){
        return "bool";
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals(getType())) return;
        throw new semanticError("bool check error",pos);
    }

    @Override
    public void checkEqual(Type t,position pos){
        if (t.getType().equals(getType())) return;
        throw new semanticError("bool check error",pos);
    }
}
