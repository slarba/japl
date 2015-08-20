package com.mlt.japl.arrays;

import com.mlt.japl.dispatch.DyadicVisitor;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class MultidimIotaArray extends BaseArray implements NestedArray {

	public MultidimIotaArray() {
		super();
	}
	
	public MultidimIotaArray(Dimensions d) {
		super(d);
	}
	
	@Override
	public int type() {
		return MIXED;
	}

	@Override
	public int actualLength() {
		return dims.length();
	}

	@Override
	public Array atA(int idx) {
		return new IntArrayImpl(dims.reverseIndex(idx%length()));
	}
	
	@Override
	public int depth() {
		return dims.length()==0 ? 1 : 2;
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		Array result = new NestedArrayImpl(newShape, new Array[newShape.length()]);
		for(int i=0; i<newShape.length(); i++) {
			result.setA(i, atA(i));
		}
		return result;
	}

	@Override
	public Array unInitializedCopy() {
		Array result = new NestedArrayImpl(dims(), new Array[dims.length()]);
		return result;
	}

	@Override
	public Array prototype() {
		return new IntArrayImpl(new long[rank()]);
	}

	@Override
	public int hashCode() {
		return 37*super.hashCode() + 57*dims.hashCode();
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		Array result = new NestedArrayImpl(resultDims, new Array[resultDims.length()]);
		return result;
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

}
