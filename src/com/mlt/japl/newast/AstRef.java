package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstRef implements AstNode {

    private String id;

    public AstRef(String text) {
        this.id = text;
    }

    @Override
    public String toString() {
        return "@" + id;
    }

    public String getId() {
        return id;
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }
}
