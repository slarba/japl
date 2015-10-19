package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.fns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

/**
 * Created by markolau on 10/10/15.
 */
public class FuncValue implements IValue {
    private final Func fn;

    public IValue prototype() {
        return new IntScalar(0);
    }

    public FuncValue(Func fn) {
        this.fn = fn;
    }

    @Override
    public Dimensions dims() {
        return null;
    }

    @Override
    public int rank() {
        return 0;
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public IValue force() {
        return this;
    }

    @Override
    public String asString(PrintConfig printConfig) {
        return "<function>";
    }

    @Override
    public IValue reshape(int[] newShape) {
        return null;
    }

    @Override
    public IValue getGeneric(int index) {
        return null;
    }

    @Override
    public IValue get(IMixedArray i) {
        return null;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return null;
    }

    @Override
    public Object coerceToJavaObject() {
        return null;
    }

    @Override
    public IValue accept_dyadic(ArrayVisitor visitor, IValue b) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor) {
        return null;
    }

    @Override
    public IValue accept_monadic(ArrayVisitor visitor) {
        return null;
    }

    public Func get() {
        return fn;
    }
}
