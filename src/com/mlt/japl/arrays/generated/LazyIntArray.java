package com.mlt.japl.arrays.generated;

import com.mlt.japl.arrays.ArrayBase;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public abstract class LazyIntArray extends ArrayBase implements IIntArray {

    public LazyIntArray(Dimensions dims) {
        super(dims);
    }

    @Override
    public IValue force() {
        long[] data = new long[dims().length()];
        for (int i = 0; i < data.length; i++) data[i] = get(i);
        return new IntArray(dims(), data);
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
    public String asString(PrintConfig config) {
        return config.print(this);
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(ArrayVisitor visitor, IValue b) {
        return visitor.visit_first(this, b);
    }

    @Override
    public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_monadic(ArrayVisitor visitor) {
        return visitor.visit_monadic(this);
    }

    @Override
    public IValue reshape(int[] newShape) {
        IIntArray self = this;
        return new LazyIntArray(new Dimensions(newShape)) {
            @Override
            public long get(int index) {
                return self.get(index % self.dims().length());
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof IArray) {
            if (!((IArray) o).dims().equals(dims()))
                return false;
        }
        if (o instanceof IIntArray) {
            IIntArray a = (IIntArray) o;
            for (int i = 0; i < a.length(); i++) {
                if (a.get(i) != get(i)) return false;
            }
            return true;
        }
        if (o instanceof IDoubleArray) {
            IDoubleArray a = (IDoubleArray) o;
            for (int i = 0; i < a.length(); i++) {
                if (a.get(i) != get(i)) return false;
            }
            return true;
        }
        if (o instanceof IBitArray) {
            IBitArray a = (IBitArray) o;
            for (int i = 0; i < a.length(); i++) {
                if (a.get(i) != get(i)) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        long prime = 17;
        long result = super.hashCode();
        for (int i = 0; i < length(); i++) {
            result = prime * result + Long.hashCode(get(i));
        }
        return (int) result;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return long[].class;
    }

    @Override
    public Object coerceToJavaObject() {
        return force().coerceToJavaObject();
    }
}
