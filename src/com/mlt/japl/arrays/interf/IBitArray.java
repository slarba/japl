package com.mlt.japl.arrays.interf;

import com.mlt.japl.arrays.IValue;

public interface IBitArray extends IValue, IArray {
    long get(int index);

    long getBits(int index);
}
