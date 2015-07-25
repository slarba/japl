package com.mlt.japl.fns;


import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Iterator;

public class ReverseFn extends SpecialBaseFn {

	private boolean first;

	public ReverseFn() {
		first = true;
	}

	public ReverseFn(boolean first) {
		this.first = first;
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		if(a.isScalar()) return a;
		
		if(axis<0) {
			if(first) axis = 0;
			else axis = a.rank()-1;
		}

		Array result = a.unInitializedReshapedCopy(a.dims());
		Iterator srcIterator = a.dims().iteratorAlongAxis(axis);
		Iterator dstIterator = result.dims().reverseIteratorAlongAxis(axis);

		return copyWithIterators(a, result, srcIterator, dstIterator);
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		throw new ValenceError();
	}
	
	@Override
	public String getName() {
		return "reverse";
	}

	@Override
	public int resultTypeFor(Array a) {
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}

}
