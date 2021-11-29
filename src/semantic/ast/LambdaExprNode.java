package semantic.ast;

import semantic.util.Symbol;
import semantic.util.position;

import java.util.ArrayList;

public class LambdaExprNode extends ExprNode{
    public ArrayList<varDefNode> parameterList;
    public suiteStmtNode suite;
    public Symbol symbol;

    public LambdaExprNode(ArrayList<varDefNode> parameterList,suiteStmtNode suite, position pos){
        super(pos);
        this.parameterList=parameterList;
        this.suite=suite;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
