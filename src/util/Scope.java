package util;
public interface Scope {
    Scope Parent();
    void registerVar(VarSymbol v,position pos);
    void registerFunc(FuncSymbol f,position pos);
    void registerClass(ClassSymbol c,position pos);
    VarSymbol findVarSymbol(String s,position pos,boolean lookupon);
    FuncSymbol findFuncSymbol(String s,position pos,boolean lookupon);
    ClassSymbol findClassSymbol(String s,position pos);
}