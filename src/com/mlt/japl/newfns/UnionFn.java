package com.mlt.japl.newfns;

import java.util.HashSet;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;
import com.mlt.japl.tools.Dimensions;

public class UnionFn extends BaseFn {

	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return a;
	}
	
	@Override
	public IValue visit_monadic(ICharScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IMixedScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		long[] result = new long[set.size()];
		int i=0;
		for(Long l : set)
			result[i++] = l;
		return new IntArray(new Dimensions(result.length), result);
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		double[] result = new double[set.size()];
		int i=0;
		for(Double l : set)
			result[i++] = l;
		return new DoubleArray(new Dimensions(result.length), result);
	}
	
	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		char[] result = new char[set.size()];
		int i=0;
		for(Character l : set)
			result[i++] = l;
		return new CharArray(new Dimensions(result.length), result);
	}

	@Override
	public IValue visit_monadic(IMixedArray a, int axis) {
		HashSet<IValue> set = new HashSet<IValue>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		IValue[] result = new IValue[set.size()];
		int i=0;
		for(IValue l : set)
			result[i++] = l;
		return new MixedArray(new Dimensions(result.length), result);
	}
	
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		for(int i=0; i<b.length(); i++)
			set.add(b.get(i));
		long[] result = new long[set.size()];
		int i=0;
		for(Long l : set)
			result[i++] = l;
		return new IntArray(new Dimensions(result.length), result);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		for(int i=0; i<b.length(); i++)
			set.add(b.get(i));
		double[] result = new double[set.size()];
		int i=0;
		for(Double l : set)
			result[i++] = l;
		return new DoubleArray(new Dimensions(result.length), result);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i=0; i<a.length(); i++)
			set.add((double)a.get(i));
		for(int i=0; i<b.length(); i++)
			set.add(b.get(i));
		double[] result = new double[set.size()];
		int i=0;
		for(Double l : set)
			result[i++] = l;
		return new DoubleArray(new Dimensions(result.length), result);
	}
	
	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		for(int i=0; i<b.length(); i++)
			set.add((double)b.get(i));
		double[] result = new double[set.size()];
		int i=0;
		for(Double l : set)
			result[i++] = l;
		return new DoubleArray(new Dimensions(result.length), result);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<a.length(); i++)
			set.add(a.get(i));
		for(int i=0; i<b.length(); i++)
			set.add(b.get(i));
		char[] result = new char[set.size()];
		int i=0;
		for(Character l : set)
			result[i++] = l;
		return new CharArray(new Dimensions(result.length), result);
	}
	
	@Override
	public IValue visit_dyadic(ICharArray a, IIntArray b, int axis) {
		HashSet<IValue> set = new HashSet<IValue>();
		for(int i=0; i<a.length(); i++)
			set.add(new CharScalar(a.get(i)));
		for(int i=0; i<b.length(); i++)
			set.add(new IntScalar(b.get(i)));
		IValue[] result = new IValue[set.size()];
		result = set.toArray(result);
		return new MixedArray(new Dimensions(result.length), result);
	}

}
