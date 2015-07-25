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
	public Array createResultArrayFor(Array a, int axis) {
		if(a.isScalar()) return a.unInitializedCopy();
		if(a.type()==Array.NESTED) return a.unInitializedCopy();
		return new IntArray(a.dims(), new long[a.actualLength()]);
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		return ResultArrayUtil.precisionMaintainingFn(a,b,axis);
	}

	@Override
	public String getName() {
		return "abs";
	}

}
