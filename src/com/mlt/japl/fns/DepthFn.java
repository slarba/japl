package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class DepthFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		return new IntScalar(a.depth());
	}

	@Override
	public String getName() {
		return "depth";
	}
	
	@Override
	public int resultTypeFor(Array a) {
		return Array.INTEGER;
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}

}
