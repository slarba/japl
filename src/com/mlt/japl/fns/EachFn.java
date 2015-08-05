package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.iface.PrimitiveFunc;
import com.mlt.japl.tools.Dimensions;

public class EachFn extends SpecialBaseFn {

	private Func fn;
	private boolean primitive;
	
	public EachFn(Func fn) {
		this.fn = fn;
		if(fn instanceof PrimitiveFunc) primitive = true;
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		if(primitive) {
			return fn.monadic(a, axis);
		}
		Array result = ArrayFactory.makeSimilarArrayOfTypeWithActualLength(Array.MIXED, a, a.actualLength());
		for(int i=0; i<result.actualLength(); i++) {
			result.setA(i, fn.monadic(a.atA(i), axis));
		}
		return result;
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(primitive) {
			return fn.dyadic(a, b, axis);
		}
		if(b.isScalar()) {
			Array result = ArrayFactory.makeSimilarArrayOfTypeWithActualLength(Array.MIXED, a, a.length());
			for(int i=0; i<result.length(); i++) {
				result.setA(i, fn.dyadic(a.atA(i), b.atA(0), axis));
			}
			return result;
		}
		Array result;
		if(a.isScalar()) {
			result = ArrayFactory.makeSimilarArrayOfTypeWithActualLength(Array.MIXED, b, b.length());
		} else
			result = ArrayFactory.makeSimilarArrayOfTypeWithActualLength(Array.MIXED, a, a.length());
		//Array result = b.unInitializedReshapedCopy(b.dims());
		for(int i=0; i<result.length(); i++) {
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
		if(a.type()!=Array.MIXED) return fn.resultTypeFor(a);
		return Array.MIXED;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return fn.resultTypeFor(a,b);
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return a.dims();
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		if(a.isScalar()) return b.dims();
		if(b.isScalar()) return a.dims();
		checkEqualDimensionsAndRank(a, b);
		return a.dims();
	}

}
