package com.mlt.japl.fns;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class RhoFn extends SpecialBaseFn {

	
	@Override
	public Array monadic(Array a, int axis) {
		if(a.rank()==0) return new IntArray();
		int[] adims = a.dims().asArray();
		long[] dims = new long[adims.length];
		for(int i=0; i<dims.length; i++)
			dims[i] = adims[i];
		return new IntArray(dims);
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(a.type()!=Array.INTEGER) throw new DomainError();
		if(a.rank()>1) throw new RankError();
		int alen = a.length();
		if(alen==0) return new IntArray();
		int[] newDims = new int[alen];
		for(int i=0; i<newDims.length; i++)
			newDims[i] = (int)a.atI(i);
		return b.reshape(new Dimensions(newDims));
	}

	@Override
	public int resultTypeFor(Array a) {
		return Array.INTEGER;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}
	
	@Override
	public String getName() {
		return "rho";
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

}
