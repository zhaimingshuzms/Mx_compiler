package util;

import error.semanticError;

import java.util.HashMap;

public class GlobalScope implements Scope{
    public HashMap<String,VarSymbol> varMap;
    public HashMap<String,FuncSymbol> funcMap;
    public HashMap<String,ClassSymbol> classMap;

    @Override
    public Scope Parent(){
        return null;
    }

    void check(String s,position pos){
        if (varMap.containsKey(s)||funcMap.containsKey(s)||classMap.containsKey(s)){
            throw new semanticError("global scope check error",pos);
        }
    }

    @Override
    public void registerVar(VarSymbol v,position pos){
        check(v.identifier,pos);
        varMap.put(v.identifier,v);
    }

    @Override
    public void registerFunc(FuncSymbol f,position pos){
        check(f.identifier,pos);
        funcMap.put(f.identifier,f);
    }

    @Override
    public void registerClass(ClassSymbol c,position pos){
        if (classMap.containsKey(c.identifier)) throw new semanticError("redefinition of class",pos);
        classMap.put(c.identifier,c);
    }

    @Override
    public VarSymbol findVarSymbol(String s,position pos,boolean lookUpon){
        if (varMap.containsKey(s)) return varMap.get(s);
        throw new semanticError("can't find VarSymbol",pos);
    }

    @Override
    public FuncSymbol findFuncSymbol(String s,position pos,boolean lookUpon){
        if (funcMap.containsKey(s)) return funcMap.get(s);
        throw new semanticError("can't find FuncSymbol",pos);
    }

    @Override
    public ClassSymbol findClassSymbol(String s,position pos){
        if (classMap.containsKey(s)) return findClassSymbol(s,pos);
        throw new semanticError("can't find ClassSymbol",pos);
    }
}
