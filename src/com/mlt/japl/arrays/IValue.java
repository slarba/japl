package com.mlt.japl.arrays;

import com.mlt.japl.arrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public interface IValue extends ArrayAcceptor {
    Dimensions dims();

    int rank();

    int depth();

    int length();

    IValue force();   // realize lazy array into concrete array

    String asString(PrintConfig printConfig);

    IValue reshape(int[] newShape);

    IValue getGeneric(int index);

    // generic indexing
    IValue get(IMixedArray i);

    Class<?> getCorrespondingJavaClass();

    Object coerceToJavaObject();

    IValue prototype();
}
