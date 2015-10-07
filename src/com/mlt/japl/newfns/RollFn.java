package com.mlt.japl.newfns;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.tools.Dimensions;

import java.util.HashSet;
import java.util.Random;

public class RollFn extends BaseFn {

    Random rand = new Random(System.currentTimeMillis());

    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
        return new IntScalar(1 + Math.abs(rand.nextLong() % a.get()));
    }

    @Override
    public IValue visit_monadic(IIntArray a, int axis) {
        if (a.rank() == 1 && a.length() == 1) return new IntScalar(1 + Math.abs(rand.nextLong() % a.get(0)));
        long[] result = new long[a.length()];
        for (int i = 0; i < result.length; i++)
            result[i] = 1 + Math.abs(rand.nextLong() % a.get(i));
        return new IntArray(a.dims(), result);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
        long count = a.get();
        long max = b.get();
        if (count > max) throw new ValueError();
        HashSet<Long> set = new HashSet<Long>();
        while (set.size() < count) {
            set.add(1 + Math.abs(rand.nextLong() % max));
        }
        long[] result = new long[(int) count];
        int i = 0;
        for (Long n : set) {
            result[i++] = n;
        }
        return new IntArray(new Dimensions(result.length), result);
    }

    @Override
    public String getName() {
        return "roll";
    }

}
