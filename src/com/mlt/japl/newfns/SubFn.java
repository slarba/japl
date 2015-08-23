package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedScalar;
import com.mlt.japl.newarrays.generated.LazyMonadicDoubleArray;
import com.mlt.japl.newarrays.generated.LazyMonadicIntArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class SubFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
		return new IntScalar(a.get() - b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
		return new DoubleScalar(a.get() - b.get());
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
		return new DoubleScalar(a.get() - b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
		return new DoubleScalar(a.get() - b.get());
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get() - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get() - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get() - b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get() - b.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) - b.get();
			}
		};
	}

	@Override
	public IValue visit_monadic(IIntArray a) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return -a.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IDoubleArray a) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return -a.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_monadic(IIntScalar a) {
		return new IntScalar((long)Math.signum(a.get()));
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a) {
		return new DoubleScalar(Math.signum(a.get()));
	}

	@Override
	public IValue visit_monadic(IMixedScalar a) {
		return new MixedScalar(applyMonadic(a.get(), 0));
	}
}
