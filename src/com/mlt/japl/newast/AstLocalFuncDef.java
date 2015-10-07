package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstLocalFuncDef extends AstNode {

    private String id;
    private AstFunc fn;

    public AstLocalFuncDef(String id, AstFunc fn) {
        this.id = id;
        this.fn = fn;
    }

    @Override
    public String toString() {
        return id + " <!- " + fn;
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }
}
