package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.workspace.EvalContext;

public class AstString implements AstNode {

    private String text;

    public AstString(String text) {
        this.text = text.substring(1, text.length()-1);
    }

    @Override
    public String toString() {
        return "'" + text + "'";
    }

    @Override
    public IValue eval(EvalContext context) {
        String t = text.substring(1, text.length() - 1);
        return new CharArray(t);
    }
}
