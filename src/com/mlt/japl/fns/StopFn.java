package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class StopFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		return new IntArray();
	}
	
	@Override
	public Array dyadic(Array a, Array b, int axis) {
		return a;
	}
	
	@Override
	public String getName() {
		return "stop";
	}

	@Override
	public int resultTypeFor(Array a) {
		return Array.INTEGER;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return a.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return Dimensions.EMPTY_ARRAY;
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return a.dims();
	}

}
