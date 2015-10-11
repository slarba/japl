package com.mlt.japl.arrays.interf;

import com.mlt.japl.arrays.IValue;

public interface IMixedArray extends IValue, IArray {
    IValue get(int index);
}
