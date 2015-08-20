package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.arrays.NestedArrayImpl;
import com.mlt.japl.errors.AplError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class ArrayFactory {
	
	public static Array makeScalarOfType(int type) {
		switch(type) {
		case Array.BIT:
		case Array.INTEGER:   return new IntScalar();
		case Array.DOUBLE:    return new DoubleScalar();
		case Array.CHARACTER: return new CharScalar();
		case Array.MIXED:    return new ArrayScalar();
		default:
			throw new AplError();
		}		
	}

	public static Array makeArrayOfType(int type, Dimensions d) {
		switch(type) {
		case Array.BIT:   		  return new BitArray(d, true, d.length());
		case Array.INTEGER:		  return new IntArrayImpl(d, true, d.length());
		case Array.DOUBLE:		  return new DoubleArray(d, true, d.length());
		case Array.CHARACTER:	  return new CharArray(d, true, d.length());
		case Array.MIXED:		  return new NestedArrayImpl(d, true, d.length());
		default:
			throw new AplError();
		}		
	}
	
//	public static Array makeSimilarArrayOfType(int type, Array a) {
//		switch(type) {
//		case Array.BIT:   		  return new BitArray(a.dims(), true, a.length());
//		case Array.INTEGER:		  return new IntArray(a.dims(), true, a.length());
//		case Array.DOUBLE:		  return new DoubleArray(a.dims(), true, a.length());
//		case Array.CHARACTER:	  return new CharArray(a.dims(), true, a.length());
//		case Array.MIXED:		  return new NestedArray(a.dims(), true, a.length());
//		default:
//			throw new AplError();
//		}		
//	}

	public static Array makeSimilarArrayOfTypeWithActualLength(int type, Array a, int len) {
		switch(type) {
		case Array.BIT:   		  return new BitArray(a.dims(), true, len);
		case Array.INTEGER:		  return new IntArrayImpl(a.dims(), true, len);
		case Array.DOUBLE:		  return new DoubleArray(a.dims(), true, len);
		case Array.CHARACTER:	  return new CharArray(a.dims(), true, len);
		case Array.MIXED:		  return new NestedArrayImpl(a.dims(), true, len);
		default:
			throw new AplError();
		}		
	}

}
