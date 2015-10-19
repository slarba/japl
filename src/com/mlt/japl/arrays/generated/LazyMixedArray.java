package com.mlt.japl.arrays.generated;

import com.mlt.japl.arrays.ArrayBase;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.*;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public abstract class LazyMixedArray extends ArrayBase implements IMixedArray {

    public LazyMixedArray(Dimensions dims) {
        super(dims);
    }

    public IValue prototype() {
        if(dims().length()>0)
            return get(0).prototype();
        return MixedArray.EMPTY;
    }

    @Override
    public IValue get(IMixedArray i) {
        Indexer indexer = new Indexer(i, this);
        int[] finalDims = indexer.computeResultDims();
        if (finalDims.length == 0) return get(indexer.indexForSingle());
        Dimensions ds = new Dimensions(finalDims);
        IValue[] result = new IValue[ds.length()];

        for (int j = 0; j < result.length; j++) {
            result[j] = get(indexer.step());
        }
        return new MixedArray(ds, result);
    }

    @Override
    public IValue getGeneric(int index) {
        return get(index);
    }

    @Override
    public IValue force() {
        int ints = 0;
        int doubles = 0;
        int chars = 0;
        int ones = 0;
        int zeros = 0;
        IValue[] data = new IValue[dims().length()];
        for (int i = 0; i < data.length; i++) {
            IValue d = get(i);
            if (d instanceof IIntScalar) {
                ints++;
                IIntScalar x = (IIntScalar) d;
                if (x.get() == 1) ones++;
                else if (x.get() == 0) zeros++;
            } else if (d instanceof IDoubleScalar) doubles++;
            else if (d instanceof ICharScalar) chars++;
            data[i] = get(i);
        }
        if (data.length == ints) {
            if (ones + zeros == ints) {
                BitArray b = new BitArray(dims());
                for (int i = 0; i < b.length(); i++) {
                    b.setBit(i, ((IIntScalar) data[i]).get());
                }
                return b;
            }
            long[] result = new long[ints];
            for (int i = 0; i < ints; i++) {
                result[i] = ((IIntScalar) data[i]).get();
            }
            return new IntArray(dims(), result);
        }
        if (data.length == ints+doubles) {
            double[] result = new double[ints+doubles];
            for (int i = 0; i < doubles+ints; i++) {
                if(data[i] instanceof IDoubleScalar)
                    result[i] = ((IDoubleScalar) data[i]).get();
                else
                    result[i] = ((IIntScalar) data[i]).get();
            }
            return new DoubleArray(dims(), result);
        }
        if (data.length == chars) {
            char[] result = new char[chars];
            for (int i = 0; i < chars; i++) {
                result[i] = ((ICharScalar) data[i]).get();
            }
            return new CharArray(dims(), result);
        }
        return new MixedArray(dims(), data);
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
    public String asString(PrintConfig config) {
        return config.print(this);
    }

    @Override
    public IValue reshape(int[] newShape) {
        IMixedArray self = this;
        return new LazyMixedArray(new Dimensions(newShape)) {
            @Override
            public IValue get(int index) {
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
        if (o instanceof IMixedArray) {
            IMixedArray a = (IMixedArray) o;
            for (int i = 0; i < a.length(); i++) {
                if (!a.get(i).equals(get(i))) return false;
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
            result = prime * result + get(i).hashCode();
        }
        return (int) result;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return Object.class;
    }

    @Override
    public Object coerceToJavaObject() {
        return force().coerceToJavaObject();
    }
}
