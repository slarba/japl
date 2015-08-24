package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class AddFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new IntScalar(a.get() + b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() + b.get());
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() + b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return new DoubleScalar(a.get() + b.get());
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) + b.get(index);
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) + b.get(index);
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	// scalar/array
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return a.get() + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return a.get() + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return a.get() + b.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) + b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get();
			}
		};
	}
	
	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return a;
	}

	@Override
	public String getName() {
		return "+";
	}
}
