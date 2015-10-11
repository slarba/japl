package com.mlt.japl.fns;

import com.mlt.japl.fns.Indexer.IIndexer;

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