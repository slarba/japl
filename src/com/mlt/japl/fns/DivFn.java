package com.mlt.japl.fns;


public class DivFn extends PrecisionIncreasingFn {


	@Override
	public double D_D(double d) {
		return 1.0/d;
	}

	@Override
	public double D_I(long d) {
		return 1.0/d;
	}

	@Override
	public double D_DD(double a, double b) {
		return a/b;
	}

	@Override
	public double D_DI(double a, long b) {
		return a/(double)b;
	}

	@Override
	public double D_ID(long a, double b) {
		return ((double)a)/b;
	}

	@Override
	public double D_II(long a, long b) {
		return ((double)a)/b;
	}


}
