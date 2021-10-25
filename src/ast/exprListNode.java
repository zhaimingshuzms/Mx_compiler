package ast;

import util.position;

import java.util.ArrayList;

public class exprListNode extends ASTNode{
    public ArrayList<ExprNode> exprList;

    public exprListNode(position pos){
        super(pos);
        exprList=new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
