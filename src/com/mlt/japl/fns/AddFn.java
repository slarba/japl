package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;

public class AddFn extends PrecisionMaintainingFn {
	
	@Override
	public double D_DD(double a, double b) {
		return a+b;
	}

	@Override
	public double D_DI(double a, long b) {
		return a+b;
	}

	@Override
	public double D_ID(long a, double b) {
		return a+b;
	}

	@Override
	public long I_II(long a, long b) {
		return a+b;
	}

	@Override
	public Array monadic(Array a, int axis) {
		return a;
	}
}
