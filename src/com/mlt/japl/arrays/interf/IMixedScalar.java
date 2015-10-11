package com.mlt.japl.arrays.interf;

import com.mlt.japl.arrays.IValue;

public interface IMixedScalar extends IValue, IArray, IScalar {
    IValue get();
}
