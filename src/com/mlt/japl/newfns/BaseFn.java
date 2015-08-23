package com.mlt.japl.newfns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class BaseFn implements ArrayVisitor, Func {

	@Override
	public IValue visit_first(IIntArray a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(IDoubleArray a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(ICharArray a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(IMixedArray a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(IIntScalar a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(IDoubleScalar a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(ICharScalar a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	@Override
	public IValue visit_first(IMixedScalar a, IValue b, int axis) {
		return b.accept_dyadic(a, this, axis);
	}

	// ----------
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IMixedScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IIntArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IDoubleArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, ICharArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IMixedArray b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IIntScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IDoubleScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, ICharScalar b, int axis) {
		return generic_dyadic(a,b);
	}

	public IValue generic_monadic(IValue a) {
		throw new DomainError();
	}
	
	public IValue generic_dyadic(IValue a, IValue b) {
		throw new DomainError();
	}

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(IMixedArray a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(ICharScalar a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue visit_monadic(IMixedScalar a, int axis) {
		return generic_monadic(a);
	}

	@Override
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		return a.accept_dyadic(this,  b, axis);
	}

	@Override
	public IValue applyMonadic(IValue a, int axis) {
		return a.accept_monadic(this, axis);
	}

	@Override
	public IValue applyNiladic(int axis) {
		return null;
	}
}