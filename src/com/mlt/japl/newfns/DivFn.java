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

public class DivFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new DoubleScalar((double)a.get() / b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() / b.get());
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return new DoubleScalar(a.get() / b.get());
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return new DoubleScalar(a.get() / b.get());
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return (double)a.get(index) / b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return (double)a.get(index) / b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) / b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) / b.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return 1.0/a.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return 1.0/a.get(index);
			}
		};
	}
	
	@Override
	public IValue reduce(IIntArray a, int axis) {
		DoubleIntReducer reducer = new DoubleIntReducer(1, a, axis) {
			@Override
			public double op(double a, double b) {
				return a/b;
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
	public IValue reduce(IBitArray a, int axis) {
		BitReducer reducer = new BitReducer(1, a, axis) {
			@Override
			public long op(long a, long b) {
				return a/b;
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
	public IValue reduce(IDoubleArray a, int axis) {
		DoubleReducer reducer = new DoubleReducer(1, a, axis) {
			@Override
			public double op(double a, double b) {
				return a/b;
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
		return "/";
	}

}
