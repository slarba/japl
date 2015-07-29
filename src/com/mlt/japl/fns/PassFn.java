package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class PassFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		return a;
	}
	
	@Override
	public Array dyadic(Array a, Array b, int axis) {
		return b;
	}
	
	@Override
	public String getName() {
		return "pass";
	}

	@Override
	public int resultTypeFor(Array a) {
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return a.dims();
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return b.dims();
	}

}
