package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.IIntArray;

public class NotFn extends BaseFn {
	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~a.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IBitArray a, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index)^1;
			}
		};
	}

	@Override
	public String getName() {
		return "not";
	}

}
