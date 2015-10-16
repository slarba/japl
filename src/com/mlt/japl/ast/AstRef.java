package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstRef implements AstNode {

    private String id;
    private String namespace;

    public AstRef(String text) {
        this.id = text;
    }

    public AstRef(String text, String namespace) {
        this(text);
        this.namespace = namespace;
    }

    @Override
    public String toString() {
        return "@" + (namespace!=null ? namespace : "#.") + id;

    }

    public String getId() {
        return id;
    }

    @Override
    public IValue eval(EvalContext context) {
        return context.get(id).get();
    }
}
