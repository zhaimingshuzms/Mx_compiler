package semantic.util;

public class VarSymbol extends Symbol{
    public boolean member=false;
    public VarSymbol(position pos, String identifier, Type type, Scope currentScope){
        super(pos,identifier,type,currentScope);
    }
}
