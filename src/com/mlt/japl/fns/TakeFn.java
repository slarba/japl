package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class TakeFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis)
	{
		if(a.isScalar()) return a;
		return a.atA(0);
	}

	@Override
	public Array dyadic(Array a, Array b, int axis)
	{
		if(!a.isIntegral()) throw new DomainError();
		if(a.rank()>1) throw new RankError();
		int len;
		if(a.isScalar()) len = 1; else len = a.length();
		if(len!=b.rank()) throw new RankError();
		
		int[] bdims = b.dims().asArray();
		int[] offsets = new int[len];
		int[] limits = new int[len];
		int[] lengths = new int[len];
		for(int i=0; i<offsets.length; i++) {
			int x = (int)a.atI(i);
			lengths[i] = Math.abs(x)-bdims[i];
			if(x<0) offsets[i] = Math.max(0, bdims[i]+x);
			if(x>=0) limits[i] = x;
		}

		Dimensions resultDims = b.dims().offsetBy(lengths);
		Array result = ArrayFactory.makeArrayOfType(b.type(), resultDims);
		
		if(b.dims().fitsInside(resultDims)) {
			Iterator srcIterator = b.dims().iteratorAlongAxis(b.rank()-1);
	
			do {
				result.setA(result.dims().calculateIndex(srcIterator.iter()), b.atA(srcIterator.index()));
				srcIterator.step();
			} while(!srcIterator.isFinished());
		} else {
			Iterator srcIterator = resultDims.iteratorAlongAxis(b.rank()-1);
			do {
				result.setA(srcIterator.index(), b.atA(srcIterator.iter()));
				srcIterator.step();
			} while(!srcIterator.isFinished());			
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "take";
	}

	@Override
	public int resultTypeFor(Array a) {
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return Dimensions.EMPTY;  // returns a scalar always
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		if(!a.isIntegral()) throw new DomainError();
		if(a.rank()>1) throw new RankError();
		if(a.length()>b.rank()) throw new LengthError();
		int[] lens = new int[a.length()];
		for(int i=0; i<a.length(); i++) {
			lens[i] = (int)Math.abs(a.atI(i));
		}
		return new Dimensions(lens);
	}
}
