package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;

import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

public class ExistsFn extends BaseFn {

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		LongSet set = new LongOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(a.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		DoubleSet set = new DoubleOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(a.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		LongSet set = new LongOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		LongSet set = new LongOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		DoubleSet set = new DoubleOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(a.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
		LongSet set = new LongOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}
	
	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		CharSet set = new CharOpenHashSet();
		for(int i=0; i<b.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}
	
	@Override
	public String getName() {
		return "exists";
	}

}
