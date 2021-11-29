package semantic.error;
import semantic.util.position;
public class semanticError extends error{
    public semanticError(String msg,position pos){
        super("Semantic Error: "+msg,pos);
    }
}
