package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyDoubleArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.interf.IDoubleArray;
import com.mlt.japl.arrays.interf.IDoubleScalar;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.arrays.interf.IIntScalar;

public class ExpFn extends BaseFn {
    public ExpFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return new DoubleScalar(Math.exp(a.get()));
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return new DoubleScalar(Math.exp(a.get()));
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.exp(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.exp(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return (long) Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new IntScalar((long) Math.pow(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        return new DoubleScalar(Math.pow(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        return new DoubleScalar(Math.pow(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        return new DoubleScalar(Math.pow(a.get(), b.get()));
    }

    @Override
    public String getName() {
        return "exp";
    }

}
