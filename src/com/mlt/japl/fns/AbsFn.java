package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.ResultArrayUtil;

public class AbsFn extends PrimitiveBaseFn {

	@Override
	public long I_I(long d) {
		return Math.abs(d);
	}

	@Override
	public long I_II(long a, long b) {
		return b%a;
	}

	@Override
	public double D_D(double d) {
		return Math.abs(d);
	}
	
	@Override
	public double D_DD(double a, double b) {
		return b%a;
	}

	@Override
	public double D_ID(long a, double b) {
		return b%a;
	}

	@Override
	public double D_DI(double a, long b) {
		return b%a;
	}
	
	@Override
	public String getName() {
		return "abs";
	}

}
