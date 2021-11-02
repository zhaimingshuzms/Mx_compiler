package util;

import error.semanticError;

public class ClassType implements Type{
    @Override
    public String getType(){
        return "class";
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals("class")) return;
        throw new semanticError("classType check error",pos);
    }
}
