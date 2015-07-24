package com.mlt.japl.arrays;

import java.math.BigInteger;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class IotaArray extends BaseArray {
	private int n;

	public IotaArray() {
		this.n = 0;
	}
	
	public IotaArray(Dimensions dims, int n) {
		super(dims);
		this.n = n;
	}
	
	public IotaArray(int n) {
		super(new Dimensions(n));
		this.n = n;
	}
	
	@Override
	public long atI(int idx) {
		return (idx%n)+1;
	}

	@Override
	public Array atA(int idx) {
		return new IntScalar(atI(idx));
	}

	@Override
	public int type() {
		return INTEGER;
	}
	
	@Override
	public int actualLength() {
		return n;
	}

	@Override
	public Array reshape(Dimensions newShape) {
		return new IotaArray(newShape, n);
	}

	@Override
	public Array unInitializedCopy() {
		return new IntArray(dims(), new long[n]);
	}

	@Override
	public Array morePreciseUnInitializedCopy(Array b) {
		switch(b.type()) {
		case DOUBLE: 		return new DoubleArray(dims(), new double[n]);
		case INTEGER:       return unInitializedCopy();
		case NESTED:         return unInitializedCopy();
		}
		throw new AplError();
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		return new DoubleArray(dims(), new double[n]);
	}

	@Override
	public Array ofSameTypeWithDimensions(Dimensions resultDims) {
		if(resultDims.rank()==0) return new IntScalar();
		return new IntArray(resultDims, new long[resultDims.length()]);
	}

	public long sum() {
		return (n*(n+1))/2;
	}
}
