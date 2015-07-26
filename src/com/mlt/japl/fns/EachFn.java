package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;

public class EachFn extends SpecialBaseFn {

	private Func fn;

	public EachFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		Array result = makeSimilarArrayOfType(Array.NESTED, a.dims());
		for(int i=0; i<result.actualLength(); i++) {
			result.setA(i, fn.monadic(a.atA(i), axis));
		}
		return result;
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
//		if(b.type()!=Array.NESTED) {
//			return fn.dyadic(a, b, axis);
//		}
		if(b.isScalar()) {
			Array result = makeSimilarArrayOfType(Array.NESTED, a.dims());
			for(int i=0; i<result.actualLength(); i++) {
				result.setA(i, fn.dyadic(a.atA(i), b.atA(0), axis));
			}
			return result;
		}
		Array result = b.unInitializedReshapedCopy(b.dims());
		for(int i=0; i<result.actualLength(); i++) {
			result.setA(i, fn.dyadic(a.atA(i), b.atA(i), axis));
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "each<" + fn.getName() + ">";
	}
	
	@Override
	public int resultTypeFor(Array a) {
		if(a.type()!=Array.NESTED) return fn.resultTypeFor(a);
		return Array.NESTED;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return fn.resultTypeFor(a,b);
	}

}
