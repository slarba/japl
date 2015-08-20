package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.dispatch.DyadicVisitor;
import com.mlt.japl.iface.Array;

public class NewDispatchFn implements DyadicVisitor {

	@Override
	public Array visit_first(IntArray a, Array b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public Array visit_first(DoubleArray a, Array b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public Array visit_first(CharArray a, Array b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public Array visit_first(NestedArray a, Array b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public Array visit_first(BitArray a, Array b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public Array visit_first(IotaArray a, Array b) {
		return b.accept_dyadic(a, this);
	}
	
	// -----------------

	@Override
	public Array visit_dyadic(IntArray a, IntArray b) {
		System.out.println("II");
		return null;
	}

	@Override
	public Array visit_dyadic(DoubleArray a, DoubleArray b) {
		System.out.println("DD");
		return null;
	}

	@Override
	public Array visit_dyadic(CharArray a, CharArray b) {
		System.out.println("CC");
		return null;
	}

	@Override
	public Array visit_dyadic(NestedArray a, NestedArray b) {
		System.out.println("NN");
		return null;
	}

	@Override
	public Array visit_dyadic(BitArray a, BitArray b) {
		System.out.println("BB");
		return null;
	}

	@Override
	public Array visit_dyadic(IotaArray a, IotaArray b) {
		System.out.println("ii");
		return null;
	}

	@Override
	public Array visit_dyadic(IntArray a, DoubleArray b) {
		System.out.println("ID");
		return null;
	}

	@Override
	public Array visit_dyadic(IntArray a, CharArray b) {
		System.out.println("IC");
		return null;
	}

	@Override
	public Array visit_dyadic(IntArray a, NestedArray b) {
		System.out.println("IN");
		return null;
	}

	@Override
	public Array visit_dyadic(IntArray a, BitArray b) {
		System.out.println("IB");
		return null;
	}

	@Override
	public Array visit_dyadic(IntArray a, IotaArray b) {
		System.out.println("Ii");
		return null;
	}

	@Override
	public Array visit_dyadic(DoubleArray a, IntArray b) {
		System.out.println("DI");
		return null;
	}

	@Override
	public Array visit_dyadic(DoubleArray a, CharArray b) {
		System.out.println("DC");
		return null;
	}

	@Override
	public Array visit_dyadic(DoubleArray a, NestedArray b) {
		System.out.println("DN");
		return null;
	}

	@Override
	public Array visit_dyadic(DoubleArray a, BitArray b) {
		System.out.println("DB");
		return null;
	}

	@Override
	public Array visit_dyadic(DoubleArray a, IotaArray b) {
		System.out.println("Di");
		return null;
	}

	@Override
	public Array visit_dyadic(CharArray a, IntArray b) {
		System.out.println("CI");
		return null;
	}

	@Override
	public Array visit_dyadic(CharArray a, DoubleArray b) {
		System.out.println("CD");
		return null;
	}

	@Override
	public Array visit_dyadic(CharArray a, NestedArray b) {
		System.out.println("CN");
		return null;
	}

	@Override
	public Array visit_dyadic(CharArray a, BitArray b) {
		System.out.println("CB");
		return null;
	}

	@Override
	public Array visit_dyadic(CharArray a, IotaArray b) {
		System.out.println("Ci");
		return null;
	}

	@Override
	public Array visit_dyadic(NestedArray a, IntArray b) {
		System.out.println("NI");
		return null;
	}

	@Override
	public Array visit_dyadic(NestedArray a, DoubleArray b) {
		System.out.println("ND");
		return null;
	}

	@Override
	public Array visit_dyadic(NestedArray a, CharArray b) {
		System.out.println("NC");
		return null;
	}

	@Override
	public Array visit_dyadic(NestedArray a, BitArray b) {
		System.out.println("NB");
		return null;
	}

	@Override
	public Array visit_dyadic(NestedArray a, IotaArray b) {
		System.out.println("Ni");
		return null;
	}

	@Override
	public Array visit_dyadic(BitArray a, IntArray b) {
		System.out.println("BI");
		return null;
	}

	@Override
	public Array visit_dyadic(BitArray a, DoubleArray b) {
		System.out.println("BD");
		return null;
	}

	@Override
	public Array visit_dyadic(BitArray a, CharArray b) {
		System.out.println("BC");
		return null;
	}

	@Override
	public Array visit_dyadic(BitArray a, NestedArray b) {
		System.out.println("BN");
		return null;
	}

	@Override
	public Array visit_dyadic(BitArray a, IotaArray b) {
		System.out.println("Bi");
		return null;
	}

	@Override
	public Array visit_dyadic(IotaArray a, IntArray b) {
		System.out.println("iI");
		return null;
	}

	@Override
	public Array visit_dyadic(IotaArray a, DoubleArray b) {
		System.out.println("iD");
		return null;
	}

	@Override
	public Array visit_dyadic(IotaArray a, CharArray b) {
		System.out.println("iC");
		return null;
	}

	@Override
	public Array visit_dyadic(IotaArray a, NestedArray b) {
		System.out.println("iN");
		return null;
	}

	@Override
	public Array visit_dyadic(IotaArray a, BitArray b) {
		System.out.println("iB");
		return null;
	}

	public Array dyadic(Array a, Array b) {
		return a.accept_dyadic(this, b);
	}

}
