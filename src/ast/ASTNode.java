package ast;
import util.Scope;
import util.position;

abstract public class ASTNode {
    public position pos;
    public Scope scope;
    public ASTNode(position pos){
        this.pos=pos;
    }
    abstract public void accept(ASTVisitor visitor);
}
