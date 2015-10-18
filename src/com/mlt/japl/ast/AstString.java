package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.concrete.CharScalar;
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
        if(text.length()==1) {
            return new CharScalar(text.charAt(0));
        }
        return new CharArray(text);
    }
}
