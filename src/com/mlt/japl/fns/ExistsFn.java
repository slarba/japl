package com.mlt.japl.fns;

import java.util.HashSet;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
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
		if(a.isScalar() && b.isScalar()) {
			return IntScalar.fromBoolean(a.atA(0).hashCode() == b.atA(0).hashCode());
		}
		HashSet<Array> set = new HashSet<Array>();
		for(int i=0; i<b.length(); i++) {
			set.add(b.atA(i));
		}
		if(a.isScalar()) {
			return IntScalar.fromBoolean(set.contains(a.atA(0)));
		}
		Array r = new BitArray(a.dims(), true, a.length());
		for(int i=0; i<a.length(); i++) {
			r.setB(i, set.contains(a.atA(i)) ? 1 : 0);
		}
		return r;
	}
	
	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return Array.BIT;
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

}
