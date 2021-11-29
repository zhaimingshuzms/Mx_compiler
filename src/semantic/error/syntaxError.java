package semantic.error;
import semantic.util.position;

public class syntaxError extends error{
    public syntaxError(String msg, position pos){
        super("Syntax Error: "+msg,pos);
    }
}
