package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.workspace.EvalContext;

public class AstFloat implements AstNode {

    private double value;

    public AstFloat(String text) {
        value = parse(text);
    }

    public static double parse(String text) {
        text = text.replace('\u00af', '-');
        return Double.parseDouble(text);
    }

    public String toString() {
        return Double.toString(value);
    }

    @Override
    public IValue eval(EvalContext context) {
        return new DoubleScalar(value);
    }
}
