package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.ScalarBase;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.utils.PrintConfig;

public class ObjectScalar extends ScalarBase implements IMixedScalar {

    private Object value;

    public ObjectScalar(Object instance) {
        value = instance;
    }

    public IValue prototype() {
        return new IntScalar(0);
    }

    @Override
    public String asString(PrintConfig printConfig) {
        return "#<" + value.getClass().getName() + ": " + value.toString() + ">";
    }

    @Override
    public IValue reshape(int[] newShape) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(ArrayVisitor visitor, IValue b) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue accept_monadic(ArrayVisitor visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue get() {
        return this;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return value.getClass();
    }

    @Override
    public Object coerceToJavaObject() {
        return value;
    }

    @Override
    public IValue getGeneric(int index) {
        return this;
    }

}
