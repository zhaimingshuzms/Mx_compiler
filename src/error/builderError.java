package error;
import util.position;
public class builderError extends error{
    public builderError(String msg,position pos){
        super("Builder Error: "+msg,pos);
    }
}
