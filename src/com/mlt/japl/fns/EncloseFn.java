package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;

public class EncloseFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		if(a.isScalar()) return a;
		return new ArrayScalar(a);
	}
	
	@Override
	public String getName() {
		return "enclose";
	}

}
