package com.mlt.japl.newfns;

import java.util.Arrays;

import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.generated.LazyBitArray;
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

public class ReplicateFn extends BaseFn {

	private boolean firstAxis;

	public ReplicateFn(boolean firstAxis) {
		this.firstAxis = firstAxis;
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IMixedArray b, int ax) {
		if(a.rank()>1) throw new RankError();
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.length()!=b.dims().axis(axis)) throw new LengthError();
		int n=0, j=0;
		for(int i=0; i<a.length(); i++) n = n + (int)a.get(i);
		int[] lookup = new int[n];
		for(int i=0; i<a.length(); i++) {
			if(a.get(i)==1) lookup[j++] = i;
		}
		return new LazyMixedArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public IValue get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IIntArray b, int ax) {
		if(a.rank()>1) throw new RankError();
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.length()!=b.dims().axis(axis)) throw new LengthError();
		int n=0, j=0;
		for(int i=0; i<a.length(); i++) n = n + (int)a.get(i);
		int[] lookup = new int[n];
		for(int i=0; i<a.length(); i++) {
			if(a.get(i)==1) lookup[j++] = i;
		}
		return new LazyIntArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public long get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, ICharArray b, int ax) {
		if(a.rank()>1) throw new RankError();
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.length()!=b.dims().axis(axis)) throw new LengthError();
		int n=0, j=0;
		for(int i=0; i<a.length(); i++) n = n + (int)a.get(i);
		int[] lookup = new int[n];
		for(int i=0; i<a.length(); i++) {
			if(a.get(i)==1) lookup[j++] = i;
		}
		return new LazyCharArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public char get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IDoubleArray b, int ax) {
		if(a.rank()>1) throw new RankError();
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.length()!=b.dims().axis(axis)) throw new LengthError();
		int n=0, j=0;
		for(int i=0; i<a.length(); i++) n = n + (int)a.get(i);
		int[] lookup = new int[n];
		for(int i=0; i<a.length(); i++) {
			if(a.get(i)==1) lookup[j++] = i;
		}
		return new LazyDoubleArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public double get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IBitArray a, IBitArray b, int ax) {
		if(a.rank()>1) throw new RankError();
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.length()!=b.dims().axis(axis)) throw new LengthError();
		int n=0, j=0;
		for(int i=0; i<a.length(); i++) n = n + (int)a.get(i);
		int[] lookup = new int[n];
		for(int i=0; i<a.length(); i++) {
			if(a.get(i)==1) lookup[j++] = i;
		}
		return new LazyBitArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public long get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.rank()>1) throw new RankError();
		int n = computeTotalAxisLen(a, b);
		int[] lookup = makeIndexLookup(a, n);
		return new LazyMixedArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public IValue get(int index) {
				index = index%length();
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return IntArray.EMPTY;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.rank()>1) throw new RankError();
		int n = computeTotalAxisLen(a, b);
		int[] lookup = makeIndexLookup(a, n);
		return new LazyIntArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public long get(int index) {
				index = index%length();
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return 0;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	private int computeTotalAxisLen(IIntArray a, IValue b) {
		int n=0;
		int pos=0;
		for(int i=0; i<a.length(); i++) {
			int x = (int)a.get(i);
			if(x>=0) pos++;
			n += Math.abs(x);
		}
		if(pos!=b.length()) throw new LengthError();
		return n;
	}

	private int[] makeIndexLookup(IIntArray a, int n) {
		int[] lookup = new int[n];
		int j=0;
		int l=0;
		for(int i=0; i<a.length(); i++) {
			int x = (int)a.get(i);
			for(int k=0; k<Math.abs(x); k++) {
				if(x<0) lookup[j++] = -1;
				else lookup[j++] = l;
			}
			if(x>=0) l++;
		}
		return lookup;
	}

	@Override
	public IValue visit_dyadic(IIntArray a, ICharArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.rank()>1) throw new RankError();
		int n = computeTotalAxisLen(a, b);
		int[] lookup = makeIndexLookup(a, n);
		return new LazyCharArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public char get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return ' ';
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.rank()>1) throw new RankError();
		int n = computeTotalAxisLen(a, b);
		int[] lookup = makeIndexLookup(a, n);
		return new LazyDoubleArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public double get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return 0;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		if(a.rank()>1) throw new RankError();
		int n = computeTotalAxisLen(a, b);
		int[] lookup = makeIndexLookup(a, n);
		return new LazyBitArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public long get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return 0;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		int x = (int)a.get();
		int n=b.dims().axis(axis) * Math.abs(x);
		int[] lookup = new int[n];
		int j=0;
		for(int k=0; k<b.dims().axis(axis)*Math.abs(x); k++) {
			lookup[j++] = k/x;
		}
		return new LazyIntArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public long get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return 0;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		int x = (int)a.get();
		int n=b.dims().axis(axis) * Math.abs(x);
		int[] lookup = new int[n];
		int j=0;
		for(int k=0; k<b.dims().axis(axis)*Math.abs(x); k++) {
			lookup[j++] = k/x;
		}
		return new LazyCharArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public char get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return ' ';
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		int x = (int)a.get();
		int n=b.dims().axis(axis) * Math.abs(x);
		int[] lookup = new int[n];
		int j=0;
		for(int k=0; k<b.dims().axis(axis)*Math.abs(x); k++) {
			lookup[j++] = k/x;
		}
		return new LazyDoubleArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public double get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return 0;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IMixedArray b, int ax) {
		int axis = ax<0 ? b.rank()-1 : ax;
		int x = (int)a.get();
		int n=b.dims().axis(axis) * Math.abs(x);
		int[] lookup = new int[n];
		int j=0;
		for(int k=0; k<b.dims().axis(axis)*Math.abs(x); k++) {
			lookup[j++] = k/x;
		}
		return new LazyMixedArray(b.dims().replaceAxis(axis, n)) {
			@Override
			public IValue get(int index) {
				int[] ri = dims().reverseIndexInt(index);
				ri[axis] = lookup[ri[axis]];
				if(ri[axis]<0) return IntArray.EMPTY;
				return b.get(b.dims().calculateIndex(ri));
			}
		};
	}

	@Override
	public String getName() {
		return "replicate";
	}
}
