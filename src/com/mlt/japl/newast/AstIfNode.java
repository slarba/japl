package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstIfNode implements AstNode {

    private AstNode cond;
    private AstNode thenb;
    private AstNode elseb;

    public AstIfNode(AstNode cond, AstNode thenb, AstNode elseb) {
        this.cond = cond;
        this.thenb = thenb;
        this.elseb = elseb;
    }

    @Override
    public String toString() {
        return "IF(" + cond + ") {\n" + AstNode.indent("   ", thenb.toString()) + "}";
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }
}
