package com.mlt.japl.fns;

public class LogFn extends PrimitiveBaseFn {

	@Override
	public double D_I(long x) {
		return Math.log(x);
	}

	@Override
	public double D_D(double x) {
		return Math.log(x);
	}

	@Override
	public double D_II(long x, long y) {
		return Math.log(y) / Math.log(x);
	}
	
	@Override
	public double D_DI(double x, long y) {
		return Math.log(y) / Math.log(x);
	}
	
	@Override
	public double D_ID(long x, double y) {
		return Math.log(y) / Math.log(x);
	}
	
	@Override
	public String getName() {
		return "log";
	}

}
