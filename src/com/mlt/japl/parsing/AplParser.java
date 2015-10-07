package com.mlt.japl.parsing;

import com.mlt.japl.newparser.AplLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by markolau on 06/10/15.
 */
public class AplParser {
    public AplParser(CharStream in) {
        AplLexer lexer = new AplLexer(in);
        CommonTokenStream s = new CommonTokenStream(lexer);
        com.mlt.japl.newparser.AplParser parser = new com.mlt.japl.newparser.AplParser(s);
    }
}
