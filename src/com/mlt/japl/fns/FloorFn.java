package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
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
	public Array createResultArrayFor(Array a, int axis) {
		if(a.type()==Array.MIXED) return a.unInitializedCopy();
		return new IntArray(a.dims(), new long[a.actualLength()]);
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		return ResultArrayUtil.precisionMaintainingFn(a,b,axis);
	}

	@Override
	public String getName() {
		return "floor";
	}

}
