package com.mlt.japl.arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class MultidimIotaArray extends BaseArray {

	public MultidimIotaArray(Dimensions d) {
		super(d);
	}
	
	@Override
	public int type() {
		return NESTED;
	}

	@Override
	public int actualLength() {
		return dims.length();
	}

	@Override
	public Array atA(int idx) {
		return new IntArray(dims.reverseIndex(idx));
	}
	
	@Override
	public int depth() {
		return 2;
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		Array result = new NestedArray(newShape, new Array[newShape.length()]);
		for(int i=0; i<length(); i++) {
			result.setA(i, atA(i));
		}
		return result;
	}

	@Override
	public Array unInitializedCopy() {
		Array result = new NestedArray(dims(), new Array[length()]);
		return result;
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		Array result = new NestedArray(resultDims, new Array[resultDims.length()]);
		return result;
	}
}
