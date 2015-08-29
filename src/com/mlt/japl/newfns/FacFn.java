package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class FacFn extends BaseFn {

    private static double logGamma(double x) 
    {
    	// Lanczos arviointi
	      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
	      double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
	                       + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
	                       +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
	      return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }

    private static long factorial(long x) {
		long fact = 1;
		for(int i=1; i<=x; i++) {
			fact *= i;
		}
		return fact;
    }
    
    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
		return new IntScalar(factorial(a.get()));
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a, int axis) {
    	return new DoubleScalar(Math.exp(logGamma(a.get()+1)));
    }

    @Override
    public IValue visit_monadic(IIntArray a, int axis) {
    	return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return factorial(a.get(index));
			}
    	};
    }

    @Override
    public IValue visit_monadic(IDoubleArray a, int axis) {
    	return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.exp(logGamma(a.get(index)+1));
			}
    	};
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
    	return new DoubleScalar((double)factorial(a.get()) / (factorial(b.get())*factorial(a.get()-b.get())));
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
    	return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
		    	return (double)factorial(a.get(index)) / (factorial(b.get(index))*factorial(a.get(index)-b.get(index)));
			}
    	};
    }
}
