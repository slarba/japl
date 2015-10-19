package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.ScalarBase;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.utils.PrintConfig;

/**
 * Created by markolau on 11/10/15.
 */
public class ComplexScalar extends ScalarBase {
    double real;
    double imag;

    public ComplexScalar() {
        this(0,0);
    }

    public ComplexScalar(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public IValue prototype() {
        return new ComplexScalar();
    }

    @Override
    public String asString(PrintConfig printConfig) {
        return printConfig.print(this);
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

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }
}
