package util;

import error.semanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalScope implements Scope{
    public Scope parent;
    public HashMap<String,VarSymbol> varMap;
    public HashMap<String,FuncSymbol> funcMap;
    public List<VarSymbol> parameterList;
    public LocalScope(Scope s){
        varMap=new HashMap<>();
        funcMap=new HashMap<>();
        parameterList=new ArrayList<>();
        parent=s;
    }
    @Override
    public Scope Parent(){
        return parent;
    }

    void check(String s,position pos){
        Scope globalScope=parent;
        while (globalScope instanceof LocalScope){
            globalScope=globalScope.Parent();
        }
        if (varMap.containsKey(s)||funcMap.containsKey(s)||((GlobalScope)globalScope).classMap.containsKey(s)){
            throw new semanticError("local scope check error",pos);
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
        throw new semanticError("define class in local scope",pos);
    }

    public void registerPara(VarSymbol v,position pos){
        registerVar(v,pos);
        parameterList.add(v);
    }
    @Override
    public VarSymbol findVarSymbol(String s,position pos,boolean lookUpon){
        if (varMap.containsKey(s)) return varMap.get(s);
        if (lookUpon) return parent.findVarSymbol(s,pos,lookUpon);
        throw new semanticError("can't find VarSymbol",pos);
    }

    @Override
    public FuncSymbol findFuncSymbol(String s,position pos,boolean lookUpon){
        if (funcMap.containsKey(s)) return funcMap.get(s);
        if (lookUpon) return parent.findFuncSymbol(s,pos,lookUpon);
        throw new semanticError("can't find FuncSymbol",pos);
    }

    @Override
    public ClassSymbol findClassSymbol(String s,position pos){
        return parent.findClassSymbol(s,pos);
    }

    @Override
    public Symbol findSymbol(String s,position pos){
        Symbol tmp=varMap.get(s);
        if (tmp==null){
            tmp=funcMap.get(s);
            if (tmp==null) return parent.findSymbol(s,pos);
        }
        return tmp;
    }
}
