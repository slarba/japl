package com.mlt.japl.fns;

import com.mlt.japl.arrays.interf.IIntArray;

public abstract class IntReducer {
    private IIntArray array;
    private int axis;
    private int mspan;
    private int[] spans;

    public IntReducer(long initval, IIntArray array, int axis) {
        this.array = array;
        this.axis = axis;
        spans = array.dims().spans();
        for (int i = 0; i < spans.length; i++) {
            if (i == axis) continue;
            mspan += spans[i];
        }
    }

    public long rank1case() {
        int i = array.length() - 1;
        if(i<0) return 0;
        long result = array.get(i);
        for (i = array.length() - 2; i >= 0; i--)
            result = op(array.get(i), result);
        return result;
    }

    public long get(int index) {
        int i = array.dims().axis(axis) - 1;
        long result = array.get(index * mspan + i * spans[axis]);
        for (i = array.dims().axis(axis) - 2; i >= 0; i--)
            result = op(array.get(index * mspan + i * spans[axis]), result);
        return result;
    }

    public abstract long op(long a, long b);
};
