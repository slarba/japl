package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstFuncRef extends AstFunc {

    private final String id;

    public AstFuncRef(String id) {
        this.id = id;
    }

    @Override
    public IValue eval(EvalContext context) {
        return context.get(id).get();
    }

    @Override
    public String toString() {
        return id;
    }
}
