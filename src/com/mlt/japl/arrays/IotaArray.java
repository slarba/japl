package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.dispatch.DyadicVisitor;
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
	public double atD(int idx) {
		return (double)atI(idx);
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
		if(newShape.length()<length()) {
			Array r = new IntArray(newShape, new long[newShape.length()]); 
			for(int i=0; i<newShape.length(); i++)
				r.setI(i, atI(i));
			return r;
		}
		long[] newData = new long[length()];
		for(int i=0; i<newData.length; i++)
			newData[i] = atI(i);
		return new IntArray(newShape, newData);
	}

	@Override
	public Array unInitializedCopy() {
		return new IntArray(dims(), new long[dims.length()]);
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new IntScalar();
		return new IntArray(resultDims, new long[resultDims.length()]);
	}

	public long sum() {
		return (n*(n+1))/2;
	}
	
	@Override
	public Array prototype() {
		return new IntScalar(0);
	}

	@Override
	public int hashCode() {
		return 37*super.hashCode() + 17*Long.hashCode(n);
	}

	@Override
	public Array accept_dyadic(DyadicVisitor visitor, Array b) {
		return visitor.visit_first(this, b);
	}
	public Array accept_dyadic(IntArray a, DyadicVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}
	
	public Array accept_dyadic(DoubleArray a, DyadicVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}
	
	public Array accept_dyadic(CharArray a, DyadicVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}
	
	public Array accept_dyadic(BitArray a, DyadicVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}
	
	public Array accept_dyadic(NestedArray a, DyadicVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}
	
	public Array accept_dyadic(IotaArray a, DyadicVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

//	@Override
//	public boolean equals(Object o) {
//		if(o==this) return true;
//		if(o instanceof IotaArray) {
//			IotaArray a = (IotaArray)o;
//			if(!a.dims().equals(dims())) return false;
//			return n == a.n;
//		}
//		if(o instanceof IntArray) {
//			IntArray a = (IntArray)o;
//			if(!a.dims().equals(dims())) return false;
//			for(int i=0; i<a.length(); i++) {
//				if(a.atI(i)!=atI(i)) return false;
//			}
//			return true;
//		}
//		return false;
//	}

}
