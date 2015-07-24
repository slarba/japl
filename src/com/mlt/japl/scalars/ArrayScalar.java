package com.mlt.japl.scalars;

import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class ArrayScalar extends BaseScalar {

	private Array data;
		
	public ArrayScalar() {
		data = null;
	}
	
	public ArrayScalar(Array value) {
		data = value;
	}
	
	@Override
	public int type() {
		return MIXED;
	}

	@Override
	public int depth() {
		return data.depth()+1;
	}

	@Override
	public Array atA(int idx) {
		return data;
	}

	@Override
	public void setA(int idx, Array val) {
		data = val;
	}
	
	@Override
	public Array unInitializedCopy() {
		return new ArrayScalar(data);
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new NestedArray(newShape, new Array[] { data });
	}

	@Override
	public Array morePreciseUnInitializedCopy(Array b) {
		return unInitializedCopy();  // no more precise than that
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		return unInitializedCopy();  // no more precise than that
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(data);
	}
}
