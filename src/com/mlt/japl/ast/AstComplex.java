package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.ComplexScalar;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 07/10/15.
 */
public class AstComplex implements AstNode {
    double real;
    double imag;

    public AstComplex(String text) {
        String[] parts = text.split("J");
        real = AstFloat.parse(parts[0]);
        imag = AstFloat.parse(parts[1]);
    }

    @Override
    public IValue eval(EvalContext context) {
        return new ComplexScalar(real, imag);
    }

    @Override
    public String toString() {
        return "complex(" + real + "," + imag + ")";
    }
}
