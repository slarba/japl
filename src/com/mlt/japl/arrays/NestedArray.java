package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class NestedArray extends BaseArray {
	Array[] data;
	int depth;
	
	private static final Array[] EMPTY = new Array[] {};

	public NestedArray() {
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
	
	public NestedArray(Dimensions dims, boolean allocateEmpty, int actualLength) {
		super(dims);
		this.depth = 1;
		data = new Array[actualLength];
	}
	
	public NestedArray(Array... d) {
		super(new Dimensions(d.length));
		this.data = d;
		fixDepth();
	}
	
	private NestedArray(Dimensions dims, int depth, Array... data) {
		super(dims);
		this.data = data;
		this.depth = depth;
	}

	public NestedArray(Dimensions dims, Array... data) {
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
		return new NestedArray();
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

	@Override
	public Array atA(int... indx) {
		return data[dims.calculateIndex(indx) % data.length];
	}

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
			return new NestedArray(newShape, depth, Arrays.copyOf(data, newShape.length()));
		}
		Array[] newData = new Array[length()];
		for(int i=0; i<newData.length; i++)
			newData[i] = atA(i);
		return new NestedArray(newShape, depth, newData);
	}

	@Override
	public Array unInitializedCopy() {
		return new NestedArray(dims(), new Array[dims.length()]);
	}
	
	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new ArrayScalar();
		return new NestedArray(resultDims, new Array[resultDims.length()]);
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
