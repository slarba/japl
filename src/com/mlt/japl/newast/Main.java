package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newparser.AplLexer;
import com.mlt.japl.newparser.AplParser;
import com.mlt.japl.utils.PrintConfig;
import com.mlt.japl.workspace.EvalContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        String testProgram =
                "fn ← { \n"
                        + "       a<10 : 'foo'  \u235D hellou\n"
                        + "       x ← {5 6J.3 + 4}\n"
                        + "       b>5 : 'bar'\n"
                        + "       y u h ← 4 5 6\n"
                        + "       2 3 y 5 3"
                        + "}\nfn 4 5";
        String testProgram2 = "3 4 ∘.{2}.{3}¨ 5 3";
        String testProgram3 = "+[2+3]/[2]3 4 5";
        String testProgram4 = "∇z← b c\n2+b c 3\n∇";
        String testProgram5 = "+/3 4 5";

        EvalContext context = new EvalContext();
        com.mlt.japl.parsing.AplParser parser = new com.mlt.japl.parsing.AplParser(context);
        AstNode result = parser.parse(testProgram5);
        System.out.println(result.toString());
        IValue r = result.eval(context);
        if(r!=null) {
            System.out.println(r.asString(new PrintConfig()));
        } else
            System.out.println("No result");
    }
}
