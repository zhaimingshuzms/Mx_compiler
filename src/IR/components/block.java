package IR.components;

import java.util.ArrayList;

public class block {
    public String LabelName;
    public ArrayList<LLVMoperation> list;
    public void add(LLVMoperation e){
        list.add(e);
    }

    public String toString(){
        String ret=LabelName+":";
        for (var i :list){
            ret=ret+"\n"+i.toString();
        }
        return ret;
    }
}
