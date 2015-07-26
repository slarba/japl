package com.mlt.japl.fns;


import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.iface.PrimitiveFunc;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class OuterProdFn extends SpecialBaseFn {

	private Func fn;
	private PrimitiveFunc primFn;
	
	public OuterProdFn(Func fn) {
		this.fn = fn;
		if(fn instanceof PrimitiveFunc) {
			primFn = (PrimitiveFunc)fn;
		}
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(a.isScalar() && b.isScalar()) {
			return fn.dyadic(a, b, axis);
		}
		
		Dimensions resultDims = a.dims().concat(b.dims());
		
		Array result = makeSimilarArrayOfType(fn.resultTypeFor(a, b), resultDims);
		Iterator ri = result.dims().linearIterator();
		Iterator ai = a.dims().linearIterator();
		Iterator bi = b.dims().linearIterator();

		while(!ri.isFinished()) {
			int aindex = ai.index();
			do {
				result.setA(ri.index(), fn.dyadic(a.atA(aindex), b.atA(bi.index()), axis));
				bi.step();
				ri.step();
			} while(!bi.isFinished());
			ai.step();
			bi.reset();
		}			
		return result;
	}
	
	@Override
	public String getName() {
		return "outerprod<" + fn.getName() + ">";
	}

	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return fn.resultTypeFor(a, b);
	}

}
