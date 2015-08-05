package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ReplicateFn extends SpecialBaseFn {

	private boolean first;

	public ReplicateFn(boolean first) {
		this.first = first;
	}
	
	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(axis<0) {
			if(first) axis = 0;
			else axis = b.rank()-1;
		}
		Dimensions resultDims = resultDimsFor(a, b, axis);
		
		Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), resultDims);
		
		Iterator resultIterator = result.dims().iteratorAlongAxis(axis);
		Iterator biterator = b.dims().iteratorAlongAxis(axis);

		if(a.isScalar() && a.isIntegral()) {
			while(!resultIterator.isFinished()) {
				long repl = a.atI(0);
				int i = 0;
				while(i<repl) {
					Array val = b.atA(biterator.index());
					while(repl>0) {
						result.setA(resultIterator.index(), val);
						resultIterator.step();
						repl--;
					}
					biterator.step();
					i++;
				}
			}	
			return result;
		}
		
		while(!resultIterator.isFinished()) {
			int[] repl = a.asIntArray();
			int i = 0;
			while(i<repl.length) {
				Array val = b.atA(biterator.index());
				while(repl[i]>0) {
					result.setA(resultIterator.index(), val);
					resultIterator.step();
					repl[i]--;
				}
				biterator.step();
				i++;
			}
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "replicate";
	}

	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return b.type();
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		if(a.rank()>1) throw new RankError();
		if(a.length()!=1 && a.length() != b.dims().axis(axis)) throw new LengthError();
		if(a.isScalar()) {
			return b.dims().replaceAxis(axis, (int)(b.dims().axis(axis)*a.atI(0)));
		}
		int[] as = a.asIntArray();
		int sum = 0;
		for(int i=0; i<as.length; i++) sum += as[i];
		return b.dims().replaceAxis(axis, sum);
	}

}
