package com.mlt.japl.newast;

import com.mlt.japl.newparser.AplLexer;
import com.mlt.japl.newparser.AplParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;

public class Main {
	public static void main(String[] args) {
		String testProgram = 
			 "fn ← { \n"
			+"       a<10 : 'foo'\n"
			+"       x ← {5 6 + 4}\n"
			+"       b>5 : 'bar'\n"
			+"       -x 3"
					+ "}\nfn 4 5";
		String testProgram2 = "2 3 specialsym 4 5";
		AplLexer lexer = new AplLexer(new ANTLRInputStream(testProgram2));
		CommonTokenStream s = new CommonTokenStream(lexer);
		AplParser parser = new AplParser(s);
		ParseTree tree = parser.toplevel();
		System.out.println(tree.toStringTree(parser));
		AstNode result = tree.accept(new AstBuilderVisitor());
		System.out.println(result.toString());
	}
}
