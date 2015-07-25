package com.mlt.japl.fns;

import java.util.HashSet;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class ExistsFn extends SpecialBaseFn {

	@Override
	public String getName() {
		return "exists";
	}

	@Override
	public Array monadic(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		HashSet<Array> set = new HashSet<Array>();
		for(int i=0; i<b.length(); i++) {
			set.add(b.atA(i));
		}
		Array r = new BitArray(new Dimensions(a.length()), true, a.length());
		for(int i=0; i<b.length(); i++) {
			r.setB(i, set.contains(a.atA(i)) ? 1 : 0);
		}
		return r;
	}
	
	@Override
	public int resultTypeFor(Array a) {
		return 0;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return Array.INTEGER;
	}

}
