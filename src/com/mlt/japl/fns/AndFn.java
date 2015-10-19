package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.ConstBitArray;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.interf.IBitArray;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.arrays.interf.IIntScalar;

public class AndFn extends BaseFn {
    public AndFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new IntScalar(a.get() & b.get());
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) & b.get(index);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) & b.get(index);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) & b.get(index);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) & b.get(index);
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() & b.get(index);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) & b.get();
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() & b.get(index);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b) {
        if (b.get() == 1) return a;
        if (b.get() == 0) return new ConstBitArray(a.dims(), 0);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) & b.get();
            }
        };
    }

    @Override
    public IValue reduce(IIntArray a, int axis) {
        IntReducer reducer = new IntReducer(-1, a, axis) {
            @Override
            public long op(long a, long b) {
                return a & b;
            }
        };
        if (a.rank() == 1) return new IntScalar(reducer.rank1case());
        return new LazyIntArray(a.dims().elideAxis(axis)) {
            @Override
            public long get(int index) {
                return reducer.get(index);
            }
        };
    }

    @Override
    public IValue reduce(IBitArray a, int axis) {
        BitReducerCondition reducer = new BitReducerCondition(1, 0, a, axis) {
            @Override
            public long op(long a, long b) {
                return a & b;
            }
        };
        if (a.rank() == 1) return new IntScalar(reducer.rank1case());
        return new LazyBitArray(a.dims().elideAxis(axis)) {
            @Override
            public long get(int index) {
                return reducer.get(index);
            }
        };
    }

    @Override
    public IValue outerprod(IIntArray a, IIntArray b) {
        return new LazyIntArray(outerProdDims(a, b, axis)) {
            @Override
            public long get(int index) {
                int idx = index / a.length();
                return a.get(idx) & b.get(index);
            }
        };
    }

    @Override
    public IValue outerprod(IIntArray a, IBitArray b) {
        return new LazyIntArray(outerProdDims(a, b, axis)) {
            @Override
            public long get(int index) {
                int idx = index / a.length();
                return a.get(idx) & b.get(index);
            }
        };
    }

    @Override
    public IValue outerprod(IBitArray a, IBitArray b) {
        return new LazyBitArray(outerProdDims(a, b, axis)) {
            @Override
            public long get(int index) {
                int idx = index / a.length();
                return a.get(idx) & b.get(index);
            }
        };
    }

    @Override
    public IValue outerprod(IBitArray a, IIntArray b) {
        return new LazyIntArray(outerProdDims(a, b, axis)) {
            @Override
            public long get(int index) {
                int idx = index / a.length();
                return a.get(idx) & b.get(index);
            }
        };
    }

    @Override
    public IValue applyMonadic(IValue a) {
        throw new ValenceError();
    }

    @Override
    public String getName() {
        return "and";
    }
}
