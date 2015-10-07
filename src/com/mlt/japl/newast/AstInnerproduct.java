package com.mlt.japl.newast;

/**
 * Created by markolau on 07/10/15.
 */
public class AstInnerproduct extends AstFunc {
    private final AstNode outer;
    private final AstNode inner;

    public AstInnerproduct(AstNode outer, AstNode inner) {
        this.outer = outer;
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "(" + outer.toString() + "." + inner.toString() + ")";
    }
}
