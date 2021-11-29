package IR.build;

import semantic.ast.ASTVisitor;
import semantic.ast.ifStmtNode;

public class IRBuilder implements ASTVisitor {
    @Override
    public void visit(ifStmtNode it){
        it.condition.accept(this);
        block trueBranch=new block(),falseBranch=new block();
        currentBlock.push_back(new branch(it.condition.val,trueBranch,falseBranch));
    }
}
