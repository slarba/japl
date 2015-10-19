package com.mlt.japl.arrays.generated;

import com.mlt.japl.arrays.ArrayBase;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.concrete.CharScalar;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public abstract class LazyCharArray extends ArrayBase implements ICharArray {

    public LazyCharArray(Dimensions dims) {
        super(dims);
    }

    @Override
    public IValue force() {
        char[] data = new char[dims().length()];
        for (int i = 0; i < data.length; i++) data[i] = get(i);
        return new CharArray(dims(), data);
    }

    @Override
    public IValue get(IMixedArray i) {
        Indexer indexer = new Indexer(i, this);
        int[] finalDims = indexer.computeResultDims();
        if (finalDims.length == 0) return new CharScalar(get(indexer.indexForSingle()));
        Dimensions ds = new Dimensions(finalDims);
        char[] result = new char[ds.length()];

        for (int j = 0; j < result.length; j++) {
            result[j] = get(indexer.step());
        }
        return new CharArray(ds, result);
    }

    @Override
    public IValue getGeneric(int index) {
        return new CharScalar(get(index));
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
        ICharArray self = this;
        return new LazyCharArray(new Dimensions(newShape)) {
            @Override
            public char get(int index) {
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
            ICharArray a = (ICharArray) o;
            for (int i = 0; i < a.length(); i++) {
                if (a.get(i) != get(i)) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int result = super.hashCode();
        for (int i = 0; i < length(); i++) {
            result = prime * result + Character.hashCode(get(i));
        }
        return result;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return String.class;
    }

    @Override
    public Object coerceToJavaObject() {
        return force().coerceToJavaObject();
    }
}
