package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 07/10/15.
 */
public class AstComplex extends AstNode {
    double real;
    double imag;

    public AstComplex(String text) {
        String[] parts = text.split("J");
        real = AstFloat.parse(parts[0]);
        imag = AstFloat.parse(parts[1]);
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }

    @Override
    public String toString() {
        return "complex(" + real + "," + imag + ")";
    }
}
