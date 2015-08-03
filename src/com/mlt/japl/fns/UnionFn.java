package com.mlt.japl.fns;

import java.util.HashSet;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class UnionFn extends SpecialBaseFn {

	@Override
	public String getName() {
		return "union";
	}

	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		HashSet<Array> set = new HashSet<Array>();
		if(a.isScalar()) set.add(a);
		if(b.isScalar()) set.add(b);
		if(a.isScalar() && b.isScalar()) {
			Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), new Dimensions(set.size()));
			int i=0;
			for(Array s : set) {
				result.setA(i++, s);
			}
			return result;
		}
		
		for(int i=0; i<a.actualLength(); i++) {
			set.add(a.atA(i));
		}
		for(int i=0; i<b.actualLength(); i++) {
			set.add(b.atA(i));
		}
		Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a, b), new Dimensions(set.size()));
		int i=0;
		for(Array s : set) {
			result.setA(i++, s);
		}
		return result;
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		if(a.type()!=b.type()) return Array.MIXED;
		return a.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return null;
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return null;
	}

}
