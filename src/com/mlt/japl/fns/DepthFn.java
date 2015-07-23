package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class DepthFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		return new IntScalar(a.depth());
	}
}
