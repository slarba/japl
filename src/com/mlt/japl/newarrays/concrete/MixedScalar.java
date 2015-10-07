package com.mlt.japl.newarrays.concrete;

import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.ScalarBase;
import com.mlt.japl.newarrays.interf.*;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class MixedScalar extends ScalarBase implements IMixedScalar {
    IValue val;

    public MixedScalar(IValue val) {
        this.val = val;
    }

    @Override
    public int depth() {
        return val.depth() + 1;
    }

    @Override
    public IValue get() {
        return val;
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(ArrayVisitor visitor, IValue b, int axis) {
        return visitor.visit_first(this, b, axis);
    }

    @Override
    public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue accept_monadic(ArrayVisitor visitor, int axis) {
        return visitor.visit_monadic(this, axis);
    }

    @Override
    public String asString(PrintConfig printConfig) {
        return printConfig.print(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((val == null) ? 0 : val.hashCode());
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
        MixedScalar other = (MixedScalar) obj;
        if (val == null) {
            if (other.val != null)
                return false;
        } else if (!val.equals(other.val))
            return false;
        return true;
    }

    @Override
    public IValue reshape(int[] newShape) {
        return new MixedArray(new Dimensions(newShape), new IValue[]{val});
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return Object.class;
    }

    @Override
    public Object coerceToJavaObject() {
        return val;
    }

    @Override
    public IValue getGeneric(int index) {
        return this;
    }

}
