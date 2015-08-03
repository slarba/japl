package com.mlt.japl.fns;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ScanFn extends SpecialBaseFn {

	private Func fn;
	private PrimitiveBaseFn primFn;
	private boolean first;

	public ScanFn(Func fn, boolean first) {
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
		Dimensions resultDims = a.dims();
		Array result = a.unInitializedReshapedCopy(resultDims);

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
		case Array.MIXED:
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
	public int resultTypeFor(Array a) {
		return fn.resultTypeFor(a);
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}
	
	@Override
	public String getName() {
		return "scan<" + fn.getName() + ">";
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
