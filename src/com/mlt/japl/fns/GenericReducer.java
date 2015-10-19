package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;

public class GenericReducer {
    private IValue array;
    private int axis;
    private int mspan;
    private int[] spans;
    private Func fn;

    public GenericReducer(IValue array, Func fn, int axis) {
        this.fn = fn;
        this.array = array;
        this.axis = axis;
        spans = array.dims().spans();
        for (int i = 0; i < spans.length; i++) {
            if (i == axis) continue;
            mspan += spans[i];
        }
    }

    public IValue rank1case() {
        int i = array.length() - 1;
        IValue result = array.getGeneric(i);
        for (i = array.length() - 2; i >= 0; i--)
            result = fn.applyDyadic(array.getGeneric(i), result);
        return result;
    }

    public IValue get(int index) {
        int i = array.dims().axis(axis) - 1;
        IValue result = array.getGeneric(index * mspan + i * spans[axis]);
        for (i = array.dims().axis(axis) - 2; i >= 0; i--)
            result = fn.applyDyadic(array.getGeneric(index * mspan + i * spans[axis]), result);
        return result;
    }
};
