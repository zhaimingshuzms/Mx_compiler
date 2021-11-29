package semantic.ast;

import semantic.util.position;

import java.util.ArrayList;

public class RootNode extends ASTNode{
    public ArrayList<ASTNode> strDefs=new ArrayList<>();

    public RootNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
