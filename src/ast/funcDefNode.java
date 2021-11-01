package ast;

import util.FuncSymbol;
import util.position;

import java.util.ArrayList;

public class funcDefNode extends ASTNode{
    public returnTypeNode returnType;
    public String identifier;
    public ArrayList<varDefNode> parameterList;
    public suiteStmtNode suite;
    public boolean isConstructer;
    public boolean returnExistence;
    public FuncSymbol symbol;
    public funcDefNode(returnTypeNode returnType, String identifier, ArrayList<varDefNode> parameterList, suiteStmtNode suite, position pos){
        super(pos);
        this.returnType=returnType;
        this.identifier=identifier;
        this.parameterList=parameterList;//null exception
        this.suite=suite;
        isConstructer=false;
        returnExistence=false;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
