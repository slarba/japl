package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;

public abstract class SpecialBaseFn implements Func {

	@Override
	public Array monadic(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		throw new ValenceError();
	}

}
