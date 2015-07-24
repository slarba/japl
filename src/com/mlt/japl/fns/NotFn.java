package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class NotFn extends LogicalBaseFn {

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		throw new ValenceError();
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		if(!a.isIntegral()) throw new DomainError();
		if(a.isScalar()) {
			return new IntScalar(a.atI(0)^1);
		}
		if(a.type()==Array.MIXED) {
			Array result = new NestedArray(a.dims(), new Array[a.actualLength()]);
			for(int i=0; i<result.actualLength(); i++) {
				result.setA(i, monadic(a.atA(i), axis));
			}
			return result;
		}
		if(a.type()==Array.BIT) {
			return ((BitArray)a).not();
		}
		throw new DomainError();
	}
	
	@Override
	public String getName() {
		return "not";
	}

}
