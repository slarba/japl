package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

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
	
	@Override
	public int resultTypeFor(Array a) {
		return a.rank()==0 ? a.atA(0).type() : a.type();
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		if(a.isScalar()) return a.atA(0).dims();
		return a.dims();
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return null;
	}

}
