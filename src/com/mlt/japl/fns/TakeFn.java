package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;
import com.mlt.japl.tools.RangeIterator;
import com.mlt.japl.tools.TakeArrayAdapter;

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
		if(b.isScalar()) b = b.reshape(1);
		Dimensions resultDims = resultDimsFor(a, b, axis);

		Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a, b), resultDims);
		int[] mins = new int[resultDims.rank()];
		int[] maxes = new int[resultDims.rank()];
		int[] as = a.asIntArray();
		
		for(int i=0; i<mins.length; i++) {
			if(as[i]==0) return result;
			if(as[i]<0) {
				mins[i] = b.dims().axis(i) + as[i];
				maxes[i] = b.dims().axis(i);
			} else {
				mins[i] = 0;
				maxes[i] = as[i];
			}
		}
		
		TakeArrayAdapter adapter = new TakeArrayAdapter(b, b.prototype());
		RangeIterator rangeIterator = new RangeIterator(mins, maxes);
		Iterator resultIterator = result.dims().linearIterator();
		while(!resultIterator.isFinished()) {
			result.setA(resultIterator.index(), adapter.atA(rangeIterator.iter()));
			resultIterator.step();
			rangeIterator.step();
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "take";
	}

	@Override
	public int resultTypeFor(Array a) {
		if(a.isNested()) return a.atA(0).type();
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		if(a.isNested()) return a.atA(0).dims();
		return Dimensions.EMPTY;  // returns a scalar always
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		if(!a.isIntegral()) throw new DomainError();
		if(a.rank()>1) throw new RankError();
		if(a.length()!=b.rank()) throw new RankError();
		int[] lens = new int[a.length()];
		for(int i=0; i<a.length(); i++) {
			lens[i] = (int)Math.abs(a.atI(i));
		}
		return new Dimensions(lens);
	}
}
