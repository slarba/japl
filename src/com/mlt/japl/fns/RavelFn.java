package com.mlt.japl.fns;


import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class RavelFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		if(a.isScalar()) return a;
		return a.reshape(new Dimensions(a.dims().length()));
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(a.isScalar() && b.isScalar()) {
			return new NestedArray(a, b);
		}
		if(axis<0) {
			axis = b.rank()-1;
		}

		Dimensions resultDims = a.dims().laminate(b.dims(), axis);
		Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), resultDims);
		
		Iterator r = resultDims.iteratorAlongLastAxis();
		while(!r.isFinished()) {
			if(r.axis(axis)>=a.dims().axis(axis)) {
				result.setA(r.index(), b.atA(b.dims().indexWithReplacedAxis(axis, r.axis(axis)-a.dims().axis(axis), r.iter())));
			} else
				result.setA(r.index(), a.atA(r.iter()));
			r.step();
		}
		return result;
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
		if(a.type()!=b.type()) {
			return Array.NESTED;
		}
		return a.type();
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
