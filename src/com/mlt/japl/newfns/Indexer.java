package com.mlt.japl.newfns;

import com.mlt.japl.errors.IndexError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;

import java.util.ArrayList;

public class Indexer {
    IIndexer[] indexers;
    int[] ri;
    private IValue array;
    private IMixedArray index;

    public Indexer(IMixedArray index, IValue array) {
        this.array = array;
        this.index = index;
        if (index.length() != array.rank()) throw new IndexError();
        ri = new int[index.length()];
        indexers = new IIndexer[index.length()];
        for (int i = 0; i < index.length(); i++) {
            IValue v = index.get(i);
            if (v instanceof IIntScalar) {
                indexers[i] = new ConstIndexer((int) ((IIntScalar) v).get() - 1);
            } else if (v.length() == 0) {
                indexers[i] = new RangeIndexer(array.dims().axis(i));
            } else {
                IntArray ia = (IntArray) v.force();
                indexers[i] = new ValueIndexer(ia.data());
            }
        }
    }

    public int step() {
        for (int i = 0; i < ri.length; i++) {
            ri[i] = indexers[i].get();
            if (ri[i] < 0 || ri[i] >= array.dims().axis(i)) throw new IndexError();
        }
        for (int i = ri.length - 1; i >= 0; i--) {
            if (!indexers[i].step()) break;
        }
        return array.dims().calculateIndex(ri);
    }

    public int[] computeResultDims() {
        if (index.length() != array.rank()) throw new IndexError();
        ArrayList<Integer> resultDims = new ArrayList<Integer>();
        for (int j = 0; j < index.length(); j++) {
            IValue idx = index.get(j);
            if (idx instanceof IIntScalar) {
                continue;
            } else if (idx.length() == 0) {
                resultDims.add(array.dims().axis(j));
            } else {
                for (int k = 0; k < idx.dims().rank(); k++) {
                    resultDims.add(idx.dims().axis(k));
                }
            }
        }
        int[] result = new int[resultDims.size()];
        for (int i = 0; i < result.length; i++) result[i] = resultDims.get(i);
        return result;
    }

    public int indexForSingle() {
        for (int i = 0; i < index.length(); i++) {
            ri[i] = (int) ((IIntScalar) index.get(i)).get() - 1;
            if (ri[i] < 0 || ri[i] >= array.dims().axis(i)) throw new IndexError();
        }
        return array.dims().calculateIndex(ri);
    }

    interface IIndexer {
        boolean step();

        int get();
    }
}
