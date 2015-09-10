package com.mlt.japl.newfns;

import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class ReplicateFn extends BaseFn {

	private boolean firstAxis;

	public ReplicateFn(boolean firstAxis) {
		this.firstAxis = firstAxis;
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
	public IValue visit_dyadic(IIntArray a, IIntArray b, int ax) {
		if(a.rank()>1) throw new RankError();
		int axis = ax<0 ? b.rank()-1 : ax;
		int n=0;
		for(int i=0; i<a.length(); i++) {
			int x = (int)a.get(i);
			n += Math.abs(x);
		}
		int[] lookup = new int[n];
		int j=0;
		for(int i=0; i<a.length(); i++) {
			int x = (int)a.get(i);
			for(int k=0; k<Math.abs(x); k++) {
				if(x<0) lookup[j++] = -i;
				else lookup[j++] = i;
			}
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
	public String getName() {
		return "replicate";
	}
}
