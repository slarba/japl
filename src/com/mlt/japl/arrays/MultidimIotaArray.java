package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class MultidimIotaArray extends BaseArray {

	public MultidimIotaArray() {
		super();
	}
	
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
		return new IntArray(dims.reverseIndex(idx%length()));
	}
	
	@Override
	public int depth() {
		return dims.length()==0 ? 1 : 2;
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		Array result = new NestedArray(newShape, new Array[newShape.length()]);
		for(int i=0; i<newShape.length(); i++) {
			result.setA(i, atA(i));
		}
		return result;
	}

	@Override
	public Array unInitializedCopy() {
		Array result = new NestedArray(dims(), new Array[dims.length()]);
		return result;
	}

	@Override
	public Array prototype() {
		return new IntArray(new long[rank()]);
	}

	@Override
	public int hashCode() {
		return 37*super.hashCode() + 57*dims.hashCode();
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		Array result = new NestedArray(resultDims, new Array[resultDims.length()]);
		return result;
	}
}
