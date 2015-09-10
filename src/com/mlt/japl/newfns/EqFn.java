package com.mlt.japl.newfns;

import com.mlt.japl.errors.SyntaxError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.BitArray;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class EqFn extends BaseFn {
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return new IntScalar(a.get() == b.get() ? 1 : 0);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return new IntScalar(a.get() == b.get() ? 1 : 0);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return new IntScalar(a.get() == b.get() ? 1 : 0);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return new IntScalar(a.get() == b.get() ? 1 : 0);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		checkLengths(a,b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, ICharArray b, int axis) {
		return new BitArray(1, b.dims(), new long[] { 0 });
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};		
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get(index) ? 1 : 0;
			}
		};
	}

	// scalar/array
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return new LazyBitArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharScalar b, int axis) {
		return new IntScalar(0);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IIntScalar b, int axis) {
		return new BitArray(1, a.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharArray b, int axis) {
		return new LazyBitArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get()==b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharScalar b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index)==b.get() ? 1 : 0;
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(ICharArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntScalar b, int axis) {
		return new IntScalar(0);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntArray b, int axis) {
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IBitArray b, int axis) {
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IDoubleArray b, int axis) {
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(IIntArray a, ICharScalar b, int axis) {
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(IBitArray a, ICharScalar b, int axis) {
		return new BitArray(1, b.dims(), new long[] {0});
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, ICharScalar b, int axis) {
		return new BitArray(1, a.dims(), new long[] {0});
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IBitArray b, int axis) {
		return new LazyBitArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntScalar b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get() ? 1 : 0;
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
		return new LazyBitArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		return new LazyBitArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() == b.get(index) ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
		return new LazyBitArray(b.dims()) {
			@Override
			public long get(int index) {
				return a.get() == b.get(index) ? 1 : 0;
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get() ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get() ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get() ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index) == b.get() ? 1 : 0;
			}
		};
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharScalar b, int axis) {
		return new IntScalar(a.get()==b.get() ? 1 : 0);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index).equals(b.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
		checkLengths(a, b);
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index)==b.get(index) ? 1 : 0;
			}			
		};
	}
	
	@Override
	public IValue visit_dyadic(IMixedArray a, IIntArray b, int axis) {
		checkLengths(a, b);
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return applyDyadic(a.get(index), new IntScalar(b.get(index)), axis);
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedArray b, int axis) {
		checkLengths(a, b);
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return visit_first(new IntScalar(a.get(index)), b.get(index), axis);
			}			
		};
	}
	
	@Override
	public IValue visit_dyadic(IMixedArray a, IDoubleArray b, int axis) {
		checkLengths(a, b);
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return applyDyadic(a.get(index), new DoubleScalar(b.get(index)), axis);
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedArray b, int axis) {
		checkLengths(a, b);
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return visit_first(new DoubleScalar(a.get(index)), b.get(index), axis);
			}			
		};
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IMixedArray b, int axis) {
		checkLengths(a, b);
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return visit_first(new CharScalar(a.get(index)), b.get(index), axis);
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, ICharArray b, int axis) {
		checkLengths(a, b);
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				return applyDyadic(a.get(index), new CharScalar(b.get(index)), axis);
			}			
		};
	}
	
	@Override
	public IValue applyMonadic(IValue a, int axis) {
		throw new ValenceError();
	}

	@Override
	public IValue reduce(IIntArray a, int axis) {
		IntReducer reducer = new IntReducer(1, a, axis) {
			@Override
			public long op(long a, long b) {
				return a==b ? 1 : 0;
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

	// reduce for = ?
	@Override
	public IValue reduce(IBitArray a, int axis) {
		BitReducer reducer = new BitReducer(1, a, axis) {
			@Override
			public long op(long a, long b) {
				return a==b ? 1 : 0;
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
				return a==b ? 1 : 0;
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
		return "=";
	}
}
