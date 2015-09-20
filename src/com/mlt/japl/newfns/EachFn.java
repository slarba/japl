package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class EachFn extends BaseFn {

	private Func fn;

	public EachFn(Func fn) {
		this.fn = fn;
	}

	@Override
	public IValue visit_monadic(IMixedArray a, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyMonadic(a.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(IBitArray a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(ICharScalar a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_monadic(IMixedScalar a, int axis) {
		return fn.applyMonadic(a, axis);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return fn.applyDyadic(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return fn.applyDyadic(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		return fn.applyDyadic(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
		return fn.applyDyadic(a, b, axis);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return fn.applyDyadic(a,b,axis);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		return fn.applyDyadic(a,b,axis);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntArray b, int axis) {
		return fn.applyDyadic(a,b,axis);
	}
	
	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(index), b.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IMixedArray b, int axis) {
		return new LazyMixedArray(b.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(), b.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedScalar b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(index), b.get(), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedArray b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(new IntScalar(a.get(index)), b.get(index), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IIntArray b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(index), new IntScalar(b.get(index)), axis);
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
	public IValue visit_dyadic(IMixedScalar a, IIntArray b, int axis) {
		return new LazyMixedArray(b.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(), new IntScalar(b.get(index)), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IMixedScalar b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(new IntScalar(a.get(index)), b.get(), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IBitArray b, int axis) {
		return new LazyMixedArray(b.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(), new IntScalar(b.get(index)), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedScalar b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(new DoubleScalar(a.get(index)), b.get(), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IDoubleArray b, int axis) {
		return new LazyMixedArray(b.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(), new DoubleScalar(b.get(index)), axis);
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(ICharArray a, IMixedScalar b, int axis) {
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(new CharScalar(a.get(index)), b.get(), axis);
			}
		};
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, ICharArray b, int axis) {
		return new LazyMixedArray(b.dims()) {
			@Override
			public IValue get(int index) {
				return fn.applyDyadic(a.get(), new CharScalar(b.get(index)), axis);
			}
		};
	}
	
	@Override
	public String getName() {
		return "each<" + fn.getName() + ">";
	}

}
