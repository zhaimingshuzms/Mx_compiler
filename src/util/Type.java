package util;


public interface Type {
    String getType();
    int getDim();
    void check(Type t,position pos);
}
