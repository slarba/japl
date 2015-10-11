package com.mlt.japl.parser;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.errors.SyntaxError;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

/**
 * Created by markolau on 11/10/15.
 */
public class ErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        System.out.println("Syntax error: " + msg);
        throw new SyntaxError();
    }
}
