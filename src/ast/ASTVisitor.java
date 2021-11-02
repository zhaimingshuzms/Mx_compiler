package ast;

public interface ASTVisitor {
    void visit(assignExprNode node);
    void visit(ASTNode node);
    void visit(binaryExprNode node);
    void visit(boolLiteralNode node);
    void visit(breakStmtNode node);
    void visit(classDefNode node);
    void visit(continueStmtNode node);
    void visit(ExprNode node);
    void visit(exprPrimaryNode node);
    void visit(exprStmtNode node);
    void visit(forStmtNode node);
    void visit(funcDefNode node);
    void visit(funcExprNode node);
    void visit(identifierPrimaryNode node);
    void visit(ifStmtNode node);
    void visit(integerLiteralNode node);
    void visit(literalPrimaryNode node);
    void visit(memberExprNode node);
    void visit(newExprNode node);
    void visit(nullLiteralNode node);
    void visit(prefixExprNode node);
    void visit(returnStmtNode node);
    void visit(returnTypeNode node);
    void visit(RootNode node);
    void visit(scaledTypeNode node);
    //void visit(StmtNode node);
    void visit(stringLiteralNode node);
    void visit(subarrayExprNode node);
    void visit(suiteStmtNode node);
    void visit(thisPrimaryNode node);
    void visit(varDefListNode node);
    void visit(varDefNode node);
    void visit(varDefStmt node);
    void visit(varTypeNode node);
    void visit(whileStmtNode node);
}
