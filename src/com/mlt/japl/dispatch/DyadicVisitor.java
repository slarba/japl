package com.mlt.japl.dispatch;

import com.mlt.japl.iface.*;
import com.mlt.japl.arrays.*;

public interface DyadicVisitor {
	Array visit_first(IntArray a, Array b);
	Array visit_first(DoubleArray a, Array b);
	Array visit_first(CharArray a, Array b);
	Array visit_first(NestedArray a, Array b);
	Array visit_first(BitArray a, Array b);
	Array visit_first(IotaArray a, Array b);
	Array visit_first(SpecialArray a, Array b);
	
	//Array visit_dyadic(BaseArray a, BaseArray b);
	Array visit_dyadic(IntArray a, IntArray b);
	Array visit_dyadic(DoubleArray a, DoubleArray b);
	Array visit_dyadic(CharArray a, CharArray b);
	Array visit_dyadic(NestedArray a, NestedArray b);
	Array visit_dyadic(BitArray a, BitArray b);
	Array visit_dyadic(IotaArray a, IotaArray b);
	Array visit_dyadic(SpecialArray a, SpecialArray b);
	
	Array visit_dyadic(IntArray a, DoubleArray b);
	Array visit_dyadic(IntArray a, CharArray b);
	Array visit_dyadic(IntArray a, NestedArray b);
	Array visit_dyadic(IntArray a, BitArray b);
	Array visit_dyadic(IntArray a, IotaArray b);
	Array visit_dyadic(IntArray a, SpecialArray b);

	Array visit_dyadic(DoubleArray a, IntArray b);
	Array visit_dyadic(DoubleArray a, CharArray b);
	Array visit_dyadic(DoubleArray a, NestedArray b);
	Array visit_dyadic(DoubleArray a, BitArray b);
	Array visit_dyadic(DoubleArray a, IotaArray b);
	Array visit_dyadic(DoubleArray a, SpecialArray b);

	Array visit_dyadic(CharArray a, IntArray b);
	Array visit_dyadic(CharArray a, DoubleArray b);
	Array visit_dyadic(CharArray a, NestedArray b);
	Array visit_dyadic(CharArray a, BitArray b);
	Array visit_dyadic(CharArray a, IotaArray b);
	Array visit_dyadic(CharArray a, SpecialArray b);

	Array visit_dyadic(NestedArray a, IntArray b);
	Array visit_dyadic(NestedArray a, DoubleArray b);
	Array visit_dyadic(NestedArray a, CharArray b);
	Array visit_dyadic(NestedArray a, BitArray b);
	Array visit_dyadic(NestedArray a, IotaArray b);
	Array visit_dyadic(NestedArray a, SpecialArray b);

	Array visit_dyadic(BitArray a, IntArray b);
	Array visit_dyadic(BitArray a, DoubleArray b);
	Array visit_dyadic(BitArray a, CharArray b);
	Array visit_dyadic(BitArray a, NestedArray b);
	Array visit_dyadic(BitArray a, IotaArray b);
	Array visit_dyadic(BitArray a, SpecialArray b);

	Array visit_dyadic(IotaArray a, IntArray b);
	Array visit_dyadic(IotaArray a, DoubleArray b);
	Array visit_dyadic(IotaArray a, CharArray b);
	Array visit_dyadic(IotaArray a, NestedArray b);
	Array visit_dyadic(IotaArray a, BitArray b);
	Array visit_dyadic(IotaArray a, SpecialArray b);
	
	Array visit_dyadic(SpecialArray a, IntArray b);
	Array visit_dyadic(SpecialArray a, DoubleArray b);
	Array visit_dyadic(SpecialArray a, CharArray b);
	Array visit_dyadic(SpecialArray a, NestedArray b);
	Array visit_dyadic(SpecialArray a, BitArray b);
	Array visit_dyadic(SpecialArray a, IotaArray b);
}
