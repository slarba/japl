package com.mlt.japl.newarrays.interf;

import com.mlt.japl.newarrays.IValue;

public interface IMixedArray extends IValue, IArray {
    IValue get(int index);
}
