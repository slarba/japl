package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.concrete.DoubleArray;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.arrays.generated.IotaArray;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GradeDownFn extends BaseFn {

    public GradeDownFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        if (a instanceof IotaArray) return a;
        int ax = this.axis;
        int axis = ax < 0 ? 0 : ax;

        IntArray as = (IntArray) a.force();
        int[] spans = as.dims().spans();

        List<Long> indices = new ArrayList<Long>();
        for (long i = 0; i < as.dims().axis(axis); i++) {
            indices.add(i + 1);
        }

        Comparator<Long> comparator = new Comparator<Long>() {
            @Override
            public int compare(Long o2, Long o1) {
                int o1index = (int) o1.longValue() - 1;
                int o2index = (int) o2.longValue() - 1;
                if (axis + 1 < as.rank()) {
                    for (int i = 0; i < as.dims().axis(axis + 1); i++) {
                        int result = Long.compare(as.get(o1index * spans[axis] + i * spans[axis + 1]),
                                as.get(o2index * spans[axis] + i * spans[axis + 1]));
                        if (result != 0) return result;
                    }
                    return 0;
                } else
                    return Long.compare(as.get(o1index * spans[axis]), as.get(o2index * spans[axis]));
            }
        };

        Collections.sort(indices, comparator);

        long[] result = new long[indices.size()];
        for (int i = 0; i < result.length; i++) result[i] = indices.get(i);

        return new IntArray(new Dimensions(as.dims().axis(axis)), result);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? 0 : ax;

        DoubleArray as = (DoubleArray) a.force();
        int[] spans = as.dims().spans();

        List<Long> indices = new ArrayList<Long>();
        for (long i = 0; i < as.dims().axis(axis); i++) {
            indices.add(i + 1);
        }

        Comparator<Long> comparator = new Comparator<Long>() {
            @Override
            public int compare(Long o2, Long o1) {
                int o1index = (int) o1.longValue() - 1;
                int o2index = (int) o2.longValue() - 1;
                if (axis + 1 < as.rank()) {
                    for (int i = 0; i < as.dims().axis(axis + 1); i++) {
                        int result = Double.compare(as.get(o1index * spans[axis] + i * spans[axis + 1]),
                                as.get(o2index * spans[axis] + i * spans[axis + 1]));
                        if (result != 0) return result;
                    }
                    return 0;
                } else
                    return Double.compare(as.get(o1index * spans[axis]), as.get(o2index * spans[axis]));
            }
        };

        Collections.sort(indices, comparator);

        long[] result = new long[indices.size()];
        for (int i = 0; i < result.length; i++) result[i] = indices.get(i);

        return new IntArray(new Dimensions(as.dims().axis(axis)), result);
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? 0 : ax;

        CharArray as = (CharArray) a.force();
        int[] spans = as.dims().spans();

        List<Long> indices = new ArrayList<Long>();
        for (long i = 0; i < as.dims().axis(axis); i++) {
            indices.add(i + 1);
        }

        Comparator<Long> comparator = new Comparator<Long>() {
            @Override
            public int compare(Long o2, Long o1) {
                int o1index = (int) o1.longValue() - 1;
                int o2index = (int) o2.longValue() - 1;
                if (axis + 1 < as.rank()) {
                    for (int i = 0; i < as.dims().axis(axis + 1); i++) {
                        int result = Character.compare(as.get(o1index * spans[axis] + i * spans[axis + 1]),
                                as.get(o2index * spans[axis] + i * spans[axis + 1]));
                        if (result != 0) return result;
                    }
                    return 0;
                } else
                    return Character.compare(as.get(o1index * spans[axis]), as.get(o2index * spans[axis]));
            }
        };

        Collections.sort(indices, comparator);

        long[] result = new long[indices.size()];
        for (int i = 0; i < result.length; i++) result[i] = indices.get(i);

        return new IntArray(new Dimensions(as.dims().axis(axis)), result);
    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        throw new RankError();
    }

    @Override
    public IValue visit_monadic(ICharScalar a) {
        throw new RankError();
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        throw new RankError();
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        throw new DomainError();
    }

    @Override
    public String getName() {
        return "gradedown";
    }

}
