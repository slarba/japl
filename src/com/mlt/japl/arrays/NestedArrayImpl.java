package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.dispatch.DyadicVisitor;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class NestedArrayImpl extends BaseArray implements NestedArray {
	Array[] data;
	int depth;
	
	private static final Array[] EMPTY = new Array[] {};

	public NestedArrayImpl() {
		data = EMPTY;
		this.depth = 1;
	}
	
	public int[] asIntArray() {
		int[] result = new int[length()];
		for(int i=0; i<result.length; i++) {
			result[i] = (int)atI(i);
		}
		return result;
	}
	
	public NestedArrayImpl(Dimensions dims, boolean allocateEmpty, int actualLength) {
		super(dims);
		this.depth = 1;
		data = new Array[actualLength];
	}
	
	public NestedArrayImpl(Array... d) {
		super(new Dimensions(d.length));
		this.data = d;
		fixDepth();
	}
	
	private NestedArrayImpl(Dimensions dims, int depth, Array... data) {
		super(dims);
		this.data = data;
		this.depth = depth;
	}

	public NestedArrayImpl(Dimensions dims, Array... data) {
		super(dims);
		this.data = data;
		fixDepth();
	}

	private void fixDepth() {
		int depth = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i]==null) break;
			depth = Math.max(depth, data[i].depth()+1);			
		}
		this.depth = depth;		
	}
	
	@Override
	public Array prototype() {
		return new NestedArrayImpl();
	}

	@Override
	public int hashCode() {
		return 17*super.hashCode() + 27*depth + 17*Arrays.hashCode(data);
	}

	@Override
	public int depth() {
		return depth;
	}
	
	@Override
	public boolean isNested() {
		return depth>1;
	}

	@Override
	public int type() {
		return MIXED;
	}

	@Override
	public int actualLength() {
		return data.length;
	}

	/* (non-Javadoc)
	 * @see com.mlt.japl.arrays.INestedArray#atA(int)
	 */
	@Override
	public Array atA(int... indx) {
		return data[dims.calculateIndex(indx) % data.length];
	}

	/* (non-Javadoc)
	 * @see com.mlt.japl.arrays.INestedArray#atA(int)
	 */
	@Override
	public Array atA(int idx) {
		return data[idx % data.length];		
	}

	@Override
	public long atI(int idx) {
		return data[idx % data.length].atI(0);
	}

	@Override
	public double atD(int idx) {
		return data[idx % data.length].atD(0);
	}

	@Override
	public char atC(int idx) {
		return data[idx % data.length].atC(0);
	}
	
	/* (non-Javadoc)
	 * @see com.mlt.japl.arrays.INestedArray#setA(int, com.mlt.japl.iface.Array)
	 */
	@Override
	public void setA(int idx, Array val) {
		depth = Math.max(val.depth()+1, depth);
		data[idx] = val;
	}

	@Override
	public void setC(int idx, char val) {
		data[idx] = new CharScalar(val);
	}

	@Override
	public void setI(int idx, long val) {
		data[idx] = new IntScalar(val);
	}

	@Override
	public void setD(int idx, double val) {
		data[idx] = new DoubleScalar(val);
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		if(newShape.length()<length()) {
			return new NestedArrayImpl(newShape, depth, Arrays.copyOf(data, newShape.length()));
		}
		Array[] newData = new Array[length()];
		for(int i=0; i<newData.length; i++)
			newData[i] = atA(i);
		return new NestedArrayImpl(newShape, depth, newData);
	}

	@Override
	public Array unInitializedCopy() {
		return new NestedArrayImpl(dims(), new Array[dims.length()]);
	}
	
	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new ArrayScalar();
		return new NestedArrayImpl(resultDims, new Array[resultDims.length()]);
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
//		if(o instanceof NestedArray) {
//			NestedArray a = (NestedArray)o;
//			if(!a.dims().equals(dims)) return false;
//			for(int i=0; i<a.length(); i++) {
//				if(a.atA(i).equals(atA(i))) return false;
//			}
//			return true;
//		}
//		return false;
//	}	
}
