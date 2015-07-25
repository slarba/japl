package com.mlt.japl.fns;

import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.errors.AxisError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ScanFn extends SpecialBaseFn {

	private Func fn;
	private PrimitiveBaseFn primFn;

	public ScanFn(Func fn) {
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
		Dimensions resultDims = a.dims();
		Array result = a.ofSameTypeWithDimensions(resultDims);

		Iterator resultIterator = resultDims.iteratorAlongAxis(axis);
		Iterator sourceIterator = a.dims().iteratorAlongAxis(axis);

		switch(result.type()) {
		case Array.BIT:
		case Array.INTEGER:
			do {
				long tmp = a.atI(sourceIterator.index());
				result.setI(resultIterator.index(), tmp);
				resultIterator.step();
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = primFn.I_II(tmp, a.atI(sourceIterator.index()));
					result.setI(resultIterator.index(), tmp);
					resultIterator.step();
					sourceIterator.step();
				}
			} while(!resultIterator.isFinished());
			break;
		case Array.DOUBLE:
			do {
				double tmp = a.atD(sourceIterator.index());
				result.setD(resultIterator.index(), tmp);
				resultIterator.step();
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = primFn.D_DD(tmp, a.atD(sourceIterator.index()));
					result.setD(resultIterator.index(), tmp);
					resultIterator.step();
					sourceIterator.step();
				}
			} while(!resultIterator.isFinished());
			break;
		case Array.NESTED:
			do {
				Array tmp = a.atA(sourceIterator.index());
				result.setA(resultIterator.index(), tmp);
				resultIterator.step();
				sourceIterator.step();
				for(int i=1; i<count; i++) {
					tmp = dyadic(tmp, a.atA(sourceIterator.index()), axis);
					result.setA(resultIterator.index(), tmp);
					resultIterator.step();
					sourceIterator.step();
				}
			} while(!resultIterator.isFinished());
			break;
		}
		return result;
	}
		
	@Override
	public String getName() {
		return "scan<" + fn.getName() + ">";
	}

}
