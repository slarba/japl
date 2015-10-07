package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class EncodeFn extends BaseFn {

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        return null;
    }
}
