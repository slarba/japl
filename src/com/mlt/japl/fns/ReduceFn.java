package com.mlt.japl.fns;

import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.errors.AxisError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ReduceFn extends SpecialBaseFn {

	private PrimitiveBaseFn primFn;
	private Func fn;
	private boolean first;
	
	public ReduceFn(Func fn, boolean first) {
		// TODO: special version!
		this.fn = fn;
		this.first = first;
		if(fn instanceof PrimitiveBaseFn) {
			primFn = (PrimitiveBaseFn)fn;
		}
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		if(a.rank()==0) {
			return fn.monadic(a, axis);
		}
		if(axis<0) {
			if(first) axis = 0;
			else axis = a.rank()-1;
		}
		if(axis<0 || axis>=a.rank()) throw new AxisError();

		int count = a.dims().axis(axis);
		Dimensions resultDims = a.dims().elideAxis(axis);
		Array result = a.unInitializedReshapedCopy(resultDims);

		Iterator resultIterator = resultDims.linearIterator();
		Iterator sourceIterator = a.dims().iteratorAlongAxis(axis);

		if(primFn==null) {
			while(true) {
				Array tmp = a.atA(sourceIterator.index());
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = fn.dyadic(tmp, a.atA(sourceIterator.index()), -1);
					sourceIterator.step();
				}
				result.setA(resultIterator.index(), tmp);
				resultIterator.step();
				if(resultIterator.isFinished()) break;
			}
			return result;
		}
		
		switch(result.type()) {
		case Array.BIT:
			// there are efficient algorithms for counting one bits in an integer!
			// that could be used for special case of +
		case Array.INTEGER:
			// special case: rank 1 iota array can be summed quicker
			if(fn instanceof AddFn && a instanceof IotaArray && a.rank()==1) {
				result.setI(0, ((IotaArray)a).sum());
				break;
			}
			//if(fn instanceof MulFn) {
			// reduction value is always zero if any of the values is zero, could be used for optimization
			//}
			while(true) {
				long tmp = a.atI(sourceIterator.index());
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = primFn.I_II(tmp, a.atI(sourceIterator.index()));
					sourceIterator.step();
				}
				result.setI(resultIterator.index(), tmp);
				resultIterator.step();
				if(resultIterator.isFinished()) break;
			}
			break;
		case Array.DOUBLE:
			while(true) {
				double tmp = a.atD(sourceIterator.index());
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = primFn.D_DD(tmp, a.atD(sourceIterator.index()));
					sourceIterator.step();
				}
				result.setD(resultIterator.index(), tmp);
				resultIterator.step();
				if(resultIterator.isFinished()) break;
			}
			break;
		case Array.MIXED:
			while(true) {
				Array tmp = a.atA(sourceIterator.index());
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = fn.dyadic(tmp, a.atA(sourceIterator.index()), -1);
					sourceIterator.step();
				}
				result.setA(resultIterator.index(), tmp);
				resultIterator.step();
				if(resultIterator.isFinished()) break;
			}
			break;
		}
		return result;
	}
	
	@Override
	public int resultTypeFor(Array a) {
		return fn.resultTypeFor(a);
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}

	@Override
	public String getName() {
		return "reduce<" + fn.getName() + ">";
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
