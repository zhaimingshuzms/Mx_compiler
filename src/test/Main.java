package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.spec.RSAOtherPrimeInfo;

import ast.ASTVisitor;
import ast.RootNode;
import error.error;
import frontend.ASTBuilder;
import frontend.SemanticChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.MxLexer;
import parser.MxParser;
public class Main {

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello Compiler");
        String name="test.mx";
        InputStream input=new FileInputStream(name);
        try{
            MxLexer lexer=new MxLexer(CharStreams.fromStream(input));
            //lexer.removeErrorListeners();
            //lexer.addErrorListener(new MxErrorListener());
            MxParser parser=new MxParser(new CommonTokenStream(lexer));
            //parser.removeErrorListeners();
            //parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot=parser.program();
            ASTBuilder builder=new ASTBuilder();
            RootNode ret=(RootNode) builder.visit(parseTreeRoot);
            ASTVisitor visitor=new SemanticChecker();
            visitor.visit(ret);
        }catch(error er){
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }

}
