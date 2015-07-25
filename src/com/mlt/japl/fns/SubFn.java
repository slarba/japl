package com.mlt.japl.fns;

public class SubFn extends PrimitiveBaseFn {

	@Override
	public long I_I(long a) {
		return -a;
	}
	
	@Override
	public double D_D(double a) {
		return -a;
	}
	
	@Override
	public double D_DD(double a, double b) {
		return a-b;
	}

	@Override
	public double D_DI(double a, long b) {
		return a-b;
	}

	@Override
	public double D_ID(long a, double b) {
		return a-b;
	}

	@Override
	public double D_II(long a, long b) {
		return a-b;
	}

	@Override
	public long I_II(long a, long b) {
		return a-b;
	}

	@Override
	public String getName() {
		return "-";
	}

}
