package com.mlt.japl.newfns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedScalar;
import com.mlt.japl.newarrays.generated.LazyMonadicCharArray;
import com.mlt.japl.newarrays.generated.LazyMonadicDoubleArray;
import com.mlt.japl.newarrays.generated.LazyMonadicIntArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class PrimitiveFn implements ArrayVisitor {
	Prim fn;
	
	public PrimitiveFn(Prim fn) {
		this.fn = fn;
	}

	public IValue applyDyadic(IValue a, IValue b) {
		return a.accept_dyadic(this, b);
	}
	
	public IValue applyMonadic(IValue a) {
		return a.accept_monadic(this);
	}
	
	@Override
	public IValue visit_first(IIntArray a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(IDoubleArray a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(ICharArray a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(IMixedArray a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(IIntScalar a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(IDoubleScalar a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(ICharScalar a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	@Override
	public IValue visit_first(IMixedScalar a, IValue b) {
		return b.accept_dyadic(a, this);
	}

	// ----------
	@Override
	public IValue visit_dyadic(IIntArray a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntArray a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleArray a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharArray a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedArray a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IIntScalar a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IDoubleScalar a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(ICharScalar a, IMixedScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IIntArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IDoubleArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, ICharArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IMixedArray b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IIntScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, IDoubleScalar b) {
		return generic_dyadic(a,b);
	}

	@Override
	public IValue visit_dyadic(IMixedScalar a, ICharScalar b) {
		return generic_dyadic(a,b);
	}

	public IValue generic_dyadic(IValue a, IValue b) {
		throw new DomainError();
	}

	public IValue generic_monadic(IValue a) {
		throw new DomainError();
	}
	
	@Override
	public IValue visit_monadic(IIntArray a) {
		return fn.createLazyMonadic(a);
	}

	@Override
	public IValue visit_monadic(IDoubleArray a) {
		return fn.createLazyMonadic(a);
	}

	@Override
	public IValue visit_monadic(ICharArray a) {
		return fn.createLazyMonadic(a);
	}

	@Override
	public IValue visit_monadic(IMixedArray a) {
		return fn.createLazyMonadic(a);
	}

	@Override
	public IValue visit_monadic(IIntScalar a) {
		return new IntScalar(fn.call(a.get()));
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a) {
		return new DoubleScalar(fn.call(a.get()));
	}

	@Override
	public IValue visit_monadic(ICharScalar a) {
		return new CharScalar(fn.call(a.get()));
	}

	@Override
	public IValue visit_monadic(IMixedScalar a) {
		return new MixedScalar(fn.call(a.get()));
	}

}
