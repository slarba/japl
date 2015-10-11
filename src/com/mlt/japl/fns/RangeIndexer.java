package com.mlt.japl.fns;

import com.mlt.japl.fns.Indexer.IIndexer;

public class RangeIndexer implements IIndexer {
    int upto;
    int c;

    public RangeIndexer(int upto) {
        this.upto = upto - 1;
        this.c = 0;
    }

    public int get() {
        return c;
    }

    public boolean step() {
        if (c >= upto) {
            c = 0;
            return true;
        } else {
            c++;
            return false;
        }
    }
}