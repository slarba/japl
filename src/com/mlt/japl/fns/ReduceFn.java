package com.mlt.japl.fns;

import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.errors.AxisError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ReduceFn extends SpecialBaseFn {

	private PrimitiveBaseFn primFn;
	private Func fn;
	
	public ReduceFn(Func fn) {
		// TODO: special version!
		this.fn = fn;
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
			axis = a.rank()-1;
		}
		if(axis<0 || axis>=a.rank()) throw new AxisError();

		int count = a.dims().axis(axis);
		Dimensions resultDims = a.dims().elideAxis(axis);
		Array result = a.ofSameTypeWithDimensions(resultDims);

		Iterator resultIterator = resultDims.linearIterator();
		Iterator sourceIterator = a.dims().iteratorAlongAxis(axis);

		switch(result.type()) {
		case Array.BIT:
		case Array.INTEGER:
			// special case: iota array can be summed quicker
			if(result.isScalar() && a instanceof IotaArray && a.rank()==1) {
				result.setI(0, ((IotaArray)a).sum());
				break;
			}
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
	public String getName() {
		return "reduce<" + fn.getName() + ">";
	}

}
