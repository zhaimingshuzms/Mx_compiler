package ast;

import util.ClassSymbol;
import util.position;
import java.util.ArrayList;

public class classDefNode extends ASTNode{
    public ArrayList<varDefNode> varDefs=new ArrayList<>();
    public ArrayList<funcDefNode> funcDefs=new ArrayList<>();
    public String name;
    public ClassSymbol symbol;

    public classDefNode(position pos,String name) {
        super(pos);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
