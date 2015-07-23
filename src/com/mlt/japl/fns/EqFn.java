package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class EqFn extends PrimitiveBaseFn {

	@Override
	public Array createResultArrayFor(Array a, int axis) {
		if(a.isScalar()) return new IntScalar();
		return BitArray.similarTo(a);
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			if(b.isScalar()) return new IntScalar();
			return BitArray.similarTo(b);
		}
		if(b.isScalar()) {
			return BitArray.similarTo(a);
		}
		if(a.rank() != b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
		return BitArray.similarTo(a);
	}

	@Override
	public int I_CC(char a, char b) {
		return a==b ? 1 : 0;
	}

	@Override
	public long I_DD(double a, double b) {
		return a==b ? 1 : 0;
	}

	@Override
	public long I_DI(double a, long b) {
		return a==b ? 1 : 0;
	}

	@Override
	public long I_ID(long a, double b) {
		return a==b ? 1 : 0;
	}

	@Override
	public long I_II(long a, long b) {
		return a==b ? 1 : 0;
	}

	
}
