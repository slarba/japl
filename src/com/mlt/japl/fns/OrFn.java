package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class OrFn extends LogicalBaseFn {

	@Override
	public String getName() {
		return "or";
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(!a.isIntegral() || !b.isIntegral()) throw new DomainError();
		if(a.isScalar()) {
			if(b.isScalar()) {
				long ai = a.atI(0);
				long bi = b.atI(0);
				long result = ai | bi;
				return new IntScalar(result);
			}
			if(b.type()!=Array.BIT) throw new DomainError();
			BitArray bi = (BitArray)b;
			return bi.or(a.atI(0));
		}
		if(b.isScalar()) {
			if(a.type()!=Array.BIT) throw new DomainError();
			BitArray ai = (BitArray)a;
			return ai.orRight(b.atI(0));
		}
		if(a.type()!=Array.BIT || b.type()!=Array.BIT) throw new DomainError();
		if(a.rank()!=b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
		
		BitArray ai = (BitArray)a;
		BitArray bi = (BitArray)b;
		return ai.or(bi);
	}

}
