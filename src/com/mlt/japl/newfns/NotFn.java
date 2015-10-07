package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.tools.Dimensions;

import it.unimi.dsi.fastutil.chars.CharArrayList;
import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

public class NotFn extends BaseFn {
	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return new LazyIntArray(a.dims()) {
			@Override
			public long get(int index) {
				return ~a.get(index);
			}
		};
	}

	@Override
	public IValue visit_monadic(IBitArray a, int axis) {
		return new LazyBitArray(a.dims()) {
			@Override
			public long get(int index) {
				return a.get(index)^1;
			}
		};
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		if(a.get()!=b.get()) return b;
		else return IntArray.EMPTY;
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		if(a.get()!=b.get()) return b;
		else return IntArray.EMPTY;
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharScalar b, int axis) {
		if(a.get()!=b.get()) return b;
		else return IntArray.EMPTY;
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		LongSet s = new LongOpenHashSet();
		for(int i=0; i<a.length(); i++) s.add(a.get(i));
		LongArrayList l = new LongArrayList();
		for(int i=0; i<b.length(); i++) {
			long val = b.get(i);
			if(!s.contains(val)) l.add(val);
		}
		return new IntArray(new Dimensions(l.size()), 
				l.toLongArray());
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		LongSet s = new LongOpenHashSet();
		for(int i=0; i<a.length(); i++) s.add(a.get(i));
		DoubleArrayList l = new DoubleArrayList();
		for(int i=0; i<b.length(); i++) {
			double val = b.get(i);
			if(!s.contains(val)) l.add(val);
		}
		return new DoubleArray(new Dimensions(l.size()), 
				l.toDoubleArray());
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		DoubleSet s = new DoubleOpenHashSet();
		for(int i=0; i<a.length(); i++) s.add(a.get(i));
		DoubleArrayList l = new DoubleArrayList();
		for(int i=0; i<b.length(); i++) {
			double val = b.get(i);
			if(!s.contains(val)) l.add(val);
		}
		return new DoubleArray(new Dimensions(l.size()), 
				l.toDoubleArray());
	}
	
	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		LongArrayList l = new LongArrayList();
		for(int i=0; i<b.length(); i++) {
			long val = b.get(i);
			if(val!=a.get()) l.add(val);
		}
		return new IntArray(new Dimensions(l.size()), 
				l.toLongArray());
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharArray b, int axis) {
		CharArrayList l = new CharArrayList();
		for(int i=0; i<b.length(); i++) {
			char val = b.get(i);
			if(val!=a.get()) l.add(val);
		}
		return new CharArray(new Dimensions(l.size()), 
				l.toCharArray());
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		CharSet s = new CharOpenHashSet();
		for(int i=0; i<a.length(); i++) s.add(a.get(i));
		CharArrayList l = new CharArrayList();
		for(int i=0; i<b.length(); i++) {
			char val = b.get(i);
			if(!s.contains(val)) l.add(val);
		}
		return new CharArray(new Dimensions(l.size()), l.toCharArray());
	}
	
	@Override
	public String getName() {
		return "not";
	}

}
