package util;

import error.semanticError;

import java.util.HashMap;
public class Scope {
    private HashMap<String,Type> members;
    private Scope parentScope;
    public Scope(Scope parentScope){
        members=new HashMap<>();
        this.parentScope=parentScope;
    }

    public Scope parentScope(){
        return parentScope;
    }

    public void defineVariable(String name,Type t,position pos){
        if (members.containsKey(name))
            throw new semanticError("Semantic Error: variable redefine",pos);
        members.put(name,t);
    }

    public boolean containsVariable(String name,boolean loopUpon){
        if (members.containsKey(name)) return true;
        else if (parentScope!=null&&loopUpon)
            return parentScope.containsVariable(name,true);
        return false;
    }

    public Type getType(String name,boolean loopUpon){
        if (members.containsKey(name)) return members.get(name);
        else if (parentScope !=null && loopUpon)
            return parentScope.getType(name,true);
        return null;
    }
}
