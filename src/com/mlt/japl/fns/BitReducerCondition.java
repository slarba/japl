package com.mlt.japl.fns;

import com.mlt.japl.arrays.interf.IBitArray;

public abstract class BitReducerCondition {
    private IBitArray array;
    private int axis;
    private long initval;
    private int mspan;
    private int[] spans;
    private long condition;

    public BitReducerCondition(long initval, long condition, IBitArray array, int axis) {
        this.array = array;
        this.axis = axis;
        this.initval = initval;
        this.condition = condition;
        spans = array.dims().spans();
        for (int i = 0; i < spans.length; i++) {
            if (i == axis) continue;
            mspan += spans[i];
        }
    }

    public long rank1case() {
        long result = initval;
        for (int i = array.length() - 1; i >= 0; i--) {
            result = op(array.get(i), result);
            if (result == condition) break;
        }
        return result;
    }

    public long get(int index) {
        long result = initval;
        for (int i = array.dims().axis(axis) - 1; i >= 0; i--) {
            result = op(array.get(index * mspan + i * spans[axis]), result);
            if (result == condition) break;
        }
        return result;
    }

    public abstract long op(long a, long b);
};
