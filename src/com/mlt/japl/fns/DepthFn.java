package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class DepthFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		return new IntScalar(a.depth());
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(a.rank()!=b.rank()) return new IntScalar(0);
		if(a.depth()!=b.depth()) return new IntScalar(0);
		if(!a.dims().equals(b.dims())) return new IntScalar(0);
		for(int i=0; i<a.length(); i++) {
			if(!a.atA(i).equals(b.atA(i))) return new IntScalar(0);
		}
		return new IntScalar(1);
	}

	@Override
	public String getName() {
		return "depth";
	}
	
	@Override
	public int resultTypeFor(Array a) {
		return Array.INTEGER;
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}

}
