package com.mlt.japl.parser;

import com.mlt.japl.ast.AstBuilderVisitor;
import com.mlt.japl.ast.AstNode;
import com.mlt.japl.workspace.EvalContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by markolau on 06/10/15.
 */
public class IParser {
    public static AstNode parse(InputStream in, EvalContext rootContext) {
        try {
            AplLexer lexer = new AplLexer(new UnbufferedCharStream(new InputStreamReader(in, "UTF-8")));
            lexer.setTokenFactory(new CommonTokenFactory(true));
            com.mlt.japl.parser.AplParser parser = new com.mlt.japl.parser.AplParser(new UnbufferedTokenStream<CommonToken>(lexer), rootContext);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());
            ParseTree tree = parser.toplevel();
            AstNode result = tree.accept(new AstBuilderVisitor());
            System.out.println(result.toString());
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static AstNode parse(String line, EvalContext rootContext) {
        AplLexer lexer = new AplLexer(new ANTLRInputStream(line));
        com.mlt.japl.parser.AplParser parser = new com.mlt.japl.parser.AplParser(new CommonTokenStream(lexer), rootContext);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.interactive();
        System.out.println(tree.toStringTree(parser));
        AstNode result = tree.accept(new AstBuilderVisitor());
        System.out.println(result.toString());
        return result;
    }
}
