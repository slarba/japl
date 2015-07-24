package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;

public class IotaFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		if(!a.isIntegral()) throw new DomainError();
		long v = a.atI(0);
		if(v==0) return new IntArray();
		return new IotaArray((int)a.atI(0));
	}

	@Override
	public String getName() {
		return "iota";
	}

}
