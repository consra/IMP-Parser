// Multumesc echipei de CPL pentru acest schelet Main

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        HelloLexer lexer = null;
        CommonTokenStream tokenStream = null;
        HelloParser parser = null;
        ParserRuleContext globalTree = null;

        // True if any lexical or syntax errors occur.
        boolean lexicalSyntaxErrors = false;

        // Deschidem fisierul input pentru a incepe parsarea
        String fileName = "input";
        CharStream input = CharStreams.fromFileName(fileName);

		try {
    		System.setOut(new PrintStream(new File("arbore")));
		} catch (Exception e) {
     		e.printStackTrace();
		}

        // Definim Lexer-ul
        lexer = new HelloLexer(input);

        // Obtinem tokenii din input
        tokenStream = new CommonTokenStream(lexer);

        // Definim Parser-ul
        parser = new HelloParser(tokenStream);

        // Incepem parsarea
        ParserRuleContext tree = parser.mainnode();

        // Vizitam AST-ul
        MyVisitor visitor = new MyVisitor();
        visitor.visit(tree);
    }
}
