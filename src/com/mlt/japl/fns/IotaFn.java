package com.mlt.japl.fns;

import java.util.HashMap;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.MultidimIotaArray;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class IotaFn extends SpecialBaseFn {

	@Override
	public Array monadic(Array a, int axis) {
		if(a.rank()>1) throw new RankError();
		if(a.length()>1) {
			int[] ds = new int[a.length()];
			for(int i=0; i<a.length(); i++)
				ds[i] = (int)a.atI(i);
			return new MultidimIotaArray(new Dimensions(ds));
		}
		long v = a.atI(0);
		if(v==0) return new IntArray();
		return new IotaArray((int)a.atI(0));
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		HashMap<Array, Integer> map = new HashMap<Array, Integer>();
		for(int i=0; i<a.length(); i++) {
			Array key = a.atA(i); 
			map.putIfAbsent(key, i+1);
		}
		
		if(b.isScalar()) {
			return new IntArray(map.get(b.atA(0)));
		}
		
		int alen = a.length();
		Array result = new IntArray(new Dimensions(b.length()), new long[b.length()]);
		
		for(int i=0; i<b.length(); i++) {
			result.setI(i, map.getOrDefault(b.atA(i), alen+1));
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "iota";
	}

	@Override
	public int resultTypeFor(Array a) {
		if(a.rank()==0) return Array.INTEGER;
		return Array.MIXED;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
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
