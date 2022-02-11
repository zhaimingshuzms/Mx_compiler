/*
    A good beginning is halfway to success.
*/
package IR.IRTypes;
public abstract class IRType{
    public abstract int size();
    public abstract String toString();
    public abstract IROperand defaultValue();
    public abstract boolean matches(IRType matches);
}