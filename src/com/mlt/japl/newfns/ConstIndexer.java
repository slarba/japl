package com.mlt.japl.newfns;

import com.mlt.japl.newfns.Indexer.IIndexer;

public class ConstIndexer implements IIndexer {
    int c;

    public ConstIndexer(int c) {
        this.c = c;
    }

    public boolean step() {
        return true;
    }

    public int get() {
        return c;
    }
}