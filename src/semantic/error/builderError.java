package semantic.error;
import semantic.util.position;
public class builderError extends error{
    public builderError(String msg,position pos){
        super("Builder Error: "+msg,pos);
    }
}
