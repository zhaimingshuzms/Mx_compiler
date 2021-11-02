package frontend;

import ast.*;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VoidType;
import error.semanticError;
import parser.MxParser;
import util.*;

public class SemanticChecker implements ASTVisitor{
    public Scope currentScope;
    public FuncSymbol currentFunc;
    public ClassSymbol currentClass;
    public StmtNode currentLoop;
    public boolean visitMember;

    @Override
    public void visit(assignExprNode node){
        node.scope=currentScope;
        node.lhs.accept(this);
        if (!node.lhs.isAssignable()){
            throw new semanticError("assign to not assignable expression",node.pos);
        }
        node.lhs.assertValue();
        node.rhs.accept(this);
        node.rhs.assertValue();
    }

    @Override
    public void visit(varDefNode node){
        String baseType=node.type.type;
        Type type;
        int dim=node.type.dim;
        if (dim==0){
            type=currentScope.findClassSymbol(baseType,node.pos).type;
        }
        else{
            type=new ArrayType(currentScope.findClassSymbol(baseType,node.pos).type,dim);
        }
        if (node.expression!=null){
            node.expression.accept(this);
            node.expression.assertValue();
            type.check(node.expression.type,node.pos);
        }
        VarSymbol varsymbol=new VarSymbol(node.pos,node.identifier,type,currentScope);
        if (visitMember){
            varsymbol.member=true;
        }
        if (currentScope instanceof GlobalScope){
            currentScope.registerVar(varsymbol,node.pos);
        }
        else{
            //for statement exception?
            ((LocalScope)currentScope).registerPara(varsymbol,node.pos);
        }
        node.scope=currentScope;
        node.symbol=varsymbol;
    }

    @Override
    public void visit(memberExprNode node){
        node.scope=currentScope;
        node.expression.accept(this);
        node.expression.assertValue();
        if (node.type instanceof ClassType||node.type instanceof StringType){
            ClassSymbol classSymbol=currentScope.findClassSymbol(node.expression.type.getType(),node.pos);
            Symbol symbol=((LocalScope)currentClass.scope).findSymbol(node.identifier,node.pos);
            if (symbol instanceof FuncSymbol){
                node.exprType= ExprNode.ExprType.FUNCTION;
                node.type=symbol.type;
                node.symbol=symbol;
            }
            else if (symbol instanceof VarSymbol){
                node.exprType=ExprNode.ExprType.LVALUE;
                node.type=symbol.type;
                node.symbol=symbol;
            }
            else throw new semanticError("can't find identifier in class",node.pos);
        }
        else throw new semanticError("memberExprNode error",node.pos);
        //Array was not necessary.
    }

    @Override
    public void visit(newExprNode node){
        node.scope=currentScope;
        node.scaledType.accept(this);

        String baseType=node.scaledType.baseType.type;
        int dim=node.scaledType.baseType.dim;
        ClassSymbol classSymbol=currentScope.findClassSymbol(baseType,node.pos);
        if (dim==0){
            node.type=classSymbol.type;
            if (node.type instanceof ClassType){
                node.funcSymbol=classSymbol.constructer;
            }
        }
        else node.type=new ArrayType(node.type,dim);
        node.exprType= ExprNode.ExprType.RVALUE;
    }


    @Override
    public void visit(scaledTypeNode node){
        node.scope=currentScope;
        for (ExprNode exprNode:node.arraysize){
            exprNode.accept(this);
            IntType intType=new IntType();
            intType.check(exprNode.type,node.pos);
            exprNode.assertValue();
        }
    }

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
            node.parameterList.accept(this);
            node.type=funcSymbol.type;
            node.exprType=ExprNode.ExprType.RVALUE;
        }
    }
    @Override
    public void visit(binaryExprNode node){
        node.scope=currentScope;
        ExprNode lhs=node.lhs;
        ExprNode rhs=node.rhs;
        lhs.accept(this);
        rhs.accept(this);
        lhs.assertValue();
        rhs.assertValue();
        binaryExprNode.binaryOpType op=node.opCode;
        //???
    }

    @Override
    public void visit(identifierPrimaryNode node){
        node.scope=currentScope;
        node.symbol=currentScope.findSymbol(node.identifier,node.pos);
        if (node.symbol instanceof VarSymbol){
            node.type=node.symbol.type;
            node.exprType=ExprNode.ExprType.LVALUE;
        }
        else if (node.symbol instanceof FuncSymbol){
            node.type=node.symbol.type;
            node.exprType=ExprNode.ExprType.FUNCTION;
        }
        else if (node.symbol instanceof ClassSymbol){
            node.type=new ClassDefType();
            node.exprType=ExprNode.ExprType.CLASS;
        }
        else throw new semanticError("no corresponding identifier",node.pos);
    }

    @Override
    public void visit(thisPrimaryNode node){
        if (currentClass==null){
            throw new semanticError("no class but use this",node.pos);
        }
        node.scope=currentScope;
        node.symbol=currentClass;
        node.type=currentClass.type;
        node.exprType=ExprNode.ExprType.RVALUE;
    }

    @Override
    public void visit(varDefListNode node){
        node.varList.forEach(x-> x.accept(this));
        node.scope=currentScope;
    }

    @Override
    public void visit(boolLiteralNode node){
        node.type=new boolType();
        node.exprType=ExprNode.ExprType.RVALUE;
        node.scope=currentScope;
    }

    @Override
    public void visit(ifStmtNode node){
        node.scope=currentScope;
        node.condition.accept(this);
        node.condition.assertValue();
        boolType bt=new boolType();
        bt.check(node.condition.type,node.pos);
        node.thenStmt.accept(this);
        if (node.elseStmt!=null){
            node.elseStmt.accept(this);
        }
    }

    @Override
    public void visit(nullLiteralNode node){
        node.scope=currentScope;
        node.type=new nullType();
        node.exprType= ExprNode.ExprType.RVALUE;
    }

    @Override
    public void visit(forStmtNode node){
        StmtNode upLoop=currentLoop;
        currentLoop=node;
        if (node.varDef!=null){
            Scope upScope=currentScope;
            currentScope=new LocalScope(currentScope);
            node.scope=currentScope;
            node.varDef.accept(this);
            if (node.condition!=null){
                node.condition.accept(this);
                node.condition.assertValue();
                boolType bt=new boolType();
                bt.check(node.condition.type,node.pos);
            }
            else{
                node.condition=new boolLiteralNode(true,node.pos);
                node.condition.accept(this);
            }
            if (node.loopwork!=null) {
                node.loopwork.accept(this);
            }
            node.loopsuite.accept(this);
            currentScope=upScope;
        }
        else{
            if (node.prework!=null){
                node.prework.accept(this);
                node.prework.assertValue();//这可以不是值吧
            }
            if (node.condition!=null){
                node.condition.accept(this);
                node.condition.assertValue();
                boolType bt=new boolType();
                bt.check(node.condition.type,node.pos);
            }
            else{
                node.condition=new boolLiteralNode(true,node.pos);
                node.condition.accept(this);
            }
            if (node.loopwork!=null) {
                node.loopwork.accept(this);
            }
            node.loopsuite.accept(this);
        }
        currentLoop=upLoop;
    }

    @Override
    public void visit(subarrayExprNode node){
        node.scope=currentScope;
        node.identifier.accept(this);
        node.index.accept(this);
        if (!(node.identifier.type instanceof ArrayType)){
            throw new semanticError("SubArrayExprNode identifier ERROR",node.pos);
        }
        if (!(node.index.type instanceof IntType)){
            throw new semanticError("SubArrayExprNode index ERROR",node.pos);
        }
        node.identifier.assertValue();
        node.index.assertValue();
        node.exprType=ExprNode.ExprType.LVALUE;
        ArrayType arrayType=(ArrayType) node.identifier.type;
        if (arrayType.dim==1){
            node.type=arrayType.elementType;
        }
        else{
            node.type=new ArrayType(arrayType.elementType,arrayType.dim-1);
        }
    }

    @Override
    public void visit(exprStmtNode node){
        node.scope=currentScope;
        node.expr.accept(this);
        node.expr.assertValue();
    }

    @Override
    public void visit(stringLiteralNode node){
        node.scope=currentScope;
        node.type=new StringType();
        node.exprType=ExprNode.ExprType.RVALUE;
    }

    @Override
    public void visit(breakStmtNode node){
        node.scope=currentScope;
        if (currentScope==null){
            throw new semanticError("break into nothing",node.pos);
        }
        node.loopNode=currentLoop;
    }

    @Override
    public void visit(integerLiteralNode node){
        node.scope=currentScope;
        node.type=new IntType();
        node.exprType= ExprNode.ExprType.RVALUE;
    }

    @Override
    public void visit(whileStmtNode node){//while 不用改scope 吗，我不理解
        node.scope=currentScope;
        node.condition.accept(this);
        node.condition.assertValue();
        StmtNode upLoop=currentLoop;
        currentLoop=node;
        boolType bt=new boolType();
        bt.check(node.condition.type,node.pos);
        currentLoop=upLoop;
    }

    @Override
    public void visit(returnTypeNode node){
        node.scope=currentScope;
    }

    @Override
    public void visit(returnStmtNode node){
        node.scope=currentScope;
        if (currentFunc==null){
            throw new semanticError("return not in function",node.pos);
        }
        else if (node.value==null){
            voidType vt=new voidType();
            vt.check(currentFunc.type,node.pos);
            ((funcDefNode)(currentFunc.definition)).returnExistence=true;
        }
        else{
            node.value.accept(this);
            node.value.assertValue();
            currentFunc.type.check(node.value.type,node.pos);
            ((funcDefNode)(currentFunc.definition)).returnExistence=true;
        }
    }

    @Override
    public void visit(varDefStmt node){
        node.scope=currentScope;
        node.varDefList.accept(this);
    }

    @Override
    public void visit(continueStmtNode node){
        node.scope=currentScope;
        if (currentLoop==null){
            throw new semanticError("continueStmt with no loop",node.pos);
        }
        node.loopNode=currentLoop;
    }
}
