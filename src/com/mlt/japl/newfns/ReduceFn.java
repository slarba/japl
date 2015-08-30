package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;

public class ReduceFn extends BaseFn {

	private Func fn;
	private boolean firstAxis;

	public ReduceFn(Func fn, boolean b) {
		this.fn = fn;
		this.firstAxis = b;
	}

	@Override
	public String getName() {
		return "reduce<" + fn.getName() + ">";
	}

	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IDoubleScalar a, int axis) {
		return a;
	}
	
	@Override
	public IValue visit_monadic(ICharScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IMixedScalar a, int axis) {
		return a;
	}

	@Override
	public IValue visit_monadic(IBitArray a, int axis) {
		return fn.reduce(a, axis<0 ? (firstAxis ? 0 : a.rank()-1) : axis);
	}
	
	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		return fn.reduce(a, axis<0 ? (firstAxis ? 0 : a.rank()-1) : axis);
	}

	@Override
	public IValue visit_monadic(IDoubleArray a, int axis) {
		return fn.reduce(a, axis<0 ? (firstAxis ? 0 : a.rank()-1) : axis);
	}

	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		return fn.reduce(a, axis<0 ? (firstAxis ? 0 : a.rank()-1) : axis);
	}
	
	@Override
	public IValue visit_monadic(IMixedArray a, int axis) {
		return fn.reduce(a, axis<0 ? (firstAxis ? 0 : a.rank()-1) : axis);
	}
}
