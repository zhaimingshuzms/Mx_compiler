package IR.build;

import IR.components.*;
import semantic.ast.*;
import semantic.util.*;

public class IRBuilder implements ASTVisitor {
    public block currentBlock;
    public Scope currentScope;
    @Override
    public void visit(ifStmtNode it){
        it.condition.accept(this);
        block trueBranch=new block(),falseBranch=new block();
        currentBlock.add(new brOpe(it.condition.val,trueBranch,falseBranch));
        block destination=new block();
        currentBlock=trueBranch;
        it.thenStmt.accept(this);
        currentBlock.add(new jump(destination));
        currentBlock=falseBranch;
        it.elseStmt.accept(this);
        currentBlock.add(new jump(destination));
        currentBlock=destination;
    }

    @Override
    public void visit(returnStmtNode it){
        entity value;
        if (it.value!=null){
            it.value.accept(this);
            value=it.value.val;
        }
        else value=null;
        currentBlock.add(new ret(value));
    }

    @Override
    public void visit(suiteStmtNode it){
        for (var i:it.innerStmt){
            i.accept(this);
        }
    }

    @Override
    public void visit(exprStmtNode it){
        it.expr.accept(this);
    }

    public void regAssign(Register a,Register b){
        currentBlock.
    }

    @Override
    public void visit(assignExprNode it){
        it.lhs.accept(this);
        it.rhs.accept(this);
        regAssign(it.lhs,it.rhs);
    }

    @Override
    public void visit(binaryExprNode it){
        it.lhs.accept(this);
        it.rhs.accept(this);
        Register value;
        if (it.val!=null) value=(Register)it.val;
        else{
            value=new Register();
            it.val=value;
        }
        currentBlock.add(new binary(value,it.lhs.val,it.rhs.val,it.opCode));
    }

    @Override
    public void visit(boolLiteralNode it){
        
    }
}
