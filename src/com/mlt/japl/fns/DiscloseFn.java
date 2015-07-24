package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;

public class DiscloseFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		if(a.rank()==0) return a.atA(0);
		return a;
	}
	
	@Override
	public String getName() {
		return "disclose";
	}
}
