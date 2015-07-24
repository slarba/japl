package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public abstract class LogicalBaseFn extends PrimitiveBaseFn {

	@Override
	public Array createResultArrayFor(Array a, int axis) {
		if(a.isScalar()) return new IntScalar();
		if(a.type()==Array.MIXED) return new NestedArray(a.dims(), new Array[a.actualLength()]);
		return BitArray.similarTo(a);
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			if(b.isScalar()) return new IntScalar();
			if(b.type()==Array.MIXED) return new NestedArray(b.dims(), new Array[b.actualLength()]);
			return BitArray.similarTo(b);
		}
		if(b.isScalar()) {
			if(a.type()==Array.MIXED) return new NestedArray(a.dims(), new Array[a.actualLength()]);
			return BitArray.similarTo(a);
		}
		if(a.rank() != b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
		if(a.type()==Array.MIXED) return new NestedArray(a.dims(), new Array[a.actualLength()]);
		return BitArray.similarTo(a);
	}

}
