package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedScalar;
import com.mlt.japl.newarrays.generated.LazyMonadicDoubleArray;
import com.mlt.japl.newarrays.generated.LazyMonadicIntArray;
import com.mlt.japl.newarrays.generated.LazyMonadicMixedArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class SubFn extends BaseFn {
	// scalars
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new IntScalar(a.get() - b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() - b.get());
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() - b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return new DoubleScalar(a.get() - b.get());
	}

	// arrays
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	// scalar/array
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get() - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get() - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get() - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get() - b.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get();
			}
		};
	}
	
	// monadic
	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return -a.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return -a.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_monadic(IMixedArray a, int axis) {
		final ArrayVisitor self = this;
		return new LazyMonadicMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return a.get(index).accept_monadic(self, axis);
			}
		};
	}
	
	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return new IntScalar((long)Math.signum(a.get()));
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return new DoubleScalar(Math.signum(a.get()));
	}

	@Override
	public IValue visit_monadic(IMixedScalar a, int axis) {
		return new MixedScalar(a.get().accept_monadic(this, axis));
	}
	
	@Override
	public String getName() {
		return "-";
	}
}
