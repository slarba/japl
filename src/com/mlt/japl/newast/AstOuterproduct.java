package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 07/10/15.
 */
public class AstOuterproduct extends AstFunc {
    private final AstFunc fn;

    public AstOuterproduct(AstFunc fn) {
        this.fn = fn;
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }

    @Override
    public String toString() {
        return "(o." + fn.toString() + ")";
    }
}
