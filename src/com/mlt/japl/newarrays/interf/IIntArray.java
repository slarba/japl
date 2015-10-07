package com.mlt.japl.newarrays.interf;

import com.mlt.japl.newarrays.IValue;

public interface IIntArray extends IValue, IArray {
    long get(int index);
}
