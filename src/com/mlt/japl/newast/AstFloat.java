package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.workspace.EvalContext;

public class AstFloat implements AstNode {

    private double value;

    public AstFloat(String text) {
        value = parse(text);
    }

    public static double parse(String text) {
        long sign = 1;
        if(text.startsWith("\u00af")) sign = -1;
        return sign*Double.parseDouble(sign<0 ? text.substring(1) : text);
    }

    public String toString() {
        return Double.toString(value);
    }

    @Override
    public IValue eval(EvalContext context) {
        return new DoubleScalar(value);
    }
}
