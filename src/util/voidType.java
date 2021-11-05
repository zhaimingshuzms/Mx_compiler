package util;

import error.semanticError;

public class voidType implements Type{
    @Override
    public String getType(){
        return "void";
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals("void")) return;
        throw new semanticError("voidType check error",pos);
    }

    @Override
    public void checkEqual(Type t,position pos){
        if (t.getType().equals("void")) return;
        throw new semanticError("voidType check error",pos);
    }
}
