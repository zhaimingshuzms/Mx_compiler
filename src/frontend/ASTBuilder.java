package frontend;

import ast.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.MxBaseVisitor;
import parser.MxParser;
import util.position;
import ast.binaryExprNode.binaryOpType;

public class ASTBuilder extends MxBaseVisitor <ASTNode>{
    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx){
        RootNode root=new RootNode(new position(ctx));
        ctx.varDef().forEach(vd -> root.strDefs.add((varDefNode)visit(vd)));
        ctx.classDef().forEach(cd -> root.strDefs.add((classDefNode) visit(cd)));
        ctx.functionDef().forEach(fd-> root.strDefs.add((funcDefNode) visit(fd)));
        return root;
    }


    @Override
    public ASTNode visitFunctionParameterDef(MxParser.FunctionParameterDefContext ctx){
        varDefListNode node=new varDefListNode(new position(ctx));
        for (int i=0; i<ctx.Identifier().size(); ++i){
            node.varList.add(new varDefNode((varTypeNode)visit(ctx.varType(i)),ctx.Identifier(i).getText(),new position(ctx.varType(i))));
        }
        return node;
    }

    @Override
    public ASTNode visitParameterList(MxParser.ParameterListContext ctx){
        exprListNode node=new exprListNode(new position(ctx));
        for (var i:ctx.expression()){
            ExprNode tmp=(ExprNode) visit(i);
            node.exprList.add(tmp);
        }
        return node;
    }

    @Override
    public ASTNode visitSuite(MxParser.SuiteContext ctx){
        suiteStmtNode node=new suiteStmtNode(new position(ctx));

        if (!ctx.statement().isEmpty()){
            for (ParserRuleContext stmt:ctx.statement()){
                StmtNode tmp=(StmtNode)visit(stmt);
                if (tmp!=null) node.innerStmt.add(tmp);
                if (tmp instanceof breakStmtNode || tmp instanceof continueStmtNode || tmp instanceof returnStmtNode) break;
            }
        }

        return node;
    }

    @Override
    public ASTNode visitFunctionDef(MxParser.FunctionDefContext ctx){
        funcDefNode node=new funcDefNode((returnTypeNode)visit(ctx.returnType()),ctx.Identifier().getText(),
                ((varDefListNode) visit(ctx.functionParameterDef())).varList,(suiteStmtNode)visit(ctx.suite()),new position(ctx));
        return node;
    }

    @Override
    public ASTNode visitClassDef(MxParser.ClassDefContext ctx){
        classDefNode classDef=new classDefNode(new position(ctx),ctx.Identifier().toString());
        ctx.classMemberDef().forEach(vd->classDef.varDefs.add((varDefNode)visit(vd)));
        ctx.classFunctionDef().forEach(fd ->classDef.funcDefs.add((funcDefNode)visit(fd)));
        return classDef;
    }

    @Override
    public ASTNode visitClassConstructFuncDef(MxParser.ClassConstructFuncDefContext ctx){
        funcDefNode funcDef=new funcDefNode(null,ctx.Identifier().getText(),
                ((varDefListNode) visit(ctx.functionParameterDef())).varList,(suiteStmtNode)visit(ctx.suite()),new position(ctx));
        funcDef.isConstructer=true;
        return funcDef;
    }

    @Override
    public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx){
        ExprNode value=null;
        if (ctx.expression()!=null) value=(ExprNode) visit(ctx.expression());
        return new returnStmtNode(value,new position(ctx));
    }

    @Override
    public ASTNode visitIfStmt(MxParser.IfStmtContext ctx){
        StmtNode thenStmt=(StmtNode)visit(ctx.trueStmt),elseStmt=null;
        ExprNode condition=(ExprNode)visit(ctx.expression());
        if (ctx.falseStmt!=null) elseStmt=(StmtNode)visit(ctx.falseStmt);
        return new ifStmtNode(condition,thenStmt,elseStmt,new position(ctx));
    }

    @Override
    public ASTNode visitContinueStmt(MxParser.ContinueStmtContext ctx){
        continueStmtNode tmp=new continueStmtNode(new position(ctx));
        return tmp;
    }

    @Override
    public ASTNode visitBreakStmt(MxParser.BreakStmtContext ctx){
        breakStmtNode tmp=new breakStmtNode(new position(ctx));
        return tmp;
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx){
        ExprNode lhs=(ExprNode)visit(ctx.expression(0)),
                 rhs=(ExprNode)visit(ctx.expression(1));
        binaryOpType biOp=null;
        if (ctx.Plus()!=null) biOp=binaryOpType.add;
        else if (ctx.Minus()!=null) biOp=binaryOpType.sub;
        else if (ctx.LeftShift()!=null) biOp=binaryOpType.shl;
        else if (ctx.RightShift()!=null) biOp=binaryOpType.shr;
        else if (ctx.Less()!=null) biOp=binaryOpType.less;
        else if (ctx.LessEqual()!=null) biOp=binaryOpType.lessequal;
        else if (ctx.Greater()!=null) biOp=binaryOpType.greater;
        else if (ctx.GreaterEqual()!=null) biOp=binaryOpType.greaterequal;
        else if (ctx.Equal()!=null) biOp=binaryOpType.equal;
        else if (ctx.NotEqual()!=null) biOp=binaryOpType.notequal;
        else if (ctx.And()!=null) biOp=binaryOpType.ariAnd;
        else if (ctx.Or()!=null) biOp=binaryOpType.ariOr;
        else if (ctx.Caret()!=null) biOp=binaryOpType.ariXor;
        else if (ctx.AndAnd()!=null) biOp=binaryOpType.logicAnd;
        else if (ctx.OrOr()!=null) biOp=binaryOpType.logicOr;
        return new binaryExprNode(lhs,rhs,biOp,new position(ctx));
    }

    @Override
    public ASTNode visitAssignExpr(MxParser.AssignExprContext ctx){
        ExprNode lhs=(ExprNode)visit(ctx.expression(0)),
                 rhs=(ExprNode)visit(ctx.expression(1));
        return new assignExprNode(lhs,rhs,new position(ctx));
    }
}
