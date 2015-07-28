package com.mlt.japl.fns;

public class ExpFn extends PrimitiveBaseFn {

	@Override
	public double D_I(long x) {
		return Math.exp(x);
	}

	@Override
	public double D_D(double x) {
		return Math.exp(x);
	}

	@Override
	public long I_II(long x, long y) {
		return (long)Math.pow(x, y);
	}

	@Override
	public double D_DI(double x, long y) {
		return Math.pow(x, y);
	}
	
	@Override
	public double D_ID(long x, double y) {
		return Math.pow(x, y);
	}
	
	@Override
	public String getName() {
		return "exp";
	}

}
