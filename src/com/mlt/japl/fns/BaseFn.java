package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharScalar;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.concrete.MixedScalar;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;

public class BaseFn implements ArrayVisitor, Func {
    protected int axis;

    public BaseFn() {
        axis = -1;
    }

    public BaseFn(int axis) {
        this.axis = axis;
    }

    @Override
    public IValue visit_first(IBitArray a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(IIntArray a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(IDoubleArray a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(ICharArray a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(IMixedArray a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(IIntScalar a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(IDoubleScalar a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(ICharScalar a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    @Override
    public IValue visit_first(IMixedScalar a, IValue b) {
        return b.accept_dyadic(a, this);
    }

    // ----------
    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IMixedScalar b) {
        return new MixedScalar(applyDyadic(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharArray b) {
        return generic_dyadic(a, b);
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
    public IValue visit_dyadic(IIntArray a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new IntScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, ICharArray b) {
        return generic_dyadic(a, b);
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
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new DoubleScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IDoubleArray b) {
        return generic_dyadic(a, b);
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
    public IValue visit_dyadic(ICharArray a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new CharScalar(a.get(index)), b.get());
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
    public IValue visit_dyadic(IMixedArray a, IIntScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IDoubleScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, ICharScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(a, b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IMixedScalar b) {
        return new MixedScalar(visit_first(a, b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, ICharArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(a, b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IMixedScalar b) {
        return new MixedScalar(visit_first(a, b.get()));
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IDoubleArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(a, b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IMixedScalar b) {
        return new MixedScalar(visit_first(a, b.get()));
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IIntArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IDoubleArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(), new DoubleScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, ICharArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(), new CharScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IIntScalar b) {
        return new MixedScalar(applyDyadic(a.get(), b));
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IDoubleScalar b) {
        return new MixedScalar(applyDyadic(a.get(), b));
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, ICharScalar b) {
        return new MixedScalar(applyDyadic(a.get(), b));
    }

    public IValue generic_monadic(IValue a) {
        throw new DomainError();
    }

    public IValue generic_dyadic(IValue a, IValue b) {
        throw new DomainError();
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        final ArrayVisitor self = this;
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return a.get(index).accept_monadic(self);
            }
        };
    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_monadic(ICharScalar a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_monadic(IMixedScalar a) {
        return new MixedScalar(a.get().accept_monadic(this));
    }

    @Override
    public IValue applyDyadic(IValue a, IValue b) {
        return a.accept_dyadic(this, b);
    }

    @Override
    public IValue applyMonadic(IValue a) {
        return a.accept_monadic(this);
    }

    public void checkLengths(IValue a, IValue b) {
        if (a.dims().rank() != b.dims().rank()) throw new RankError();
        if (!a.dims().equals(b.dims())) throw new LengthError();
    }

    @Override
    public IValue applyNiladic() {
        throw new ValenceError();
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(index), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharScalar b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new IntScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IBitArray b) {
        return generic_dyadic(a, b);
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IBitArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return applyDyadic(a.get(), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        return generic_monadic(a);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new IntScalar(a.get(index)), b.get(index));
            }
        };
    }

    @Override
    public String getName() {
        return "<func>";
    }

    private IValue genericReducer(IValue a, int axis) {
        GenericReducer reducer = new GenericReducer(a, this, axis);
        if (a.rank() == 1) return reducer.rank1case();
        return new LazyMixedArray(a.dims().elideAxis(axis)) {
            @Override
            public IValue get(int index) {
                return reducer.get(index);
            }
        };
    }

    @Override
    public IValue reduce(IIntArray a, int axis) {
        return genericReducer(a, this.axis);
    }

    @Override
    public IValue reduce(IDoubleArray a, int axis) {
        return genericReducer(a, this.axis);
    }

    @Override
    public IValue reduce(ICharArray a, int axis) {
        return genericReducer(a, this.axis);
    }

    @Override
    public IValue reduce(IMixedArray a, int axis) {
        return genericReducer(a, this.axis);
    }

    @Override
    public IValue reduce(IBitArray a, int axis) {
        return genericReducer(a, this.axis);
    }

    private IValue genericOuterProd(IValue a, IValue b, int axis) {
        return new LazyMixedArray(outerProdDims(a, b, axis)) {
            @Override
            public IValue get(int index) {
                int idx = index / a.length();
                return applyDyadic(a.getGeneric(idx), b.getGeneric(index));
            }
        }.force();
    }

    @Override
    public IValue outerprod(IIntArray a, IIntArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IDoubleArray a, IDoubleArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IBitArray a, IBitArray b) {
        return genericOuterProd(a, b, axis);
    }

    protected Dimensions outerProdDims(IValue a, IValue b, int axis) {
        return a.dims().concat(b.dims());
    }

    @Override
    public IValue outerprod(IIntArray a, IDoubleArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IIntArray a, IBitArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IDoubleArray a, IIntArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IDoubleArray a, IBitArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IBitArray a, IIntArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IBitArray a, IDoubleArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IIntArray a, ICharArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IIntArray a, IMixedArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IDoubleArray a, ICharArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IDoubleArray a, IMixedArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IBitArray a, ICharArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IBitArray a, IMixedArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(ICharArray a, IIntArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(ICharArray a, IDoubleArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(ICharArray a, IBitArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(ICharArray a, IMixedArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(ICharArray a, ICharArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IMixedArray a, IIntArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IMixedArray a, IDoubleArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IMixedArray a, IBitArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IMixedArray a, ICharArray b) {
        return genericOuterProd(a, b, axis);
    }

    @Override
    public IValue outerprod(IMixedArray a, IMixedArray b) {
        return genericOuterProd(a, b, axis);
    }
}
