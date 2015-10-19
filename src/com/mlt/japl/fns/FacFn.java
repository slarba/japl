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

public class FacFn extends BaseFn {

    public FacFn(int axis) {
        super(axis);

    }

    private static double logGamma(double x) {
        // Lanczos arviointi
        double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
        double ser = 1.0 + 76.18009173 / (x + 0) - 86.50532033 / (x + 1)
                + 24.01409822 / (x + 2) - 1.231739516 / (x + 3)
                + 0.00120858003 / (x + 4) - 0.00000536382 / (x + 5);
        return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }

    private static long factorial(long x) {
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return new IntScalar(factorial(a.get()));
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return new DoubleScalar(Math.exp(logGamma(a.get() + 1)));
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return factorial(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.exp(logGamma(a.get(index) + 1));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new IntScalar(factorial(b.get()) / (factorial(a.get()) * factorial(b.get() - a.get())));
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return factorial(b.get(index)) / (factorial(a.get(index)) * factorial(b.get(index) - a.get(index)));
            }
        };
    }

    @Override
    public String getName() {
        return "fac";
    }

}
