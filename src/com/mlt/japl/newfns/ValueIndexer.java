package com.mlt.japl.newfns;

import com.mlt.japl.newfns.Indexer.IIndexer;

public class ValueIndexer implements IIndexer {
	long[] vals;
	int c;
	
	public ValueIndexer(long[] vals) {
		this.vals = vals;
		this.c = 0;
	}
	
	public int get() {
		return (int)vals[c]-1;
	}
	
	public boolean step() {
		if(c>=vals.length-1) {
			c=0;
			return true;
		} else {
			c++;
			return false;
		}
	}
}