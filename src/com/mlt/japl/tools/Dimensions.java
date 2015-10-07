package com.mlt.japl.tools;

import com.mlt.japl.errors.IndexError;
import com.mlt.japl.errors.RankError;

import java.util.Arrays;

public class Dimensions {
    public static final Dimensions EMPTY = new Dimensions();
    public static final Dimensions EMPTY_ARRAY = new Dimensions(0);
    private static final int[] EMPTY_DIMS = new int[]{};
    int[] dims;
    int[] spans;
    int length;

    public Dimensions() {
        dims = EMPTY_DIMS;
        spans = EMPTY_DIMS;
        length = 0;
    }

    public Dimensions(int... dims) {
        this.dims = dims;

        spans = new int[dims.length];
        if (dims.length == 0) return;

        spans[dims.length - 1] = 1;
        int len = 1;
        for (int i = dims.length - 1; i > 0; i--) {
            len *= dims[i];
            spans[i - 1] = spans[i] * dims[i];
        }
        length = len * dims[0];
    }

    public Dimensions reverse() {
        int[] nds = new int[dims.length];
        int j = 0;
        for (int i = nds.length - 1; i >= 0; i--) {
            nds[j++] = dims[i];
        }
        return new Dimensions(nds);
    }

    public Dimensions concat(Dimensions o) {
        int[] nds = new int[dims.length + o.dims.length];
        for (int i = 0; i < dims.length; i++) {
            nds[i] = dims[i];
        }
        for (int i = 0; i < o.dims.length; i++) {
            nds[i + dims.length] = o.dims[i];
        }
        return new Dimensions(nds);
    }

    public Dimensions elideAxis(int axis) {
        int[] nds = new int[dims.length - 1];
        int j = 0;
        for (int i = 0; i < dims.length; i++) {
            if (i == axis) continue;
            nds[j++] = dims[i];
        }
        return new Dimensions(nds);
    }

    public Dimensions permute(int[] permutations) {
        int[] nds = new int[dims.length];
        for (int i = 0; i < nds.length; i++) {
            nds[i] = dims[permutations[i]];
        }
        return new Dimensions(nds);
    }

    public int axis(int i) {
        return dims[i];
    }

    public Dimensions offsetBy(Dimensions o) {
        return offsetBy(o.dims);
    }

    public Dimensions offsetByMinus(Dimensions o) {
        return offsetByMinus(o.dims);
    }

    public Dimensions offsetBy(int[] offsets) {
        int[] nds = new int[dims.length];
        for (int i = 0; i < nds.length; i++) {
            nds[i] = Math.max(0, dims[i] + offsets[i]);
        }
        return new Dimensions(nds);
    }

    public Dimensions offsetByMinus(int[] offsets) {
        int[] nds = new int[dims.length];
        for (int i = 0; i < nds.length; i++) {
            nds[i] = Math.max(0, dims[i] - offsets[i]);
        }
        return new Dimensions(nds);
    }

    public Dimensions offsetAxisBy(int axis, int offset) {
        int[] nds = new int[dims.length];
        for (int i = 0; i < nds.length; i++) {
            if (axis == i) nds[i] = Math.max(0, dims[i] + offset);
            else nds[i] = dims[i];
        }
        return new Dimensions(nds);
    }

    public int rank() {
        return dims.length;
    }

    public int length() {
        return length;
    }

    public Iterator iteratorAlongAxis(int axis) {
        return new AxisIterator(dims, spans, axis);
    }

    public int calculateIndex(int... indx) {
        int i;
        int result = 0;
        int[] spans = this.spans;
        for (i = 0; i < indx.length; i++) {
            result += spans[i] * indx[i];
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Dimensions)) return false;
        Dimensions d = (Dimensions) o;
        return Arrays.equals(dims, d.dims);
    }

    public int[] asArray() {
        return dims;
    }

    public int lastDim() {
        if (dims.length == 0) return 0;
        return dims[dims.length - 1];
    }

    public Iterator iteratorAlongLastAxis() {
        return iteratorAlongAxis(dims.length - 1);
    }

    public Iterator linearIterator() {
        return new LinearIterator(length());
    }

    public Iterator reverseIteratorAlongAxis(int axis) {
        return new ReverseAxisIterator(dims, spans, axis);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("dims=");
        for (int i = 0; i < dims.length; i++) {
            if (i != 0) b.append(',');
            b.append(dims[i]);
        }
        return b.toString();
    }

    public Iterator offsetIteratorAlongAxis(int axis, long offset) {
        return new OffsetAxisIterator(dims, spans, axis, (int) offset);
    }

    public Iterator offsetIterator(int[] offsets, int[] limits) {
        return new OffsetIterator(dims, spans, offsets, limits);
    }

    public Dimensions laminate(Dimensions dims2, int axis) {
        if (dims2.dims.length != dims.length) throw new RankError();
        int[] rdims = new int[dims.length];
        for (int i = 0; i < dims.length; i++) {
            if (i == axis) {
                rdims[i] = dims[i] + dims2.dims[i];
            } else {
                if (dims[i] != dims2.dims[i]) throw new IndexError();
                rdims[i] = dims[i];
            }
        }
        return new Dimensions(rdims);
    }

    public int indexWithReplacedAxis(int axis, int j, int[] indx) {
        int i;
        int result = 0;
        int[] spans = this.spans;
        for (i = 0; i < indx.length; i++) {
            if (i == axis) result += spans[i] * j;
            else result += spans[i] * indx[i];
        }
        return result;
    }

    public long[] reverseIndex(int idx) {
        long[] result = new long[dims.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1 + (idx / spans[i]);
            idx = idx % spans[i];
        }
        return result;
    }

    public int[] reverseIndexInt(int idx) {
        int[] result = new int[dims.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (idx / spans[i]);
            idx = idx % spans[i];
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 53 * Arrays.hashCode(dims);
    }

    public int[] spans() {
        return spans;
    }

    public Dimensions replaceAxis(int axis, int sum) {
        int[] newdims = Arrays.copyOf(dims, dims.length);
        newdims[axis] = sum;
        return new Dimensions(newdims);
    }

    public int calculateIndexWithAxes(int[] indx, int[] axes) {
        int i;
        int result = 0;
        int[] spans = this.spans;
        for (i = 0; i < indx.length; i++) {
            result += spans[axes[i]] * indx[i];
        }
        return result;
    }

    public Dimensions computeInnerProdDims(Dimensions b) {
        int[] result = new int[rank() - 1 + (b.rank() - 1)];
        for (int i = 0; i < rank() - 1; i++) {
            result[i] = dims[i];
        }
        for (int i = 0; i < b.rank() - 1; i++) {
            result[i + rank() - 1] = b.dims[i + 1];
        }
        return new Dimensions(result);
    }

    public int firstDim() {
        if (dims.length == 0)
            return 0;
        return dims[0];
    }
}
