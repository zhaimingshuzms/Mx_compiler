package util;

import error.semanticError;

public class ClassDefType implements Type{
    @Override
    public String getType(){
        return "classDef";
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        throw new semanticError("classDef check error",pos);
    }

    @Override
    public void checkEqual(Type t,position pos){
        throw new semanticError("classDef check error",pos);
    }
}
