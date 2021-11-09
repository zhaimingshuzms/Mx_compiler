package frontend;

import ast.*;
import error.semanticError;
import parser.MxParser;
import util.*;

import java.util.ArrayList;

public class SemanticChecker implements ASTVisitor{
    public Scope currentScope;
    public FuncSymbol currentFunc;
    public ClassSymbol currentClass;
    public StmtNode currentLoop;
    public boolean visitMember;
    public SemanticChecker(){
        currentScope = new GlobalScope();

        ClassSymbol Int = new ClassSymbol(new position(-1, -1), "int", new IntType(), new LocalScope(currentScope));
        ClassSymbol Bool = new ClassSymbol(new position(-1, -1), "bool", new boolType(), new LocalScope(currentScope));
        ClassSymbol string = new ClassSymbol(new position(-1, -1), "string", new StringType(), new LocalScope(currentScope));
        ClassSymbol Void = new ClassSymbol(new position(-1, -1), "void", new voidType(), new LocalScope(currentScope));

        FuncSymbol Print=new FuncSymbol(new position(-1,-1),"print",new voidType(),new LocalScope(currentScope));
        VarSymbol strPrint=new VarSymbol(new position(-1,-1),"str",new StringType(),Print.scope);
        ((LocalScope)Print.scope).registerPara(strPrint,new position(-1,-1));
        currentScope.registerFunc(Print,new position(-1,-1));

        FuncSymbol Println = new FuncSymbol(new position(-1, -1), "println", new voidType(), new LocalScope(currentScope));
        VarSymbol strPrintln = new VarSymbol(new position(-1, -1), "str", new StringType(), Println.scope);
        ((LocalScope) Println.scope).registerPara(strPrintln, new position(-1, -1));
        currentScope.registerFunc(Println, new position(-1, -1));

        FuncSymbol PrintInt=new FuncSymbol(new position(-1,-1),"printInt",new voidType(),new LocalScope(currentScope));
        VarSymbol strPrintInt=new VarSymbol(new position(-1,-1),"str",new IntType(),PrintInt.scope);
        ((LocalScope)PrintInt.scope).registerPara(strPrintInt,new position(-1,-1));
        currentScope.registerFunc(PrintInt,new position(-1,-1));

        FuncSymbol PrintlnInt=new FuncSymbol(new position(-1,-1),"printlnInt",new voidType(),new LocalScope(currentScope));
        VarSymbol strPrintlnInt=new VarSymbol(new position(-1,-1),"str",new IntType(),PrintlnInt.scope);
        ((LocalScope)PrintlnInt.scope).registerPara(strPrintlnInt,new position(-1,-1));
        currentScope.registerFunc(PrintlnInt,new position(-1,-1));

        FuncSymbol GetString=new FuncSymbol(new position(-1,-1),"getString",new StringType(),new LocalScope(currentScope));
        currentScope.registerFunc(GetString,new position(-1,-1));

        FuncSymbol GetInt=new FuncSymbol(new position(-1,-1),"getInt",new IntType(),new LocalScope(currentScope));
        currentScope.registerFunc(GetInt,new position(-1,-1));

        FuncSymbol ToString=new FuncSymbol(new position(-1,-1),"toString",new StringType(),new LocalScope(currentScope));
        VarSymbol IntToString=new VarSymbol(new position(-1,-1),"int",new IntType(),ToString.scope);
        ((LocalScope)ToString.scope).registerPara(IntToString,new position(-1,-1));
        currentScope.registerFunc(ToString,new position(-1,-1));

        FuncSymbol Length=new FuncSymbol(new position(-1,-1),"length",new IntType(),new LocalScope(string.scope));
        Length.member=true;
        string.scope.registerFunc(Length,new position(-1,-1));

        FuncSymbol SubString=new FuncSymbol(new position(-1,-1),"substring",new StringType(),new LocalScope(string.scope));
        SubString.member=true;
        VarSymbol Left=new VarSymbol(new position(-1,-1),"left",new IntType(),SubString.scope);
        VarSymbol Right=new VarSymbol(new position(-1,-1),"right",new IntType(),SubString.scope);
        ((LocalScope)SubString.scope).registerPara(Left,new position(-1,-1));
        ((LocalScope)SubString.scope).registerPara(Right,new position(-1,-1));
        string.scope.registerFunc(SubString,new position(-1,-1));

        FuncSymbol ParseInt=new FuncSymbol(new position(-1,-1),"parseInt",new IntType(),new LocalScope(string.scope));
        ParseInt.member=true;
        string.scope.registerFunc(ParseInt,new position(-1,-1));

        FuncSymbol Ord=new FuncSymbol(new position(-1,-1),"ord",new IntType(),new LocalScope(string.scope));
        Ord.member=true;
        string.scope.registerFunc(Ord,new position(-1,-1));

        FuncSymbol ArraySize=new FuncSymbol(new position(-1,-1),"*size*",new IntType(),new LocalScope(currentScope));
        currentScope.registerFunc(ArraySize,new position(-1,-1));

        currentScope.registerClass(Int,new position(-1, -1));
        currentScope.registerClass(Bool,new position(-1, -1));
        currentScope.registerClass(string,new position(-1, -1));
        currentScope.registerClass(Void,new position(-1, -1));
    }
    @Override
    public void visit(RootNode node) {
        System.out.println("visit rootnode");
        for (var i : node.strDefs)
            if (i instanceof classDefNode) {
                ClassSymbol classSymbol = new ClassSymbol(i.pos, ((classDefNode) i).name, new ClassType(((classDefNode) i).name), i);
                classSymbol.scope = new LocalScope(currentScope);
                currentScope.registerClass(classSymbol, i.pos);
                ((classDefNode) i).symbol = classSymbol;
                i.scope = classSymbol.scope;
            }

        boolean checkMain = false;
        for (var i : node.strDefs)
            if (i instanceof classDefNode) {
                currentClass=((classDefNode) i).symbol;
                currentScope = i.scope;
                visitMember = true;
                ((classDefNode) i).varDefs.forEach(x -> x.accept(this));
                visitMember = false;
                for (var j : ((classDefNode) i).funcDefs) {
                    if (j.identifier.equals(((classDefNode) i).name)) {
                        j.isConstructer = true;
                        if (j.returnType != null) {
                            throw new semanticError("fake constructer", j.pos);
                        }
                    }

                    Type type = null;
                    if (j.returnType.type!= null) {
                        j.returnType.accept(this);
                        String baseType = j.returnType.type.type;
                        int dim = j.returnType.type.dim;
                        if (dim == 0) {
                            type = currentScope.findClassSymbol(baseType, j.pos).type;
                        } else {
                            type = new ArrayType(currentScope.findClassSymbol(baseType, j.pos).type, dim);
                        }
                    }
                    FuncSymbol funcSymbol = new FuncSymbol(j.pos, j.identifier, type, j);
                    funcSymbol.scope = new LocalScope(currentScope);
                    funcSymbol.member = true;
                    j.symbol = funcSymbol;
                    j.scope = funcSymbol.scope;
                    currentScope.registerFunc(funcSymbol, j.pos);
                    currentScope=j.scope;
                    j.accept(this);
                    currentScope=j.scope.Parent();
                }
                currentScope = i.scope.Parent();
                currentClass =null;
            } else if (i instanceof funcDefNode) {
                ((funcDefNode) i).returnType.accept(this);
                Type type = new voidType();
                if (((funcDefNode) i).returnType.type != null) {//not void
                    ((funcDefNode) i).returnType.accept(this);
                    String baseType = ((funcDefNode) i).returnType.type.type;
                    int dim = ((funcDefNode) i).returnType.type.dim;
                    if (dim == 0) {
                        type = currentScope.findClassSymbol(baseType, i.pos).type;
                    } else {
                        type = new ArrayType(currentScope.findClassSymbol(baseType, i.pos).type, dim);
                    }
                }
                FuncSymbol funcSymbol = new FuncSymbol(i.pos, ((funcDefNode) i).identifier, type, i);
                funcSymbol.scope = new LocalScope(currentScope);
                ((funcDefNode) i).symbol = funcSymbol;
                i.scope = funcSymbol.scope;
                currentScope.registerFunc(funcSymbol, i.pos);
                if (((funcDefNode) i).identifier.equals("main")) {
                    if (((funcDefNode) i).returnType.type==null){
                        throw new semanticError("main with not void returnType",node.pos);
                    }
                    else if (!((funcDefNode) i).parameterList.isEmpty()){
                        throw new semanticError("main with parameter",node.pos);
                    }
                    checkMain = true;
                }
                currentScope = i.scope;
                i.accept(this);
                currentScope = i.scope.Parent();
            }
            else if (i instanceof varDefListNode){
                i.accept(this);
            }
            else throw new semanticError("Rootnode error", node.pos);
        if (!checkMain) throw new semanticError("no main error", node.pos);
    }
    @Override
    public void visit(assignExprNode node){
        node.scope=currentScope;
        node.lhs.accept(this);
        if (!node.lhs.isAssignable()){
            throw new semanticError("assign to not assignable expression",node.pos);
        }
        node.lhs.assertValue();
        node.rhs.accept(this);
        node.lhs.type.check(node.rhs.type,node.pos);
        node.rhs.assertValue();
        node.type=node.lhs.type;
        node.exprType= ExprNode.ExprType.LVALUE;
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
        if (node.expression.type instanceof ClassType||node.expression.type instanceof StringType){
            ClassSymbol classSymbol=currentScope.findClassSymbol(node.expression.type.getType(),node.pos);
            Symbol symbol=classSymbol.scope.findSymbol(node.identifier,node.pos);
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
        else if (node.expression.type instanceof ArrayType){
            if (node.identifier.equals("size")){
                Symbol symbol=currentScope.findSymbol("*size*",node.pos);
                node.exprType=ExprNode.ExprType.FUNCTION;
                node.type=new IntType();
                node.symbol=symbol;
            }
            else throw new semanticError("not the size of array",node.pos);
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
        else{
            node.type=new ArrayType(classSymbol.type,dim);
        }

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
    public void visit(varTypeNode node){
        throw new semanticError("varTypeNode",node.pos);
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
        FuncSymbol funcSymbol=node.symbol;
        currentFunc=funcSymbol;
        for (var i:node.parameterList){
            i.accept(this);
            currentScope=funcSymbol.scope;
        }
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
    public void visit(exprListNode node){
        node.scope=currentScope;
        for (var i:node.exprList){
            i.accept(this);
            i.assertValue();
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
            for (int i=0; i<node.parameterList.exprList.size(); ++i){
                ((LocalScope)funcSymbol.scope).parameterList.get(i).type.check(node.parameterList.exprList.get(i).type,node.pos);
            }
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
        if (op== binaryExprNode.binaryOpType.sub||
                op== binaryExprNode.binaryOpType.mul||
                op== binaryExprNode.binaryOpType.div||
                op== binaryExprNode.binaryOpType.mod||
                op== binaryExprNode.binaryOpType.shl||
                op== binaryExprNode.binaryOpType.shr||
                op== binaryExprNode.binaryOpType.ariAnd||
                op== binaryExprNode.binaryOpType.ariOr||
                op== binaryExprNode.binaryOpType.ariXor
        ){
            IntType intType=new IntType();
            intType.check(lhs.type,lhs.pos);
            intType.check(rhs.type,rhs.pos);
            node.type=intType;
            node.exprType= ExprNode.ExprType.RVALUE;
        }
        else if (op==binaryExprNode.binaryOpType.logicAnd||op==binaryExprNode.binaryOpType.logicOr){
            boolType bt=new boolType();
            bt.check(lhs.type,lhs.pos);
            bt.check(rhs.type,rhs.pos);
            node.type=bt;
            node.exprType=ExprNode.ExprType.RVALUE;
        }
        else if (op== binaryExprNode.binaryOpType.add){
            if (lhs.type instanceof IntType && rhs.type instanceof IntType){
                node.type=new IntType();
                node.exprType=ExprNode.ExprType.RVALUE;
            }
            else if (lhs.type instanceof StringType && rhs.type instanceof StringType){
                node.type=new StringType();
                node.exprType=ExprNode.ExprType.RVALUE;
            }
            else throw new semanticError("BinaryExprNode error",node.pos);
        }
        else if (op== binaryExprNode.binaryOpType.less||
                op== binaryExprNode.binaryOpType.lessequal||
                op== binaryExprNode.binaryOpType.greater||
                op== binaryExprNode.binaryOpType.greaterequal){
            if (lhs.type instanceof IntType && rhs.type instanceof IntType||lhs.type instanceof StringType && rhs.type instanceof StringType) {
                node.type=new boolType();
                node.exprType=ExprNode.ExprType.RVALUE;
            }
            else throw new semanticError("BinaryExprNode error",node.pos);
        }
        else if (op==binaryExprNode.binaryOpType.equal ||op==binaryExprNode.binaryOpType.notequal){
            lhs.type.checkEqual(rhs.type,node.pos);
            node.type=new boolType();
            node.exprType= ExprNode.ExprType.RVALUE;
        }
        else throw new semanticError("BinaryExprNode error",node.pos);
    }

    @Override
    public void visit(prefixExprNode node){
        node.scope=currentScope;
        node.expr.accept(this);
        node.expr.assertValue();
        var op=node.op;
        if (op==prefixExprNode.prefixOpType.Plus||op== prefixExprNode.prefixOpType.Minus||op== prefixExprNode.prefixOpType.Tilde){
            IntType intType=new IntType();
            intType.check(node.expr.type,node.expr.pos);
            node.type=intType;
            node.exprType= ExprNode.ExprType.RVALUE;
        }
        else if (op== prefixExprNode.prefixOpType.SelfPlus||op== prefixExprNode.prefixOpType.SelfMinus){
            if (node.expr.exprType!= ExprNode.ExprType.LVALUE){
                throw new semanticError("PrefExprNode error",node.expr.pos);
            }
            IntType intType=new IntType();
            intType.check(node.expr.type,node.pos);
            node.type=intType;
            node.exprType= ExprNode.ExprType.LVALUE;
        }
        else if (op== prefixExprNode.prefixOpType.Not){
            boolType bt=new boolType();
            bt.check(node.expr.type,node.expr.pos);
            node.type=bt;
            node.exprType=ExprNode.ExprType.RVALUE;
        }
        else throw new semanticError("PrefixExprNode Op Error",node.pos);
    }
    @Override
    public void visit(exprPrimaryNode node){
        node.scope=currentScope;
        node.expression.accept(this);
        node.expression.assertValue();
        node.type=node.expression.type;
        node.exprType=node.expression.exprType;
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
    public void visit(suffixExprNode node){
        node.scope=currentScope;
        node.expr.accept(this);
        node.expr.assertValue();
        if (node.expr.exprType!= ExprNode.ExprType.LVALUE){
            throw new semanticError("suffixExprNode ERROR",node.pos);
        }
        IntType intType=new IntType();
        intType.check(node.expr.type,node.expr.pos);
        node.type=intType;
        node.exprType=(ExprNode.ExprType.RVALUE);
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
