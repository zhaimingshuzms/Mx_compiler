package IR.components;

import IR.IRTypes.IRType;
import IR.IRTypes.voidType;

public class retOpe extends LLVMoperation{
    public IRValue value;

    public retOpe(IRValue value){
        this.value=value;
    }
    @Override
    public String toString(){
        if (value.type instanceof voidType)
            return "ret void";
        return "ret "+value.type.toString()+value.ent.toString();
    }
}
