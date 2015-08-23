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
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return new LazyMonadicIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return new LazyMonadicDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				return a.get(index) + b.get(index);
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

}
