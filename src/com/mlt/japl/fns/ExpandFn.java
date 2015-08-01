package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class ExpandFn extends SpecialBaseFn {

	private boolean first;

	public ExpandFn(boolean first) {
		this.first = first;
	}
	
	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(axis<0) {
			if(first) axis = 0; else axis = b.rank()-1;
		}
		Dimensions resultDims = resultDimsFor(a, b, axis);
		
		Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), resultDims);
		
		Iterator resultIterator = result.dims().iteratorAlongAxis(axis);
		Iterator biterator = b.dims().iteratorAlongAxis(axis);
		
		while(!resultIterator.isFinished()) {
			int[] repl = a.asIntArray();
			int i = 0;
			while(i<repl.length) {
				if(repl[i]==0) {
					result.setA(resultIterator.index(), b.prototype());
					resultIterator.step();
				} else if(repl[i]<0) {
					while(repl[i]<0) {
						result.setA(resultIterator.index(), b.prototype());
						resultIterator.step();
						repl[i]++;
					}
				} else {
					Array val = b.atA(biterator.index());
					while(repl[i]>0) {
						result.setA(resultIterator.index(), val);
						resultIterator.step();
						repl[i]--;
					}					
					biterator.step();
				}
				i++;
			}
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "expand";
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
		if(!a.isIntegral()) throw new DomainError();
		if(a.rank()>1) throw new RankError();
		int[] as = a.asIntArray();
		int sum = 0;
		int npositive = 0;
		for(int i=0; i<as.length; i++) {
			if(as[i] == 0) sum+=1;
			else if(as[i]<0) sum += -as[i];
			else {
				sum += as[i];
				npositive++;
			}
		}
		if(npositive>b.dims().axis(axis)) throw new LengthError();
		return b.dims().replaceAxis(axis, sum);
	}

}
