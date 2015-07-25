package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.ResultArrayUtil;

public class FloorFn extends PrimitiveBaseFn {

	@Override
	public long I_D(double d) {
		return (long)Math.floor(d);
	}

	@Override
	public long I_I(long d) {
		return d;
	}

	@Override
	public long I_II(long a, long b) {
		return Math.min(a, b);
	}

	@Override
	public double D_DD(double a, double b) {
		return Math.min(a, b);
	}

	@Override
	public double D_ID(long a, double b) {
		return Math.min(a, b);
	}

	@Override
	public double D_DI(double a, long b) {
		return Math.min(a, b);
	}

	@Override
	public int resultTypeFor(Array a) {
		if(a.type()==Array.NESTED) return Array.NESTED;
		return Array.INTEGER;
	}
	
	@Override
	public String getName() {
		return "floor";
	}

}
