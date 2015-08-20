package com.mlt.japl.fns;

import java.util.HashSet;
import java.util.Random;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class RollFn extends PrimitiveBaseFn {

	private Random random;

	@Override
	public long I_I(long x) {
		if(x<=1) return 1;
		return 1 + (random.nextInt((int)x));
	}

	@Override
	public Array monadic(Array a, int axis) {
		if(random==null) {
			random  = new Random(System.currentTimeMillis());
		}
		if(!a.isIntegral()) throw new DomainError();
		if(a.isScalar()) {
			return new IntScalar(I_I(a.atI(0)));
		}
		Array result = ArrayFactory.makeSimilarArrayOfTypeWithActualLength(Array.INTEGER, a, a.length());
		for(int i=0; i<result.actualLength(); i++) {
			result.setI(i, I_I(a.atI(i)));
		}
		return result;
	}
	
	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(random==null) {
			random  = new Random(System.currentTimeMillis());
		}
		if(!a.isIntegral()) throw new DomainError();
		if(!b.isIntegral()) throw new DomainError();
		if(!a.isScalar()) throw new RankError();
		if(!b.isScalar()) throw new RankError();
		int count = (int)a.atI(0);
		int max = (int)b.atI(0);
		if(count>max) throw new ValueError();
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()<count) {
			set.add(1+random.nextInt(max));
		}
		long[] result = new long[count];
		int i=0;
		for(Integer n : set) {
			result[i++] = n;
		}
		// should shuffle the array.... too ordered after taking from set!
		return new IntArrayImpl(result);
	}
	
	@Override
	public String getName() {
		return "roll";
	}

}
