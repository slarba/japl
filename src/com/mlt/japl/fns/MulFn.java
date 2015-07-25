package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;


public class MulFn extends PrimitiveBaseFn {

	@Override
	public long I_I(long a) {
		return Long.signum(a);
	}

	@Override
	public long I_D(double a) {
		return (long)Math.signum(a);
	}
	
	@Override
	public double D_DD(double a, double b) {
		return a*b;
	}

	@Override
	public double D_DI(double a, long b) {
		return a*b;
	}

	@Override
	public double D_ID(long a, double b) {
		return a*b;
	}

	@Override
	public long I_II(long a, long b) {
		return a*b;
	}
	
	@Override
	public String getName() {
		return "*";
	}

}
