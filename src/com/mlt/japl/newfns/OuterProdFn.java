package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class OuterProdFn extends BaseFn {

	private Func fn;

	public OuterProdFn(Func fn) {
		this.fn = fn;		
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}
	
	@Override
	public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IDoubleArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
		return fn.outerprod(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IIntArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(a.get(idx), new IntScalar(b.get(index)), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IDoubleArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(a.get(idx), new DoubleScalar(b.get(index)), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IBitArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(a.get(idx), new IntScalar(b.get(index)), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, ICharArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(a.get(idx), new CharScalar(b.get(index)), axis);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(a.get(idx), b.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(new IntScalar(a.get(idx)), b.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedScalar b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(new IntScalar(a.get(index)), b.get(), axis);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(new DoubleScalar(a.get(idx)), b.get(index), axis);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(ICharArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(new CharScalar(a.get(idx)), b.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return fn.applyDyadic(new IntScalar(a.get(idx)), b.get(index), axis);
			}
		};
	}
	
	@Override
	public String getName() {
		return "outerprod<" + fn.getName() + ">";
	}

}
