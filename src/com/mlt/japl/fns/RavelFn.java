package com.mlt.japl.fns;


import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class RavelFn extends SpecialBaseFn {

	private boolean first;

	public RavelFn(boolean first) {
		this.first = first;
	}

	@Override
	public Array monadic(Array a, int axis) {
		if(a.isScalar()) return a;
		return a.reshape(new Dimensions(a.dims().length()));
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		if(a.isScalar() && b.isScalar()) {
			Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a, b), new Dimensions(2));
			result.setA(0, a);
			result.setA(1, b);
			return result;
		}
		if(axis<0) {
			if(first) axis = 0;
			else axis = b.rank()-1;
		}

		if(a.isScalar()) {
			if(b.rank()>1) throw new RankError();
			Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), new Dimensions(b.length()+1));
			result.setA(0, a);
			for(int i=1; i<=b.length(); i++) {
				result.setA(i, b.atA(i-1));
			}
			return result;
		}

		if(b.isScalar()) {
			if(a.rank()>1) throw new RankError();
			Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), new Dimensions(a.length()+1));
			result.setA(0, a);
			for(int i=0; i<a.length(); i++) {
				result.setA(i, a.atA(i));
			}
			result.setA(a.length(), b);
			return result;
		}
		
		Dimensions resultDims = a.dims().laminate(b.dims(), axis);
		Array result = ArrayFactory.makeArrayOfType(resultTypeFor(a,b), resultDims);
		
		Iterator r = resultDims.iteratorAlongLastAxis();
		while(!r.isFinished()) {
			if(r.axis(axis)>=a.dims().axis(axis)) {
				result.setA(r.index(), b.atA(b.dims().indexWithReplacedAxis(axis, r.axis(axis)-a.dims().axis(axis), r.iter())));
			} else
				result.setA(r.index(), a.atA(r.iter()));
			r.step();
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "ravel";
	}

	@Override
	public int resultTypeFor(Array a) {
		return a.type();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		switch(a.type()) {
		case Array.BIT:
			switch(b.type()) {
			case Array.BIT:
				return Array.BIT;
			case Array.INTEGER:
				return Array.INTEGER;
			case Array.DOUBLE:
				return Array.DOUBLE;
			case Array.CHARACTER:
				return Array.MIXED;
			case Array.MIXED:		
				return Array.MIXED;
			}
		case Array.INTEGER:
			switch(b.type()) {
			case Array.BIT:
				return Array.INTEGER;
			case Array.INTEGER:
				return Array.INTEGER;
			case Array.DOUBLE:
				return Array.DOUBLE;
			case Array.CHARACTER:
				return Array.MIXED;
			case Array.MIXED:		
				return Array.MIXED;
			}
		case Array.DOUBLE:
			switch(b.type()) {
			case Array.BIT:
				return Array.DOUBLE;
			case Array.INTEGER:
				return Array.DOUBLE;
			case Array.DOUBLE:
				return Array.DOUBLE;
			case Array.CHARACTER:
				return Array.MIXED;
			case Array.MIXED:		
				return Array.MIXED;
			}
		case Array.CHARACTER:
			switch(b.type()) {
			case Array.BIT:
				return Array.MIXED;
			case Array.INTEGER:
				return Array.MIXED;
			case Array.DOUBLE:
				return Array.MIXED;
			case Array.CHARACTER:
				return Array.CHARACTER;
			case Array.MIXED:			
				return Array.MIXED;
			}
		case Array.MIXED:
			return Array.MIXED;
		}
		return a.type();
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
