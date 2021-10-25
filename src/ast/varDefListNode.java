package ast;

import util.position;

import java.util.ArrayList;

public class varDefListNode extends ASTNode{
    public ArrayList<varDefNode> varList;
    public varDefListNode(position pos){
        super(pos);
        varList=new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
