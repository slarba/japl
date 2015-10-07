package com.mlt.japl.newast;

/**
 * Created by markolau on 07/10/15.
 */
public class AstSimpleFunc extends AstFunc {
    private final String fn;
    private final AstNode axis;

    public AstSimpleFunc(String text, AstNode axis) {
        this.fn = text;
        this.axis = axis;
    }

    @Override
    public String toString() {
        return fn + (axis!=null ? ("[" + axis.toString() + "]") : "");
    }
}
