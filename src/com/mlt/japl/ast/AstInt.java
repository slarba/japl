package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class AstInt implements AstNode {

    private long value;

    public AstInt(String text) {
        long sign = 1;
        if(text.startsWith("\u00af")) sign = -1;
        value = sign*Long.parseLong(sign<0 ? text.substring(1) : text);
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

    @Override
    public IValue eval(EvalContext context) {
        return new IntScalar(value);
    }
}
