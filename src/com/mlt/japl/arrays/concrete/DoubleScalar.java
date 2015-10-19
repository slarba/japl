package com.mlt.japl.arrays.concrete;

import com.mlt.japl.arrays.ArrayVisitor;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.ScalarBase;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class DoubleScalar extends ScalarBase implements IDoubleScalar {
    double val;

    public DoubleScalar(double val) {
        this.val = val;
    }

    @Override
    public double get() {
        return val;
    }

    @Override
    public IValue getGeneric(int index) {
        return this;
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(ArrayVisitor visitor, IValue b) {
        return visitor.visit_first(this, b);
    }

    @Override
    public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor) {
        return visitor.visit_dyadic(a, this);
    }

    @Override
    public IValue accept_monadic(ArrayVisitor visitor) {
        return visitor.visit_monadic(this);
    }

    @Override
    public String asString(PrintConfig printConfig) {
        return printConfig.print(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(val);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleScalar other = (DoubleScalar) obj;
        if (Double.doubleToLongBits(val) != Double.doubleToLongBits(other.val))
            return false;
        return true;
    }

    @Override
    public IValue reshape(int[] newShape) {
        return new DoubleArray(new Dimensions(newShape), new double[]{val});
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return double.class;
    }

    @Override
    public Object coerceToJavaObject() {
        return val;
    }

}
