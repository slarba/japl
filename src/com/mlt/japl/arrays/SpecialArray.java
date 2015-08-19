package com.mlt.japl.arrays;

import com.mlt.japl.dispatch.DyadicVisitor;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public abstract class SpecialArray extends BaseArray {

	public SpecialArray(Dimensions d) {
		super(d);
	}

	public SpecialArray() {
		super();
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
