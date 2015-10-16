package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstFuncRef extends AstFunc {

    private final String id;
    private String namespace;

    public AstFuncRef(String id) {
        this.id = id;
    }

    public AstFuncRef(String text, String namespace) {
        this(text);
        this.namespace = namespace;
    }

    @Override
    public IValue eval(EvalContext context) {
        return context.get(id).get();
    }

    @Override
    public String toString() {
        return "@" + (namespace!=null ? namespace : "") + id;

    }
}
