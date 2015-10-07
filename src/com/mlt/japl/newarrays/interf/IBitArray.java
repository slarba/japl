package com.mlt.japl.newarrays.interf;

import com.mlt.japl.newarrays.IValue;

public interface IBitArray extends IValue, IArray {
    long get(int index);

    long getBits(int index);
}
