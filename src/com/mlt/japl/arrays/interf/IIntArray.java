package com.mlt.japl.arrays.interf;

import com.mlt.japl.arrays.IValue;

public interface IIntArray extends IValue, IArray {
    long get(int index);
}
