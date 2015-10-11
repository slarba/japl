package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
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
        return new CharArray(text);
    }
}
