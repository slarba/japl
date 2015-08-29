package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyCharArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.tools.Dimensions;

public class TakeFn extends BaseFn {

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		int[] ds = new int[a.length()];
		for(int i=0; i<ds.length; i++) ds[i] = (int)Math.abs(a.get(i));
		return new LazyIntArray(new Dimensions(ds)) {
			@Override
			public long get(int index) {
				int[] idx = dims().reverseIndexInt(index);
				for(int i=0; i<idx.length; i++) {
					if(idx[i] >= b.dims().axis(i)) return 0;
				}
				return b.get(b.dims().calculateIndex(idx));
			}
		};
	}


	@Override
	public IValue visit_dyadic(IIntArray a, ICharArray b, int axis) {
		int[] ds = new int[a.length()];
		for(int i=0; i<ds.length; i++) ds[i] = (int)Math.abs(a.get(i));
		return new LazyCharArray(new Dimensions(ds)) {
			@Override
			public char get(int index) {
				int[] idx = dims().reverseIndexInt(index);
				for(int i=0; i<idx.length; i++) {
					if(idx[i] >= b.dims().axis(i)) return ' ';
				}
				return b.get(b.dims().calculateIndex(idx));
			}
		};
	}

}
