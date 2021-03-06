package semantic.util;

import semantic.error.semanticError;

public class StringType implements Type{
    @Override
    public String getType(){
        return "string";
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals("string")) return;
        throw new semanticError("stringType check semantic.util.error",pos);
    }

    @Override
    public void checkEqual(Type t,position pos){
        if (t.getType().equals("string")) return;
        throw new semanticError("stringType check semantic.util.error",pos);
    }
}
