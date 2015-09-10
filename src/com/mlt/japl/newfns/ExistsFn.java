package com.mlt.japl.newfns;

import java.util.HashSet;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;

public class ExistsFn extends BaseFn {

	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(a.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(a.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(a.get(index)) ? 1 : 0;
			}			
		};
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return set.contains(b.get(index)) ? 1 : 0;
			}			
		};
	}
	
	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<a.length(); i++) set.add(b.get(i));
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
