package semantic.ast;
import semantic.util.Scope;
import semantic.util.position;

abstract public class ASTNode implements Comparable<ASTNode>{
    public position pos;
    public Scope scope;
    public ASTNode(position pos){
        this.pos=pos;
    }
    abstract public void accept(ASTVisitor visitor);

    @Override
    public int compareTo(ASTNode y){
        return pos.compareTo(y.pos);
    }
}
