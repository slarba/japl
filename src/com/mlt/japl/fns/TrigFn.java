package com.mlt.japl.fns;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.generated.LazyDoubleArray;
import com.mlt.japl.arrays.interf.*;

public class TrigFn extends BaseFn {

    public TrigFn(int axis) {
        super(axis);

    }

    private static double trig(int a, double b) {
        switch (a) {
            case -7:
                return 0.5 * Math.log((b + 1.0) / (b - 1.0));
            case -6:
                return Math.log(b + Math.sqrt(b * b - 1.0));
            case -5:
                return Math.log(b + Math.sqrt(b * b + 1.0));
            case -4:
                return Math.sqrt(b * 2 - 1);
            case -3:
                return Math.atan(b);
            case -2:
                return Math.acos(b);
            case -1:
                return Math.asin(b);
            case 0:
                return Math.sqrt(1 - (b * 2));
            case 1:
                return Math.sin(b);
            case 2:
                return Math.cos(b);
            case 3:
                return Math.tan(b);
            case 4:
                return Math.sqrt((b * 2) + 1);
            case 5:
                return Math.sinh(b);
            case 6:
                return Math.cosh(b);
            case 7:
                return Math.tanh(b);
            default:
                throw new ValueError();
        }
    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return new DoubleScalar(Math.PI * a.get());
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return new DoubleScalar(Math.PI * a.get());
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.PI * a.get(index);
            }
        };
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.PI * a.get(index);
            }
        };
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.PI * a.get(index);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new DoubleScalar(trig((int) a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return trig((int) a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return trig((int) a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return trig((int) a.get(), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return trig((int) a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return trig((int) a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return trig((int) a.get(index), b.get(index));
            }
        };
    }

    @Override
    public String getName() {
        return "trig";
    }

}
