package semantic.util;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
public class position implements Comparable<position>{
    private int row,column;

    public position(int row,int col){
        this.row=row;
        this.column=col;
    }
    public position(Token token){
        this.row=token.getLine();
        this.column=token.getCharPositionInLine();
    }

    public position(TerminalNode terminal){
        this(terminal.getSymbol());
    }
    public position(ParserRuleContext ctx){
        this(ctx.getStart());
    }
    public int row(){
        return row;
    }
    public int col(){
        return column;
    }
    public String toString(){
        return row+","+column;
    }

    @Override
    public int compareTo(position y){
        if (row()!=y.row()) return row()-y.row();
        return col()-y.col();
    }
}
