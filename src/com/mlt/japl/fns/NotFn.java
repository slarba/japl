package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class NotFn extends PrimitiveBaseFn {

	@Override
	public long I_I(long a) {
		return a^1;
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		throw new ValenceError();
	}

	@Override
	public Array monadic(Array a, int axis) {
		if(a instanceof BitArray) {
			return ((BitArray)a).not();
		}
		return super.monadic(a, axis);
	}
	
	@Override
	public String getName() {
		return "not";
	}

}
