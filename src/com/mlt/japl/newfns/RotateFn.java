package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyCharArray;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class RotateFn extends BaseFn {

	private boolean firstAxis;

	public RotateFn(boolean firstAxis) {
		this.firstAxis = firstAxis;
	}

	@Override
	public IValue visit_monadic(IIntArray a, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : a.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				int[] rindex = a.dims().reverseIndexInt(index);
				rindex[axis] = a.dims().axis(axis)-1 - rindex[axis];
				return a.get(a.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : a.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyDoubleArray(a.dims()) {
			@Override
			public double get(int index) {
				int[] rindex = a.dims().reverseIndexInt(index);
				rindex[axis] = a.dims().axis(axis)-1 - rindex[axis];
				return a.get(a.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_monadic(ICharArray a, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : a.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyCharArray(a.dims()) {
			@Override
			public char get(int index) {
				int[] rindex = a.dims().reverseIndexInt(index);
				rindex[axis] = a.dims().axis(axis)-1 - rindex[axis];
				return a.get(a.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_monadic(IBitArray a, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : a.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				int[] rindex = a.dims().reverseIndexInt(index);
				rindex[axis] = a.dims().axis(axis)-1 - rindex[axis];
				return a.get(a.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_monadic(IMixedArray a, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : a.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyMixedArray(a.dims()) {
			@Override
			public IValue get(int index) {
				int[] rindex = a.dims().reverseIndexInt(index);
				rindex[axis] = a.dims().axis(axis)-1 - rindex[axis];
				return a.get(a.dims().calculateIndex(rindex));
			}
		};
	}
	
	private static int clamp(int max, int val) {
		int tmp = val%max;
		if(tmp<0) return max+tmp;
		return tmp;
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : b.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyIntArray(b.dims()) {
			@Override
			public long get(int index) {
				int[] rindex = b.dims().reverseIndexInt(index);
				int limit = b.dims().axis(axis);
				rindex[axis] = clamp(limit, rindex[axis] + (int)a.get());
				return b.get(b.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : b.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyDoubleArray(b.dims()) {
			@Override
			public double get(int index) {
				int[] rindex = b.dims().reverseIndexInt(index);
				int limit = b.dims().axis(axis);
				rindex[axis] = clamp(limit, rindex[axis] + (int)a.get());
				return b.get(b.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharArray b, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : b.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyCharArray(b.dims()) {
			@Override
			public char get(int index) {
				int[] rindex = b.dims().reverseIndexInt(index);
				int limit = b.dims().axis(axis);
				rindex[axis] = clamp(limit, rindex[axis] + (int)a.get());
				return b.get(b.dims().calculateIndex(rindex));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IMixedArray b, int ax) {
		int axis;
		if(ax<0) {
			axis = firstAxis ? 0 : b.rank()-1;
		} else {
			axis = ax;
		}
		return new LazyMixedArray(b.dims()) {
			@Override
			public IValue get(int index) {
				int[] rindex = b.dims().reverseIndexInt(index);
				int limit = b.dims().axis(axis);
				rindex[axis] = clamp(limit, rindex[axis] + (int)a.get());
				return b.get(b.dims().calculateIndex(rindex));
			}
		};
	}
	
	@Override
	public String getName() {
		return "rotate";
	}

}
