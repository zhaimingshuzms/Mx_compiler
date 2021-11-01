package frontend;

import ast.*;
import error.semanticError;
import parser.MxParser;
import util.*;

public class SemanticChecker implements ASTVisitor{
    public Scope currentScope;
    public FuncSymbol currentFunc;
    public ClassSymbol currentClass;
    @Override
    public void visit(suiteStmtNode node){
        Scope upScope=currentScope;
        LocalScope localScope=new LocalScope(currentScope);
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
        FuncSymbol funcSymbol=(FuncSymbol)node.symbol;
        currentFunc=funcSymbol;
        currentScope=funcSymbol.scope;
        node.suite.accept(this);
        currentScope=funcSymbol.scope;
        if (node.isConstructer&&node.returnExistence) {
            throw new semanticError("constructer with return",node.pos);
        }
        if (!node.isConstructer&&!node.returnExistence&&!node.identifier.equals("main")&&node.returnType.type!=null){
            throw new semanticError("function with no return",node.pos);
        }
    }

    @Override
    public void visit(classDefNode node){
        ClassSymbol classSymbol=node.symbol;
        currentClass=classSymbol;
        currentScope=classSymbol.scope;
        for (funcDefNode func : node.funcDefs){
            func.accept(this);
            currentScope=func.scope.Parent();
            currentFunc=null;
        }
    }

    @Override
    public void visit(funcExprNode node){
        node.scope=currentScope;
        node.expression.accept(this);
        if (node.expression.exprType!=ExprNode.ExprType.FUNCTION){
            throw new semanticError("function expression is not function",node.pos);
        }
        else{
            ExprNode expression=node.expression;
            FuncSymbol funcSymbol;
            if (expression instanceof identifierPrimaryNode){
                funcSymbol=(FuncSymbol)((identifierPrimaryNode)(expression)).symbol;
            }
            else if (expression instanceof memberExprNode){
                funcSymbol=(FuncSymbol)((memberExprNode)(expression)).symbol;
            }
            else throw new semanticError("func expression instance error",node.pos);
            node.symbol=funcSymbol;
            if (((LocalScope)(funcSymbol.scope)).parameterList.size()!=node.parameterList.exprList.size()){
                throw new semanticError ("parameter size not match",node.pos);
            }
            //?????
        }
    }
}
