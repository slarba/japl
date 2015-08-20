package com.mlt.japl.dispatch;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;

public interface DyadicAcceptor {
	Array accept_dyadic(DyadicVisitor visitor, Array b);

	Array accept_dyadic(IntArray a, DyadicVisitor visitor);
	Array accept_dyadic(DoubleArray a, DyadicVisitor visitor);
	Array accept_dyadic(CharArray a, DyadicVisitor visitor);
	Array accept_dyadic(BitArray a, DyadicVisitor visitor);
	Array accept_dyadic(NestedArray a, DyadicVisitor visitor);
	Array accept_dyadic(IotaArray a, DyadicVisitor visitor);
}
