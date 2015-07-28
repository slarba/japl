package com.mlt.japl.fns;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.AplError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public abstract class SpecialBaseFn implements Func {

	@Override
	public Array monadic(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		throw new ValenceError();
	}

//	private Array makeScalarOfType(int type) {
//		switch(type) {
//		case Array.BIT:
//		case Array.INTEGER:   return new IntScalar();
//		case Array.DOUBLE:    return new DoubleScalar();
//		case Array.CHARACTER: return new CharScalar();
//		case Array.NESTED:    return new ArrayScalar();
//		default:
//			throw new AplError();
//		}		
//	}

	
	public Array createResultArrayFor(Array a, int axis) {
		if(a.isScalar()) {
			return ArrayFactory.makeScalarOfType(resultTypeFor(a));
		}
		return ArrayFactory.makeSimilarArrayOfType(resultTypeFor(a), a);
	}

	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			if(b.isScalar()) {
				return ArrayFactory.makeScalarOfType(resultTypeFor(a, b));
			}
			return ArrayFactory.makeSimilarArrayOfType(resultTypeFor(a, b), b);
		}
		if(b.isScalar()) {
			return ArrayFactory.makeSimilarArrayOfType(resultTypeFor(a, b), a);			
		}
		checkEqualDimensionsAndRank(a, b);
		return ArrayFactory.makeSimilarArrayOfType(resultTypeFor(a, b), a);			
	}

	public void checkEqualDimensionsAndRank(Array a, Array b) {
		if(a.rank()!=b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
	}
	
	protected Array copyWithIterators(Array a, Array result, Iterator srcIterator,
			Iterator dstIterator) {
		switch(result.type()) {
		case Array.BIT:
		case Array.INTEGER:
			do {
				result.setI(dstIterator.index(), a.atI(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			} while(!srcIterator.isFinished());
			break;
		case Array.CHARACTER:
			while(!srcIterator.isFinished()) {
				result.setC(dstIterator.index(), a.atC(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			}
			break;
		case Array.DOUBLE:
			while(!srcIterator.isFinished()) {
				result.setD(dstIterator.index(), a.atD(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			}
			break;
		case Array.NESTED:
			while(!srcIterator.isFinished()) {
				result.setA(dstIterator.index(), a.atA(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			}
			break;
		}
		return result;
	}

	@Override
	public Array niladic() {
		throw new ValenceError();
	}
}
