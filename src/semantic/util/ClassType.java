package semantic.util;

import semantic.error.semanticError;

public class ClassType implements Type{
    String identifier;

    public ClassType(String identifier){
        this.identifier=identifier;
    }
    @Override
    public String getType(){
        return identifier;
    }

    @Override
    public int getDim(){
        return 0;
    }

    @Override
    public void check(Type t,position pos){
        if (t.getType().equals(identifier)||t.getType().equals("null")) return;
        throw new semanticError("classType check semantic.util.error",pos);
    }

    @Override
    public void checkEqual(Type t,position pos){
        if (t.getType().equals(identifier)||t.getType().equals("null")) return;
        throw new semanticError("classType check semantic.util.error",pos);
    }
}
