package com.mlt.japl.newarrays.generated;

import com.mlt.japl.newarrays.ArrayBase;
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
import com.mlt.japl.newfns.Prim;

public class LazyMonadicIntArray extends ArrayBase implements IIntArray {

	private IIntArray array;
	private Prim fn;

	public LazyMonadicIntArray(IIntArray array, Prim fn) {
		super(array.dims());
		this.array = array;
		this.fn = fn;
	}
	
	@Override
	public long get(int index) {
		return fn.call(array.get(index));
	}

	@Override
	public IValue accept_dyadic(ArrayVisitor visitor, IValue b) {
		return visitor.visit_first(this, b);
	}

	@Override
	public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor) {
		return visitor.visit_dyadic(a, this);
	}

	@Override
	public IValue accept_monadic(ArrayVisitor visitor) {
		return visitor.visit_monadic(this);
	}

}
