package util;

import error.semanticError;

public class IntType implements Type{
    @Override
    public String getType(){
        return "int";
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals("int")) return;
        throw new semanticError("intType check error",pos);
    }
}
