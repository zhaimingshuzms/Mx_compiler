package IR.components;

public class brOpe extends LLVMoperation{
    public block cond,ifTrue,ifFalse;
    public block dest;
    public brOpe(block cond,block ifTrue,block ifFalse){
        this.cond=cond;
        this.ifTrue=ifTrue;
        this.ifFalse=ifFalse;
    }
    public brOpe(block dest){
        this.dest=dest;
    }

    @Override
    public String toString(){
        if (dest==null){
            return "br "+dest.toString();
        }
        return "br i1 "+cond.toString()+", label "+ifTrue.toString()+", label "+ifFalse.toString();
    }
}
