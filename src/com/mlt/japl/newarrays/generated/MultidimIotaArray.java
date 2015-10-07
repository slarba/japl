package com.mlt.japl.newarrays.generated;

import com.mlt.japl.newarrays.ArrayBase;
import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newarrays.interf.*;
import com.mlt.japl.newfns.Indexer;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class MultidimIotaArray extends ArrayBase implements IMixedArray {
    IIntArray val;
    Dimensions itemDimensions;

    public MultidimIotaArray(Dimensions dims, IIntArray val) {
        super(dims);
        this.val = val;
        itemDimensions = new Dimensions(val.length());
    }

    @Override
    public IValue get(IMixedArray i) {
        Indexer indexer = new Indexer(i, this);
        int[] finalDims = indexer.computeResultDims();
        if (finalDims.length == 0) return get(indexer.indexForSingle());
        Dimensions ds = new Dimensions(finalDims);
        IValue[] result = new IValue[ds.length()];

        for (int j = 0; j < result.length; j++) {
            result[j] = get(indexer.step());
        }
        return new MixedArray(ds, result);
    }

    @Override
    public IValue getGeneric(int index) {
        return get(index);
    }

    @Override
    public int depth() {
        return 2;
    }

    @Override
    public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
        return visitor.visit_dyadic(a, this, axis);
    }

    @Override
    public IValue get(int index) {
        return new IntArray(itemDimensions, dims().reverseIndex(index));
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
    public IValue reshape(int[] newShape) {
        return new MultidimIotaArray(new Dimensions(newShape), val);
    }

    @Override
    public String asString(PrintConfig config) {
        return config.print(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((itemDimensions == null) ? 0 : itemDimensions.hashCode());
        result = prime * result + ((val == null) ? 0 : val.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MultidimIotaArray other = (MultidimIotaArray) obj;
        if (itemDimensions == null) {
            if (other.itemDimensions != null)
                return false;
        } else if (!itemDimensions.equals(other.itemDimensions))
            return false;
        if (val == null) {
            if (other.val != null)
                return false;
        } else if (!val.equals(other.val))
            return false;
        return true;
    }

    @Override
    public Class<?> getCorrespondingJavaClass() {
        return long[][].class;
    }

    @Override
    public Object coerceToJavaObject() {
        return force().coerceToJavaObject();
    }

}
