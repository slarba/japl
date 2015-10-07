package com.mlt.japl.newast;

/**
 * Created by markolau on 07/10/15.
 */
public class AstOperator extends AstFunc {
    private final String operator;
    private final AstNode fn;
    private final AstNode axis;

    public AstOperator(String text, AstNode visit, AstNode axis) {
        this.operator = text;
        this.fn = visit;
        this.axis = axis;
    }

    @Override
    public String toString() {
        return fn.toString() + operator + (axis!=null ? ("[" + axis.toString() + "]") : "");
    }
}
