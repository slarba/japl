package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class DropFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis)
	{
		throw new ValenceError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis)
	{
		if(!a.isIntegral()) throw new DomainError();
		if(a.rank()>1) throw new RankError();
		int len;
		if(a.isScalar()) len = 1; else len = a.length();
		if(len!=b.rank()) throw new RankError();
		
		int[] offsets = new int[len];
		int[] limits = new int[len];
		int[] lengths = new int[len];
		for(int i=0; i<offsets.length; i++) {
			int x = (int)a.atI(i);
			lengths[i] = Math.abs(x);
			if(x>=0) offsets[i] = x;
			if(x<0) limits[i] = -x;
		}

		Dimensions resultDims = b.dims().offsetByMinus(lengths);
		Array result = makeSimilarArrayOfType(b.type(), resultDims);
		Iterator srcIterator = b.dims().offsetIterator(offsets, limits);
		Iterator dstIterator = resultDims.linearIterator();

		while(!dstIterator.isFinished()) {
			result.setA(dstIterator.index(), b.atA(srcIterator.index()));
			srcIterator.step();
			dstIterator.step();
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "drop";
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
