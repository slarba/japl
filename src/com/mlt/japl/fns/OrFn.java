package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;

public class OrFn extends PrimitiveBaseFn {

	@Override
	public long I_II(long a, long b) {
		return a|b;
	}

	@Override
	public Array monadic(Array a, int axis) {
		// logical functions don't have monadic form by default
		throw new ValenceError();
	}
	
	@Override
	public String getName() {
		return "or";
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(a instanceof BitArray) {
			BitArray ai = (BitArray)a;
			if(b.isScalar() && b.isIntegral()) {
				return ai.orRight(b.atI(0));
			}
			if(b instanceof BitArray) {
				return ai.or((BitArray)b);
			}
			return super.dyadic(a, b, axis);
		}
		if(b instanceof BitArray) {
			BitArray bi = (BitArray)b;
			if(a.isScalar() && a.isIntegral()) {
				return bi.or(a.atI(0));
			}
		}
		return super.dyadic(a, b, axis);
	}

}
