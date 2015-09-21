package com.mlt.japl.newarrays.concrete;

import java.util.Arrays;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.ArrayBase;
import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
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

public class DoubleArray extends ArrayBase implements IDoubleArray {
	double[] data;

	public DoubleArray(Dimensions dims, double[] data) {
		super(dims);
		this.data = data;
	}
	
	@Override
	public double get(int index) {
		return data[index%data.length];
	}

	@Override
	public IValue getGeneric(int index) {
		return new DoubleScalar(get(index));
	}

	
	@Override
	public IValue get(IMixedArray i) {
		Indexer indexer = new Indexer(i, this);
		int[] finalDims = indexer.computeResultDims();
		if(finalDims.length==0) return new DoubleScalar(get(indexer.indexForSingle()));
		Dimensions ds = new Dimensions(finalDims);
		double[] result = new double[ds.length()];

		for(int j=0; j<result.length; j++) {
			result[j] = get(indexer.step());
		}
		return new DoubleArray(ds, result);
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
		DoubleArray other = (DoubleArray) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		return true;
	}

	@Override
	public IValue reshape(int[] newShape) {
		return new DoubleArray(new Dimensions(newShape), data);
	}
	
	@Override
	public String asString(PrintConfig config) {
		return config.print(this);
	}

	@Override
	public Class<?> getCorrespondingJavaClass() {
		return double[].class;
	}

	@Override
	public Object coerceToJavaObject() {
		return data;
	}

	public double[] data() {
		return data;
	}

}
