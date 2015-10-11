package com.mlt.japl.workspace;

import com.mlt.japl.arrays.IValue;

public class Var {
    private IValue value;

    public Var(IValue v) {
        value = v;
    }

    public Var() {

    }

    public IValue get() {
        return value;
    }

    public void set(IValue v) {
        value = v;
    }
}
