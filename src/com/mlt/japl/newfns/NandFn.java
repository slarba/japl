package com.mlt.japl.newfns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.ConstBitArray;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class NandFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new IntScalar(~(a.get() & b.get()));
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return (a.get(index) & b.get(index)) ^ 1;
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get(index) & b.get(index));
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get(index) & b.get(index));
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get(index) & b.get(index));
			}
		};
	}

	// scalar/array
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get() & b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get(index) & b.get());
			}
		};
	}

	// scalar/array
	@Override
	public IValue visit_dyadic(IIntScalar a, IBitArray b, int axis) {
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get() & b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntScalar b, int axis) {
		if(b.get()==0) return new ConstBitArray(a.dims(), 1);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~(a.get(index) & b.get());
			}
		};
	}
	
	@Override
	public IValue applyMonadic(IValue a, int axis) {
		throw new ValenceError();
	}

	@Override
	public String getName() {
		return "and";
	}
}
