package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.BitArray;
import com.mlt.japl.arrays.concrete.CharScalar;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.generated.LazyDoubleArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.arrays.interf.*;

public class EqFn extends BaseFn {
    public EqFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new IntScalar(a.get() == b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        return new IntScalar(a.get() == b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        return new IntScalar(a.get() == b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        return new IntScalar(a.get() == b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b) {
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharScalar b) {
        return new IntScalar(0);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IIntScalar b) {
        return new BitArray(1, a.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IIntArray b) {
        checkLengths(a, b);
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IBitArray b) {
        checkLengths(a, b);
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntScalar b) {
        return new IntScalar(0);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntArray b) {
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IBitArray b) {
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IDoubleArray b) {
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharScalar b) {
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharScalar b) {
        return new BitArray(1, b.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, ICharScalar b) {
        return new BitArray(1, a.dims(), new long[]{0});
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        return new IntScalar(a.get() == b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index).equals(b.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) == b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new IntScalar(a.get(index)), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), new DoubleScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new DoubleScalar(a.get(index)), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new CharScalar(a.get(index)), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, ICharArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), new CharScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue applyMonadic(IValue a) {
        throw new ValenceError();
    }

    @Override
    public IValue reduce(IIntArray a, int axis) {
        IntReducer reducer = new IntReducer(1, a, axis) {
            @Override
            public long op(long a, long b) {
                return a == b ? 1 : 0;
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

    // reduce for = ?
    @Override
    public IValue reduce(IBitArray a, int axis) {
        BitReducer reducer = new BitReducer(a, axis) {
            @Override
            public long op(long a, long b) {
                return a == b ? 1 : 0;
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
                return a == b ? 1 : 0;
            }
        };
        if (a.rank() == 1) return new DoubleScalar(reducer.rank1case());
        return new LazyDoubleArray(a.dims().elideAxis(axis)) {
            @Override
            public double get(int index) {
                return reducer.get(index);
            }
        };
    }

    @Override
    public String getName() {
        return "=";
    }
}
