package com.mlt.japl.dispatch;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;

public interface DyadicVisitor {
	Array visit_first(IntArray a, Array b);
	Array visit_first(DoubleArray a, Array b);
	Array visit_first(CharArray a, Array b);
	Array visit_first(NestedArray a, Array b);
	Array visit_first(BitArray a, Array b);
	Array visit_first(IotaArray a, Array b);
	
	Array visit_dyadic(IntArray a, IntArray b);
	Array visit_dyadic(DoubleArray a, DoubleArray b);
	Array visit_dyadic(CharArray a, CharArray b);
	Array visit_dyadic(NestedArray a, NestedArray b);
	Array visit_dyadic(BitArray a, BitArray b);
	Array visit_dyadic(IotaArray a, IotaArray b);
	
	Array visit_dyadic(IntArray a, DoubleArray b);
	Array visit_dyadic(IntArray a, CharArray b);
	Array visit_dyadic(IntArray a, NestedArray b);
	Array visit_dyadic(IntArray a, BitArray b);
	Array visit_dyadic(IntArray a, IotaArray b);

	Array visit_dyadic(DoubleArray a, IntArray b);
	Array visit_dyadic(DoubleArray a, CharArray b);
	Array visit_dyadic(DoubleArray a, NestedArray b);
	Array visit_dyadic(DoubleArray a, BitArray b);
	Array visit_dyadic(DoubleArray a, IotaArray b);

	Array visit_dyadic(CharArray a, IntArray b);
	Array visit_dyadic(CharArray a, DoubleArray b);
	Array visit_dyadic(CharArray a, NestedArray b);
	Array visit_dyadic(CharArray a, BitArray b);
	Array visit_dyadic(CharArray a, IotaArray b);

	Array visit_dyadic(NestedArray a, IntArray b);
	Array visit_dyadic(NestedArray a, DoubleArray b);
	Array visit_dyadic(NestedArray a, CharArray b);
	Array visit_dyadic(NestedArray a, BitArray b);
	Array visit_dyadic(NestedArray a, IotaArray b);

	Array visit_dyadic(BitArray a, IntArray b);
	Array visit_dyadic(BitArray a, DoubleArray b);
	Array visit_dyadic(BitArray a, CharArray b);
	Array visit_dyadic(BitArray a, NestedArray b);
	Array visit_dyadic(BitArray a, IotaArray b);

	Array visit_dyadic(IotaArray a, IntArray b);
	Array visit_dyadic(IotaArray a, DoubleArray b);
	Array visit_dyadic(IotaArray a, CharArray b);
	Array visit_dyadic(IotaArray a, NestedArray b);
	Array visit_dyadic(IotaArray a, BitArray b);
}
