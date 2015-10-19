package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharScalar;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.arrays.interf.*;

public class EachFn extends BaseFn {

    private Func fn;

    public EachFn(int axis, Func fn) {
        super(axis);
        this.fn = fn;
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyMonadic(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyMonadic(new IntScalar(a.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyMonadic(new DoubleScalar(a.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyMonadic(new CharScalar(a.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyMonadic(new IntScalar(a.get(index)));
            }
        }.force();
    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return fn.applyMonadic(a);
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return fn.applyMonadic(a);
    }

    @Override
    public IValue visit_monadic(ICharScalar a) {
        return fn.applyMonadic(a);
    }

    @Override
    public IValue visit_monadic(IMixedScalar a) {
        return fn.applyMonadic(a);
    }

    private IValue generic_each(IValue a, IValue b, int axis) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.getGeneric(index), b.getGeneric(index));
            }
        }.force();
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntArray b) {
        return generic_each(a, b, axis);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedArray b) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(index), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a, b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a, b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IMixedArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a, b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, ICharScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(index), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IDoubleScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(index), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IIntScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(index), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedArray b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new IntScalar(a.get(index)), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IIntArray b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(index), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new IntScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IIntArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new IntScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IBitArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(), new IntScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new DoubleScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new IntScalar(a.get(index)), b);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IDoubleArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(), new DoubleScalar(b.get(index)));
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IMixedScalar b) {
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(new CharScalar(a.get(index)), b.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, ICharArray b) {
        return new LazyMixedArray(b.dims()) {
            @Override
            public IValue get(int index) {
                return fn.applyDyadic(a.get(), new CharScalar(b.get(index)));
            }
        };
    }

    @Override
    public String getName() {
        return "each<" + fn.getName() + ">";
    }

}
