package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public interface AstNode {
    static String indent(String prefix, String s) {
        String[] parts = s.split("\n");
        StringBuilder builder = new StringBuilder();
        for (String p : parts) {
            builder.append(prefix + p + "\n");
        }
        return builder.toString();
    }

    IValue eval(EvalContext context);
}
