package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharScalar;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.arrays.interf.*;

public class OuterProdFn extends BaseFn {

    private Func fn;

    public OuterProdFn(Func fn) {
        this.fn = fn;
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, ICharScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IDoubleScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IMixedScalar b) {
        return fn.applyDyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b) {
        return fn.outerprod(a, b);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IIntArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(a.get(idx), new IntScalar(b.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IDoubleArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(a.get(idx), new DoubleScalar(b.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IBitArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(a.get(idx), new IntScalar(b.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, ICharArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(a.get(idx), new CharScalar(b.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(a.get(idx), b.get(index));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(new IntScalar(a.get(idx)), b.get(index));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new IntScalar(a.get(index)), b.get());
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IMixedArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(new DoubleScalar(a.get(idx)), b.get(index));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IMixedArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(new CharScalar(a.get(idx)), b.get(index));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IMixedArray b) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return fn.applyDyadic(new IntScalar(a.get(idx)), b.get(index));
            }
        }.force();
    }

    @Override
    public String getName() {
        return "outerprod<" + fn.getName() + ">";
    }

}
