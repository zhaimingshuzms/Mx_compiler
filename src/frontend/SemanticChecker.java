package frontend;

import ast.*;
import error.semanticError;
import util.Scope;
import util.Symbol;

public class SemanticChecker implements ASTVisitor{
    public Scope currentScope;
    public Symbol currentFunc;
    @Override
    public void visit(suiteStmtNode node){
        Scope upScope=currentScope;
        Scope localScope=new Scope(currentScope);
        currentScope=localScope;
        node.scope=currentScope;
        for (StmtNode statement:node.innerStmt){
            statement.accept(this);
            currentScope=localScope;
        }
        currentScope=upScope;
    }

    @Override
    public void visit(funcDefNode node){
        Symbol funcSymbol=(Symbol)node.symbol;
        currentFunc=funcSymbol;
        currentScope=funcSymbol.scope;
        node.suite.accept(this);
        currentScope=funcSymbol.scope;
        if (node.isConstructer&&node.returnExistence) {
            throw new semanticError("Constructer with return",node.pos);
        }
        if (!node.isConstructer&&!node.returnExistence&&!node.identifier.equals("main")&&node.returnType.type!=null){
            throw new semanticError("function with no return",node.pos);
        }
    }
}
