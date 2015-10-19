package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.arrays.interf.IIntScalar;

public class EncodeFn extends BaseFn {

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return null;
    }
}
