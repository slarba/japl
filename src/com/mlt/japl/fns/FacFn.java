package com.mlt.japl.fns;

public class FacFn extends PrimitiveBaseFn {

	@Override
	public long I_I(long x) {
		long fact = 1;
		for(int i=1; i<=x; i++) {
			fact *= i;
		}
		return fact;
	}

	@Override
	public double D_D(double x) {
		return Math.exp(logGamma(x+1));
	}

    private static double logGamma(double x) 
    {
    	// Lanczos arviointi
	      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
	      double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
	                       + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
	                       +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
	      return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }

	@Override
	public double D_II(long y, long x) {
		return (double)I_I(x) / (I_I(y)*I_I(x-y));
	}

	@Override
	public String getName() {
		return "fac";
	}

}
