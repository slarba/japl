package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedScalar;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class AbsFn extends BaseFn {
	// scalars
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new IntScalar(b.get() % a.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(b.get() % a.get());
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(b.get() % a.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return new DoubleScalar(b.get() % a.get());
	}

	// arrays
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}

	// scalar/array
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				return b.get(index) % a.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IBitArray b, int axis) {
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				return b.get(index) % a.get();
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return b.get(index) % a.get();
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return b.get() % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return b.get(index) % a.get(index);
			}
		};		
	}
	
	@Override
	public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return b.get(index) % a.get(index);
			}
		};		
	}
	
	@Override
	public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return b.get(index) % a.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IBitArray a, IIntScalar b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return b.get() % a.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get() % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get() % a.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return b.get() % a.get(index);
			}
		};
	}
	
	// monadic
	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return Math.abs(a.get(index));
			}
		};
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.abs(a.get(index));
			}
		};
	}

	@Override
	public IValue visit_monadic(IBitArray a, int axis) {
		return a;
	}
	
	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return new IntScalar((long)Math.abs(a.get()));
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return new DoubleScalar(Math.abs(a.get()));
	}
	
	@Override
	public String getName() {
		return "abs";
	}
}
