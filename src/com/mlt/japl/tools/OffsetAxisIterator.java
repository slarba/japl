package com.mlt.japl.tools;

public class OffsetAxisIterator extends AxisIterator {

    private int offset;

    public OffsetAxisIterator(int[] dims, int[] spans, int axis, int offset) {
        super(dims, spans, axis);
        this.offset = offset % dims[axis];
    }

    @Override
    public int index() {
        int i;
        int result = 0;
        int[] spans = this.spans;
        for (i = 0; i < iter.length; i++) {
            if (i == axis) result += spans[i] * ((dims[i] + iter[i] + offset) % dims[i]);
            else result += spans[i] * iter[i];
        }
        return result;
    }

}
