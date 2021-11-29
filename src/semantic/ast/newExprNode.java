package semantic.ast;

import semantic.util.FuncSymbol;
import semantic.util.position;

public class newExprNode extends ExprNode{
    public scaledTypeNode scaledType;
    public FuncSymbol funcSymbol;
    public newExprNode(scaledTypeNode scaledType,position pos){
        super(pos);
        this.scaledType=scaledType;
        funcSymbol=null;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
