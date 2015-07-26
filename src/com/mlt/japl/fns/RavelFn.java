package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class RavelFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		if(a.isScalar()) return a;
		return a.reshape(new Dimensions(a.dims().length()));
	}
	
	@Override
	public String getName() {
		return "ravel";
	}

	@Override
	public int resultTypeFor(Array a) {
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return a.type();
	}

}
