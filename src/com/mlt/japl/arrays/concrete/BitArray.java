package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayBase;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

import java.util.Arrays;

public class BitArray extends ArrayBase implements IBitArray {
    long[] data;
    int actualLength;

    public BitArray(Dimensions dims) {
        super(dims);
        actualLength = dims.length();
        int whole = dims.length() / 64;
        int part = dims.length() % 64;
        this.data = new long[(part > 0 ? 1 : 0) + whole];
    }

    public BitArray(int actualLength, Dimensions dims, long[] data) {
        super(dims);
        this.actualLength = actualLength;
        this.data = data;
    }

    @Override
    public IValue get(IMixedArray i) {
        Indexer indexer = new Indexer(i, this);
        int[] finalDims = indexer.computeResultDims();
        if (finalDims.length == 0) return new IntScalar(get(indexer.indexForSingle()));
        Dimensions ds = new Dimensions(finalDims);

        BitArray rs = new BitArray(ds);
        for (int j = 0; j < ds.length(); j++) {
            rs.setBit(j, get(indexer.step()));
        }
        return rs;
    }

    @Override
    public IValue getGeneric(int index) {
        return new IntScalar(get(index));
    }

    @Override
    public long get(int idx) {
        int i = idx % actualLength;
        int whole = i / 64;
        int part = i % 64;
        return (data[whole] >>> part) & 1;
    }

    @Override
    public long getBits(int index) {
        return data[index % data.length];
    }

    public void setBit(int idx, long val) {
        int i = idx % actualLength;
        int whole = i / 64;
        int part = i % 64;
        data[whole] |= val << part;
    }

    // region Kuvaus
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
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
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
    // endregion

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String asString(PrintConfig config) {
        return config.print(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        BitArray other = (BitArray) obj;
        if (!Arrays.equals(data, other.data))
            return false;
        return true;
    }

    @Override
    public IValue reshape(int[] newShape) {
        Dimensions newDims = new Dimensions(newShape);
        BitArray a = new BitArray(newDims);
        for(int i=0; i<newDims.length(); i++) {
            a.setBit(i, get(i));
        }
        return a;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return boolean[].class;
    }

    @Override
    public Object coerceToJavaObject() {
        boolean[] a = new boolean[length()];
        for (int i = 0; i < length(); i++) {
            a[i] = get(i) == 1 ? true : false;
        }
        return a;
    }
}
