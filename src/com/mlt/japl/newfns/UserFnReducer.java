package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;

public abstract class UserFnReducer {
    private IValue array;
    private int axis;
    private int mspan;
    private int[] spans;

    public UserFnReducer(IValue array, int axis) {
        this.array = array;
        this.axis = axis;
        spans = array.dims().spans();
        for (int i = 0; i < spans.length; i++) {
            if (i == axis) continue;
            mspan += spans[i];
        }
    }

    public IValue rank1case() {
        IValue result = array.getGeneric(array.length() - 1);
        for (int i = array.length() - 2; i >= 0; i--)
            result = op(array.getGeneric(i), result);
        return result;
    }

    public IValue get(int index) {
        IValue result = array.getGeneric(array.dims().axis(axis) - 1);
        for (int i = array.dims().axis(axis) - 2; i >= 0; i--)
            result = op(array.getGeneric(index * mspan + i * spans[axis]), result);
        return result;
    }

    public abstract IValue op(IValue a, IValue b);
};
