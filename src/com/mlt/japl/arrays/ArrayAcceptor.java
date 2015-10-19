package com.mlt.japl.arrays;

import com.mlt.japl.arrays.interf.*;

public interface ArrayAcceptor {
    IValue accept_dyadic(ArrayVisitor visitor, IValue b);

    IValue accept_dyadic(IIntArray a, ArrayVisitor visitor);

    IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor);

    IValue accept_dyadic(ICharArray a, ArrayVisitor visitor);

    IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor);

    IValue accept_dyadic(IBitArray a, ArrayVisitor visitor);

    IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor);

    IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor);

    IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor);

    IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor);

    IValue accept_monadic(ArrayVisitor visitor);
}
