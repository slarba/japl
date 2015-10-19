package com.mlt.japl.arrays;

import com.mlt.japl.arrays.interf.*;

public interface ArrayVisitor {
    IValue visit_first(IIntArray a, IValue b);

    IValue visit_first(IDoubleArray a, IValue b);

    IValue visit_first(ICharArray a, IValue b);

    IValue visit_first(IMixedArray a, IValue b);

    IValue visit_first(IBitArray a, IValue b);

    IValue visit_first(IIntScalar a, IValue b);

    IValue visit_first(IDoubleScalar a, IValue b);

    IValue visit_first(ICharScalar a, IValue b);

    IValue visit_first(IMixedScalar a, IValue b);

    IValue visit_dyadic(IIntArray a, IIntArray b);

    IValue visit_dyadic(IDoubleArray a, IDoubleArray b);

    IValue visit_dyadic(ICharArray a, ICharArray b);

    IValue visit_dyadic(IMixedArray a, IMixedArray b);

    IValue visit_dyadic(IIntScalar a, IIntScalar b);

    IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b);

    IValue visit_dyadic(ICharScalar a, ICharScalar b);

    IValue visit_dyadic(IMixedScalar a, IMixedScalar b);

    IValue visit_dyadic(IBitArray a, IBitArray b);

    IValue visit_dyadic(IIntArray a, IDoubleArray b);

    IValue visit_dyadic(IIntArray a, ICharArray b);

    IValue visit_dyadic(IIntArray a, IMixedArray b);

    IValue visit_dyadic(IIntArray a, IBitArray b);

    IValue visit_dyadic(IIntArray a, IIntScalar b);

    IValue visit_dyadic(IIntArray a, IDoubleScalar b);

    IValue visit_dyadic(IIntArray a, ICharScalar b);

    IValue visit_dyadic(IIntArray a, IMixedScalar b);

    IValue visit_dyadic(IDoubleArray a, IIntArray b);

    IValue visit_dyadic(IDoubleArray a, ICharArray b);

    IValue visit_dyadic(IDoubleArray a, IMixedArray b);

    IValue visit_dyadic(IDoubleArray a, IBitArray b);

    IValue visit_dyadic(IDoubleArray a, IIntScalar b);

    IValue visit_dyadic(IDoubleArray a, IDoubleScalar b);

    IValue visit_dyadic(IDoubleArray a, ICharScalar b);

    IValue visit_dyadic(IDoubleArray a, IMixedScalar b);

    IValue visit_dyadic(ICharArray a, IIntArray b);

    IValue visit_dyadic(ICharArray a, IDoubleArray b);

    IValue visit_dyadic(ICharArray a, IMixedArray b);

    IValue visit_dyadic(ICharArray a, IBitArray b);

    IValue visit_dyadic(ICharArray a, IIntScalar b);

    IValue visit_dyadic(ICharArray a, IDoubleScalar b);

    IValue visit_dyadic(ICharArray a, ICharScalar b);

    IValue visit_dyadic(ICharArray a, IMixedScalar b);

    IValue visit_dyadic(IMixedArray a, IIntArray b);

    IValue visit_dyadic(IMixedArray a, IDoubleArray b);

    IValue visit_dyadic(IMixedArray a, ICharArray b);

    IValue visit_dyadic(IMixedArray a, IBitArray b);

    IValue visit_dyadic(IMixedArray a, IIntScalar b);

    IValue visit_dyadic(IMixedArray a, IDoubleScalar b);

    IValue visit_dyadic(IMixedArray a, ICharScalar b);

    IValue visit_dyadic(IMixedArray a, IMixedScalar b);

    IValue visit_dyadic(IBitArray a, IIntArray b);

    IValue visit_dyadic(IBitArray a, IDoubleArray b);

    IValue visit_dyadic(IBitArray a, ICharArray b);

    IValue visit_dyadic(IBitArray a, IIntScalar b);

    IValue visit_dyadic(IBitArray a, IDoubleScalar b);

    IValue visit_dyadic(IBitArray a, ICharScalar b);

    IValue visit_dyadic(IBitArray a, IMixedScalar b);

    IValue visit_dyadic(IBitArray a, IMixedArray b);

    IValue visit_dyadic(IIntScalar a, IIntArray b);

    IValue visit_dyadic(IIntScalar a, IDoubleArray b);

    IValue visit_dyadic(IIntScalar a, ICharArray b);

    IValue visit_dyadic(IIntScalar a, IMixedArray b);

    IValue visit_dyadic(IIntScalar a, IBitArray b);

    IValue visit_dyadic(IIntScalar a, IDoubleScalar b);

    IValue visit_dyadic(IIntScalar a, ICharScalar b);

    IValue visit_dyadic(IIntScalar a, IMixedScalar b);

    IValue visit_dyadic(IDoubleScalar a, IIntArray b);

    IValue visit_dyadic(IDoubleScalar a, IDoubleArray b);

    IValue visit_dyadic(IDoubleScalar a, ICharArray b);

    IValue visit_dyadic(IDoubleScalar a, IMixedArray b);

    IValue visit_dyadic(IDoubleScalar a, IBitArray b);

    IValue visit_dyadic(IDoubleScalar a, IIntScalar b);

    IValue visit_dyadic(IDoubleScalar a, ICharScalar b);

    IValue visit_dyadic(IDoubleScalar a, IMixedScalar b);

    IValue visit_dyadic(ICharScalar a, IIntArray b);

    IValue visit_dyadic(ICharScalar a, IDoubleArray b);

    IValue visit_dyadic(ICharScalar a, ICharArray b);

    IValue visit_dyadic(ICharScalar a, IMixedArray b);

    IValue visit_dyadic(ICharScalar a, IBitArray b);

    IValue visit_dyadic(ICharScalar a, IIntScalar b);

    IValue visit_dyadic(ICharScalar a, IDoubleScalar b);

    IValue visit_dyadic(ICharScalar a, IMixedScalar b);

    IValue visit_dyadic(IMixedScalar a, IIntArray b);

    IValue visit_dyadic(IMixedScalar a, IDoubleArray b);

    IValue visit_dyadic(IMixedScalar a, ICharArray b);

    IValue visit_dyadic(IMixedScalar a, IMixedArray b);

    IValue visit_dyadic(IMixedScalar a, IBitArray b);

    IValue visit_dyadic(IMixedScalar a, IIntScalar b);

    IValue visit_dyadic(IMixedScalar a, IDoubleScalar b);

    IValue visit_dyadic(IMixedScalar a, ICharScalar b);

    IValue visit_monadic(IIntArray a);

    IValue visit_monadic(IDoubleArray a);

    IValue visit_monadic(ICharArray a);

    IValue visit_monadic(IMixedArray a);

    IValue visit_monadic(IIntScalar a);

    IValue visit_monadic(IDoubleScalar a);

    IValue visit_monadic(ICharScalar a);

    IValue visit_monadic(IMixedScalar a);

    IValue visit_monadic(IBitArray a);
}
