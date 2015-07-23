package com.mlt.japl.arrays;

import com.mlt.japl.Dimensions;
import com.mlt.japl.iface.Array;

public class NestedArray extends BaseArray {
	Array[] data;
	int depth;
	
	private static final Array[] EMPTY = new Array[] {};

	public NestedArray() {
		data = EMPTY;
		this.depth = 1;
	}
		
	private NestedArray(Dimensions dims, int depth, Array... data) {
		super(dims);
		this.data = data;
		this.depth = depth;
	}

	public NestedArray(Dimensions dims, Array... data) {
		super(dims);
		this.data = data;
		int depth = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i]==null) break;
			depth = Math.max(depth, data[i].depth()+1);			
		}
		this.depth = depth;
	}
	
	@Override
	public int depth() {
		return depth;
	}
	
	@Override
	public boolean isNested() {
		return true;
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
	public void setA(int idx, Array val) {
		depth = Math.max(val.depth()+1, depth);
		data[idx] = val;
	}
	
	@Override
	public Array reshape(int... newShape) {
		return new NestedArray(new Dimensions(newShape), depth, data);
	}

	@Override
	public Array reshape(Dimensions newShape) {
		return new NestedArray(newShape, depth, data);
	}

	public static Array similarTo(Array a) {
		return new NestedArray(a.dims(), 1, new Array[a.actualLength()]);
	}

	@Override
	public Array unInitializedCopy() {
		return new NestedArray(dims(), new Array[data.length]);
	}

	@Override
	public Array morePreciseUnInitializedCopy(Array b) {
		return unInitializedCopy();
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		return unInitializedCopy();
	}
	
}
