package frontend;

import ast.*;
import error.builderError;
import error.semanticError;
import org.antlr.v4.runtime.*;
import parser.MxBaseVisitor;
import parser.MxParser;
import util.position;
import ast.binaryExprNode.binaryOpType;

public class ASTBuilder extends MxBaseVisitor <ASTNode>{
    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx){
        RootNode root=new RootNode(new position(ctx));
        ctx.varDef().forEach(vd -> root.strDefs.add(visit(vd)));
        ctx.classDef().forEach(cd -> root.strDefs.add(visit(cd)));
        ctx.functionDef().forEach(fd-> root.strDefs.add(visit(fd)));
        root.strDefs.sort(ASTNode::compareTo);
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
    public ASTNode visitBlock(MxParser.BlockContext ctx){
        return (suiteStmtNode)visit(ctx.suite());
    }

    @Override
    public ASTNode visitVarDefStmt(MxParser.VarDefStmtContext ctx){
        varDefStmt node=new varDefStmt((varDefListNode)visit(ctx.varDef()),new position(ctx));
        return node;
    }

    @Override
    public ASTNode visitIfStmt(MxParser.IfStmtContext ctx){
        StmtNode thenStmt=(StmtNode)visit(ctx.trueStmt),elseStmt=null;
        ExprNode condition=(ExprNode)visit(ctx.expression());
        if (ctx.falseStmt!=null) elseStmt=(StmtNode)visit(ctx.falseStmt);
        return new ifStmtNode(condition,thenStmt,elseStmt,new position(ctx));
    }

    @Override
    public ASTNode visitForStmt(MxParser.ForStmtContext ctx){
        forStmtNode node;
        ExprNode condition= ctx.condition == null ? null : (ExprNode)visit(ctx.condition);
        ExprNode loopexpression= ctx.loopexpression == null ? null : (ExprNode)visit(ctx.loopexpression);
        suiteStmtNode suite;
        StmtNode tmp=(StmtNode)visit(ctx.statement());
        if (tmp instanceof suiteStmtNode){
            suite=(suiteStmtNode) tmp;
        }
        else {
            suite=new suiteStmtNode(tmp.pos);
            suite.innerStmt.add(tmp);
        }
        if (ctx.prework.isEmpty()) node=new forStmtNode((varDefListNode)visit(ctx.prevar),condition,loopexpression,suite,new position(ctx));
        else if (ctx.prevar.isEmpty()) node=new forStmtNode((ExprNode)visit(ctx.prework),condition,loopexpression,suite,new position(ctx));
        else node=new forStmtNode(condition,loopexpression,suite,new position(ctx));
        return node;
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
    public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx){
        ExprNode value=null;
        if (ctx.expression()!=null) value=(ExprNode) visit(ctx.expression());
        return new returnStmtNode(value,new position(ctx));
    }

    @Override
    public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx){
        suiteStmtNode suite;
        StmtNode tmp=(StmtNode) visit(ctx.statement());
        if (tmp instanceof suiteStmtNode){
            suite=(suiteStmtNode) tmp;
        }
        else {
            suite=new suiteStmtNode(tmp.pos);
            suite.innerStmt.add(tmp);
        }
        return new whileStmtNode((ExprNode) visit(ctx.expression()),suite,new position(ctx));
    }

    @Override
    public ASTNode visitExpressionStmt(MxParser.ExpressionStmtContext ctx){
        return new exprStmtNode((ExprNode)visit(ctx.expression()),new position(ctx));
    }

    @Override
    public ASTNode visitVarDef(MxParser.VarDefContext ctx){
        varTypeNode varType=(varTypeNode) visit(ctx.varType());
        varDefListNode ret=new varDefListNode(new position(ctx));
        for (var i : ctx.varDeclaration()){
            var tmp=(varDefNode)visit(i);
            tmp.type=varType;
            ret.varList.add(tmp);
        }
        return ret;
    }

    @Override
    public ASTNode visitVarDeclaration(MxParser.VarDeclarationContext ctx){
        if (ctx.expression()!=null){
            ExprNode expr=(ExprNode)visit(ctx.expression());
            return new varDefNode(ctx.Identifier().getText(),expr,new position(ctx));
        }
        return new varDefNode(ctx.Identifier().getText(),null,new position(ctx));
    }
    @Override
    public ASTNode visitClassDef(MxParser.ClassDefContext ctx){
        classDefNode classDef=new classDefNode(new position(ctx),ctx.Identifier().toString());
        ctx.classMemberDef().forEach(vd->classDef.varDefs.add((varDefListNode)visit(vd.varDef())));
        ctx.classFunctionDef().forEach(fd->classDef.funcDefs.add((funcDefNode)visit(fd)));
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
    public ASTNode visitAtomExpr(MxParser.AtomExprContext ctx){
        return visit(ctx.primary());
    }

    public ASTNode visitPrimary(MxParser.PrimaryContext ctx){
        if (ctx.expression()!=null){
            return new exprPrimaryNode((ExprNode) visit(ctx.expression()),new position(ctx));
        }
        else if (ctx.Identifier()!=null){
            return new identifierPrimaryNode(ctx.Identifier().getText(),new position(ctx));
        }
        else if (ctx.This()!=null){
            return new thisPrimaryNode(new position(ctx));
        }
        else if (ctx.literal()!=null){
            return visit(ctx.literal());
        }
        throw new builderError("primary error",new position(ctx));
    }

    @Override
    public ASTNode visitNewExpr(MxParser.NewExprContext ctx){
        return new newExprNode((scaledTypeNode)visit(ctx.scaledType()),new position(ctx));
    }

    @Override
    public ASTNode visitSubarrayExpr(MxParser.SubarrayExprContext ctx){
        return new subarrayExprNode((ExprNode)visit(ctx.expression(0)),(ExprNode)visit(ctx.expression(1)),new position(ctx));
    }

    @Override
    public ASTNode visitFuncExpr(MxParser.FuncExprContext ctx){
        if (ctx.parameterList()!=null) return new funcExprNode((ExprNode)visit(ctx.expression()),(exprListNode) visit(ctx.parameterList()),new position(ctx));
        return new funcExprNode((ExprNode)visit(ctx.expression()),new position(ctx));
    }

    @Override
    public ASTNode visitFunctionDef(MxParser.FunctionDefContext ctx){
        funcDefNode node=new funcDefNode((returnTypeNode)visit(ctx.returnType()),ctx.Identifier().getText(),
                ((varDefListNode) visit(ctx.functionParameterDef())).varList,(suiteStmtNode)visit(ctx.suite()),new position(ctx));
        return node;
    }

    @Override
    public ASTNode visitSuffixExpr(MxParser.SuffixExprContext ctx){
        if (ctx.SelfPlus()!=null) return new suffixExprNode((ExprNode)visit(ctx.expression()),suffixExprNode.suffixOpType.SelfPlus,new position(ctx));
        else if (ctx.SelfMinus()!=null) return new suffixExprNode((ExprNode)visit(ctx.expression()),suffixExprNode.suffixOpType.SelfMinus,new position(ctx));
        throw new builderError("suffixExpr error",new position(ctx));
    }

    @Override
    public ASTNode visitMemberExpr(MxParser.MemberExprContext ctx){
        return new memberExprNode((ExprNode) visit(ctx.expression()),ctx.Identifier().getText(),new position(ctx));
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
    public ASTNode visitPrefixExpr(MxParser.PrefixExprContext ctx){
        if (ctx.SelfPlus()!=null){
            return new prefixExprNode(prefixExprNode.prefixOpType.SelfPlus,(ExprNode)visit(ctx.expression()),new position(ctx));
        }
        else if (ctx.SelfMinus()!=null){
            return new prefixExprNode(prefixExprNode.prefixOpType.SelfMinus,(ExprNode)visit(ctx.expression()),new position(ctx));
        }
        else if (ctx.Plus()!=null){
            return new prefixExprNode(prefixExprNode.prefixOpType.Plus,(ExprNode)visit(ctx.expression()),new position(ctx));
        }
        else if (ctx.Minus()!=null){
            return new prefixExprNode(prefixExprNode.prefixOpType.Minus,(ExprNode)visit(ctx.expression()),new position(ctx));
        }
        else if (ctx.Not()!=null){
            return new prefixExprNode(prefixExprNode.prefixOpType.Not,(ExprNode)visit(ctx.expression()),new position(ctx));
        }
        else if (ctx.Tilde()!=null){
            return new prefixExprNode(prefixExprNode.prefixOpType.Tilde,(ExprNode)visit(ctx.expression()),new position(ctx));
        }
        throw new builderError("prefixExpr error",new position(ctx));
    }
    @Override
    public ASTNode visitAssignExpr(MxParser.AssignExprContext ctx){
        ExprNode lhs=(ExprNode)visit(ctx.expression(0)),
                 rhs=(ExprNode)visit(ctx.expression(1));
        return new assignExprNode(lhs,rhs,new position(ctx));
    }

    @Override
    public ASTNode visitReturnType(MxParser.ReturnTypeContext ctx){
        if (ctx.varType()!=null) return new returnTypeNode((varTypeNode)visit(ctx.varType()),new position(ctx));
        return new returnTypeNode(null,new position(ctx));
    }

    @Override
    public ASTNode visitVarType(MxParser.VarTypeContext ctx){
        if (ctx.LeftBracket().size()>0){
            varTypeNode tmp = (varTypeNode) visit(ctx.varType());
            return new varTypeNode(tmp.type, ctx.LeftBracket().size(), tmp.pos);
        }
        else if (ctx.Identifier()!=null){
            return new varTypeNode(ctx.Identifier().getText(),new position(ctx));
        }
        else if (ctx.builtinType()!=null) {
            return new varTypeNode(ctx.builtinType().getText(), new position(ctx));
        }
        throw new semanticError("varType error",new position(ctx));
    }

    @Override
    public ASTNode visitBasicType(MxParser.BasicTypeContext ctx){
        if (ctx.builtinType()!=null){
            return new scaledTypeNode(new varTypeNode(ctx.builtinType().getText(),new position(ctx)),new position(ctx));
        }
        else if (ctx.Identifier()!=null)
            return new scaledTypeNode(new varTypeNode(ctx.Identifier().getText(),new position(ctx)),new position(ctx));
        throw new builderError("basicTypeerror",new position(ctx));
    }

    @Override
    public ASTNode visitArrayType(MxParser.ArrayTypeContext ctx){
        String s;
        if (ctx.builtinType()!=null) s=ctx.builtinType().getText();
        else s=ctx.Identifier().getText();
        scaledTypeNode ret=new scaledTypeNode(new varTypeNode(s,new position(ctx)),new position(ctx));
        for (var i:ctx.expression()){
            ExprNode tmp=(ExprNode)visit(i);
            ret.arraysize.add(tmp);
        }
        ret.baseType.dim=ctx.LeftBracket().size();
        return ret;
    }

    @Override
    public ASTNode visitLiteral(MxParser.LiteralContext ctx){
        if (ctx.DecimalInteger()!=null) return new integerLiteralNode(Integer.parseInt(ctx.getText()),new position(ctx));
        else if (ctx.StringLiteral()!=null) return new stringLiteralNode(ctx.getText(),new position(ctx));
        else if (ctx.Null()!=null) return new nullLiteralNode(new position(ctx));
        else if (ctx.True()!=null) return new boolLiteralNode(true,new position(ctx));
        else if (ctx.False()!=null) return new boolLiteralNode(false,new position(ctx));
        throw new semanticError("literalNode error",new position(ctx));
    }
    //above is verified.
}
