package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyMonadicDoubleArray;
import com.mlt.japl.newarrays.generated.LazyMonadicIntArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class CeilFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
		return new IntScalar(Math.max(a.get(), b.get()));
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
		return new DoubleScalar(Math.max(a.get(), b.get()));
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
		return new DoubleScalar(Math.max(a.get(), b.get()));
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
		return new DoubleScalar(Math.max(a.get(), b.get()));
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return Math.max(a.get(index), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(index), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(index), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(index), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return Math.max(a.get(), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(), b.get(index));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(), b.get(index));
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return Math.max(a.get(index), b.get());
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(index), b.get());
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.max(a.get(index), b.get());
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.min(a.get(index), b.get());
			}
		};
	}

	@Override
	public IValue visit_monadic(IIntArray a) {
		return a;
	}

	@Override
	public IValue visit_monadic(IDoubleArray a) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.ceil(a.get(index));
			}
		};
	}
	
	@Override
	public IValue visit_monadic(IIntScalar a) {
		return a;
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a) {
		return new DoubleScalar(Math.ceil(a.get()));
	}
}
