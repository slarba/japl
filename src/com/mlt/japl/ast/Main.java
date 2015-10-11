package com.mlt.japl.ast;

import com.mlt.japl.workspace.EvalContext;

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
        String testProgram5 = "x ← +\n2 x 3";
        String testProgram6 = "x ← { 2<1: 666\n" +
                "3<2: 777\n" +
                "⍺+⍵ }\n" +
                "20 x 10";
        EvalContext context = new EvalContext();
/*
        com.mlt.japl.parser.IParser parser = new com.mlt.japl.parser.IParser(context);
        AstNode result = parser.parse(testProgram6);
        System.out.println(result.toString());
        IValue r = result.eval(context);
        if(r!=null) {
            System.out.println(r.asString(new PrintConfig()));
        } else
            System.out.println("No result");
*/
    }
}


