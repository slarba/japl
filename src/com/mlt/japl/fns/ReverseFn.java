package com.mlt.japl.fns;


import com.mlt.japl.arrays.RotatedArray;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ReverseFn extends SpecialBaseFn {

	private boolean first;

	public ReverseFn() {
		first = true;
	}

	public ReverseFn(boolean first) {
		this.first = first;
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		if(a.isScalar()) return a;
		
		if(axis<0) {
			if(first) axis = 0;
			else axis = a.rank()-1;
		}

		Array result = a.unInitializedReshapedCopy(a.dims());
		Iterator srcIterator = a.dims().iteratorAlongAxis(axis);
		Iterator dstIterator = result.dims().reverseIteratorAlongAxis(axis);

		return copyWithIterators(a, result, srcIterator, dstIterator);
	}

	/*
		if(b.getRank()==0) return b;
		if(a.getRank()!=0) throw new ValenceError();
		int offset = a.get(0).coerceToInt();
		axis = 0;
		
		Indexer indexer = new Indexer(b.getDimensions());
		
		Cell[] result = new Cell[b.getLength()];
		
		for(int i=0; i<result.length; i++) {
			result[indexer.getIndexWithMod(indexer.getIter(), axis, offset)] = b.get(indexer.index());
			indexer.step();
		}
		return new CellArray(result, b.getDimensions());
	 * (non-Javadoc)
	 * @see com.mlt.japl.fns.SpecialBaseFn#dyadic(com.mlt.japl.iface.Array, com.mlt.japl.iface.Array, int)
	 */

//	@Override
//	public Array dyadic(Array a, Array b, int axis) {
//		// rotate
//		if(b.isScalar()) return b;
//		
//		if(!a.isScalar()) throw new LengthError();
//		long offset = a.atI(0);
//		
//		if(axis<0) {
//			if(first) axis = 0;
//			else axis = b.rank()-1;
//		}
//		
//		Array result = b.unInitializedReshapedCopy(b.dims());
//		Iterator srcIterator = b.dims().offsetIteratorAlongAxis(axis, offset);
//		Iterator dstIterator = b.dims().iteratorAlongAxis(axis);
//		return copyWithIterators(b, result, srcIterator, dstIterator);
//	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		// rotate
		if(b.isScalar()) return b;
		
		if(!a.isScalar()) throw new LengthError();
		int offset = (int)a.atI(0);
		
		if(axis<0) {
			if(first) axis = 0;
			else axis = b.rank()-1;
		}

		if(b instanceof RotatedArray) {
			RotatedArray old = (RotatedArray)b;
			return old.modifyRotations(axis, offset);
		}
		int[] rotations = new int[b.rank()];
		rotations[axis] = offset;
		return new RotatedArray(b, rotations);
	}

	@Override
	public String getName() {
		return "reverse";
	}

	@Override
	public int resultTypeFor(Array a) {
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
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
