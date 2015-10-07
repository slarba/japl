package com.mlt.japl.newarrays.interf;

import com.mlt.japl.newarrays.IValue;

public interface IMixedScalar extends IValue, IArray, IScalar {
    IValue get();
}
