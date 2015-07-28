package com.mlt.japl.fns;

import java.util.Random;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class RollFn extends PrimitiveBaseFn {

	private Random random;

	@Override
	public long I_I(long x) {
		if(x<=1) return 1;
		if(random==null) {
			random  = new Random(System.currentTimeMillis());
		}
		return 1 + (random.nextInt((int)x));
	}

	@Override
	public Array monadic(Array a, int axis) {
		if(!a.isIntegral()) throw new DomainError();
		if(a.isScalar()) {
			return new IntScalar(I_I(a.atI(0)));
		}
		Array result = ArrayFactory.makeSimilarArrayOfType(Array.INTEGER, a);
		for(int i=0; i<result.length(); i++) {
			result.setI(i, I_I(a.atI(i)));
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "roll";
	}

}
