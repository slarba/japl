package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayBase;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

import java.util.Arrays;

public class DoubleArray extends ArrayBase implements IDoubleArray {
    double[] data;

    public DoubleArray(Dimensions dims, double[] data) {
        super(dims);
        this.data = data;
    }

    @Override
    public double get(int index) {
        return data[index % data.length];
    }

    @Override
    public IValue getGeneric(int index) {
        return new DoubleScalar(get(index));
    }


    @Override
    public IValue get(IMixedArray i) {
        Indexer indexer = new Indexer(i, this);
        int[] finalDims = indexer.computeResultDims();
        if (finalDims.length == 0) return new DoubleScalar(get(indexer.indexForSingle()));
        Dimensions ds = new Dimensions(finalDims);
        double[] result = new double[ds.length()];

        for (int j = 0; j < result.length; j++) {
            result[j] = get(indexer.step());
        }
        return new DoubleArray(ds, result);
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
        DoubleArray other = (DoubleArray) obj;
        if (!Arrays.equals(data, other.data))
            return false;
        return true;
    }

    @Override
    public IValue reshape(int[] newShape) {
        Dimensions newDims = new Dimensions(newShape);
        double[] newData = new double[newDims.length()];
        for(int i=0; i<newData.length; i++) {
            newData[i] = get(i);
        }
        return new DoubleArray(newDims, newData);
    }

    @Override
    public String asString(PrintConfig config) {
        return config.print(this);
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return double[].class;
    }

    @Override
    public Object coerceToJavaObject() {
        return data;
    }

    public double[] data() {
        return data;
    }

}
