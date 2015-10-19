package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyDoubleArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.interf.*;

public class CeilFn extends BaseFn {
    public CeilFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new IntScalar(Math.max(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        return new DoubleScalar(Math.max(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        return new DoubleScalar(Math.max(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        return new DoubleScalar(Math.max(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return Math.max(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return Math.max(a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return Math.max(a.get(index), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(index), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.max(a.get(index), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.min(a.get(index), b.get());
            }
        };
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return a;
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return (long) Math.ceil(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return a;
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return new IntScalar((long) Math.ceil(a.get()));
    }

    @Override
    public IValue reduce(IIntArray a, int axis) {
        IntReducer reducer = new IntReducer(0, a, axis) {
            @Override
            public long op(long a, long b) {
                return Math.max(a, b);
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
        BitReducer reducer = new BitReducer(a, axis) {
            @Override
            public long op(long a, long b) {
                return Math.max(a, b);
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
    public IValue reduce(IDoubleArray a, int axis) {
        DoubleReducer reducer = new DoubleReducer(a, axis) {
            @Override
            public double op(double a, double b) {
                return Math.max(a, b);
            }
        };
        if (a.rank() == 1) return new DoubleScalar(reducer.rank1case());
        return new LazyDoubleArray(a.dims().elideAxis(CeilFn.this.axis)) {
            @Override
            public double get(int index) {
                return reducer.get(index);
            }
        };
    }


    @Override
    public String getName() {
        return "ceil";
    }
}
