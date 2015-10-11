package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayBase;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

import java.util.Arrays;

public class IntArray extends ArrayBase implements IIntArray {
    public static final IValue EMPTY = new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);

    long[] data;

    public IntArray(Dimensions dims, long[] data) {
        super(dims);
        this.data = data;
    }

    @Override
    public IValue get(IMixedArray i) {
        Indexer indexer = new Indexer(i, this);
        int[] finalDims = indexer.computeResultDims();
        if (finalDims.length == 0) return new IntScalar(get(indexer.indexForSingle()));
        Dimensions ds = new Dimensions(finalDims);
        long[] result = new long[ds.length()];

        for (int j = 0; j < result.length; j++) {
            result[j] = get(indexer.step());
        }
        return new IntArray(ds, result);
    }

    @Override
    public IValue getGeneric(int index) {
        return new IntScalar(get(index));
    }

    @Override
    public long get(int index) {
        return data[index % data.length];
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(ArrayVisitor visitor, IValue b, int axis) {
        return visitor.visit_first(this, b, axis);
    }

    @Override
    public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_monadic(ArrayVisitor visitor, int axis) {
        return visitor.visit_monadic(this, axis);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        IntArray other = (IntArray) obj;
        if (!Arrays.equals(data, other.data))
            return false;
        return true;
    }

    @Override
    public String asString(PrintConfig config) {
        return config.print(this);
    }

    public long[] data() {
        return data;
    }

    @Override
    public IValue reshape(int[] newShape) {
        return new IntArray(new Dimensions(newShape), data);
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return long[].class;
    }

    @Override
    public Object coerceToJavaObject() {
        return data;
    }

}