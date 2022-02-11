package IR.components;

public class Register extends entity{
    public String name;
    public int index=0;

    public Register(){
        super();
    }
    public Register(String name,int index){
        super();
        this.name=name;
        this.index=index;
    }

    public Register(String name){
        super();
        this.name=name;
    }

    public String toString(){
        if (index>0)
            return '#'+index+name;
        return '#'+name;
    }
}
