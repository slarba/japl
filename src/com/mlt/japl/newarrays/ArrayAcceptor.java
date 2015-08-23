package com.mlt.japl.newarrays;

import com.mlt.japl.newarrays.interf.*;

public interface ArrayAcceptor {
	IValue accept_dyadic(ArrayVisitor visitor, IValue b, int axis);

	IValue accept_dyadic(IIntArray a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(ICharArray a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis);
	
	IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor, int axis);
	IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor, int axis);
	
	IValue accept_monadic(ArrayVisitor visitor, int axis);
}
