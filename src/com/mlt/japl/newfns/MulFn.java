package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class MulFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new IntScalar(a.get() * b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() * b.get());
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() * b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return new DoubleScalar(a.get() * b.get());
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return (long)Math.signum(a.get(index));
			}
		};
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return Math.signum(a.get(index));
			}
		};
	}

	// scalar/array
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		if(a.get()==0) return new DoubleArray(b.dims(), new double[] { 0 });
		if(a.get()==1) return b;
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
		if(a.get()==0) return new DoubleArray(b.dims(), new double[] { 0 });
		if(a.get()==1) return b;
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return a.get() * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		if(a.get()==0) return new DoubleArray(b.dims(), new double[] { 0 });
		if(a.get()==1) return b;
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return a.get() * b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
		if(a.get()==0) return new DoubleArray(b.dims(), new double[] { 0 });
		if(a.get()==1) return b;
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				return a.get() * b.get(index);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		if(b.get()==0) return new DoubleArray(a.dims(), new double[] { 0 });
		if(b.get()==1) return a;
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) * b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
		if(b.get()==0) return new DoubleArray(a.dims(), new double[] { 0 });
		if(b.get()==1) return a;
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
		if(b.get()==0) return new DoubleArray(a.dims(), new double[] { 0 });
		if(b.get()==1) return a;
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get();
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
		if(b.get()==0) return new DoubleArray(a.dims(), new double[] { 0 });
		if(b.get()==1) return a;
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get();
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
	public IValue reduce(IIntArray a, int ax) {
		int axis = ax<0 ? a.rank()-1 : ax;
		IntReducer reducer = new IntReducer(1, a, axis) {
			@Override
			public long op(long a, long b) {
				return a*b;
			}
		};
		if(a.rank()==1) return new IntScalar(reducer.rank1case());
		return new LazyIntArray(a.dims().elideAxis(axis)) {
			@Override
			public long get(int index) {
				return reducer.get(index);
			}
		};
	}

	@Override
	public IValue reduce(IBitArray a, int ax) {
		int axis = ax<0 ? a.rank()-1 : ax;
		BitReducer reducer = new BitReducer(1, a, axis) {
			@Override
			public long op(long a, long b) {
				return a*b;
			}
		};
		if(a.rank()==1) return new IntScalar(reducer.rank1case());
		return new LazyIntArray(a.dims().elideAxis(axis)) {
			@Override
			public long get(int index) {
				return reducer.get(index);
			}
		};
	}
	
	@Override
	public IValue reduce(IDoubleArray a, int ax) {
		int axis = ax<0 ? a.rank()-1 : ax;
		DoubleReducer reducer = new DoubleReducer(1, a, axis) {
			@Override
			public double op(double a, double b) {
				return a*b;
			}
		};
		if(a.rank()==1) return new DoubleScalar(reducer.rank1case());
		return new LazyDoubleArray(a.dims().elideAxis(axis)) {
			@Override
			public double get(int index) {
				return reducer.get(index);
			}
		};
	}

	@Override
	public String getName() {
		return "*";
	}
}
