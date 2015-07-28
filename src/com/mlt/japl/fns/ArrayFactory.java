package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
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
		case Array.NESTED:    return new ArrayScalar();
		default:
			throw new AplError();
		}		
	}

	public static Array makeArrayOfType(int type, Dimensions d) {
		switch(type) {
		case Array.BIT:   		  return new BitArray(d, true, d.length());
		case Array.INTEGER:		  return new IntArray(d, true, d.length());
		case Array.DOUBLE:		  return new DoubleArray(d, true, d.length());
		case Array.CHARACTER:	  return new CharArray(d, true, d.length());
		case Array.NESTED:		  return new NestedArray(d, true, d.length());
		default:
			throw new AplError();
		}		
	}
	
	public static Array makeSimilarArrayOfType(int type, Array a) {
		switch(type) {
		case Array.BIT:   		  return new BitArray(a.dims(), true, a.length());
		case Array.INTEGER:		  return new IntArray(a.dims(), true, a.length());
		case Array.DOUBLE:		  return new DoubleArray(a.dims(), true, a.length());
		case Array.CHARACTER:	  return new CharArray(a.dims(), true, a.length());
		case Array.NESTED:		  return new NestedArray(a.dims(), true, a.length());
		default:
			throw new AplError();
		}		
	}

	public static Array makeSimilarArrayOfTypeWithActualLength(int type, Array a) {
		switch(type) {
		case Array.BIT:   		  return new BitArray(a.dims(), true, a.actualLength());
		case Array.INTEGER:		  return new IntArray(a.dims(), true, a.actualLength());
		case Array.DOUBLE:		  return new DoubleArray(a.dims(), true, a.actualLength());
		case Array.CHARACTER:	  return new CharArray(a.dims(), true, a.actualLength());
		case Array.NESTED:		  return new NestedArray(a.dims(), true, a.actualLength());
		default:
			throw new AplError();
		}		
	}

}
