package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class IndexFn extends SpecialBaseFn {

	@Override
	public Array dyadic(Array a, Array b, int index) {
		if(!a.isIntegral()) throw new DomainError();
		Array result = ArrayFactory.makeArrayOfType(b.type(), new Dimensions(a.length()));
		for(int i=0; i<a.length(); i++) {
			result.setA(i, b.atA((int) a.atI(i)-1));
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "index";
	}

	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return null;
	}

}
