package com.mlt.japl.newarrays.concrete;

import java.util.Arrays;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.ArrayBase;
import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
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
import com.mlt.japl.newfns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class MixedArray extends ArrayBase implements IMixedArray {
	public static final IValue EMPTY = new MixedArray(Dimensions.EMPTY_ARRAY, new IValue[0]);
	
	IValue[] data;
	int depth;
	
	public MixedArray(Dimensions dims, IValue[] data) {
		super(dims);
		this.data = data;
		depth = 1;
		for(int i=0; i<data.length; i++) depth = Math.max(depth, 1+data[i].depth());
	}

	@Override
	public int depth() {
		return depth;
	}
	
	@Override
	public IValue get(IMixedArray i) {
		Indexer indexer = new Indexer(i, this);
		int[] finalDims = indexer.computeResultDims();
		if(finalDims.length==0) return get(indexer.indexForSingle());
		Dimensions ds = new Dimensions(finalDims);
		IValue[] result = new IValue[ds.length()];

		for(int j=0; j<result.length; j++) {
			result[j] = get(indexer.step());
		}
		return new MixedArray(ds, result);
	}

	@Override
	public IValue get(int index) {
		return data[index%data.length];
	}

	@Override
	public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(ArrayVisitor visitor, IValue b, int axis) {
		return visitor.visit_first(this, b, axis);
	}

	@Override
	public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_monadic(ArrayVisitor visitor, int axis) {
		return visitor.visit_monadic(this, axis);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + depth;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MixedArray other = (MixedArray) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (depth != other.depth)
			return false;
		return true;
	}

	@Override
	public IValue reshape(int[] newShape) {
		return new MixedArray(new Dimensions(newShape), data);
	}

	@Override
	public String asString(PrintConfig conf) {
		return conf.print(this);
	}

	@Override
	public Class<?> getCorrespondingJavaClass() {
		return Object[].class;
	}

	@Override
	public Object coerceToJavaObject() {
		return data;
	}

	@Override
	public IValue getGeneric(int index) {
		return get(index);
	}

}
