package com.mlt.japl.parsing;

import com.mlt.japl.newast.AstBuilderVisitor;
import com.mlt.japl.newast.AstNode;
import com.mlt.japl.newparser.AplLexer;
import com.mlt.japl.workspace.EvalContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by markolau on 06/10/15.
 */
public class AplParser {
    private final EvalContext rootContext;

    public AplParser(EvalContext rootContext) {
        this.rootContext = rootContext;
    }

    public AstNode parse(String line) {
        AplLexer lexer = new AplLexer(new ANTLRInputStream(line));
        CommonTokenStream s = new CommonTokenStream(lexer);
        com.mlt.japl.newparser.AplParser parser = new com.mlt.japl.newparser.AplParser(s, rootContext);
        ParseTree tree = parser.toplevel();
        AstNode result = tree.accept(new AstBuilderVisitor(rootContext));
        return result;
    }
}
