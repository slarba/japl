package com.mlt.japl.newfns;

import java.util.Arrays;

import com.mlt.japl.errors.IndexError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class Indexer {
	private IValue array;
	IIndexer[] indexers;
	int[] ri;
	private IMixedArray index;

	interface IIndexer {
		boolean step();
		int get();
	}

	class ConstIndexer implements IIndexer {
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
	
	class RangeIndexer implements IIndexer {
		int upto;
		int c;
		
		public RangeIndexer(int upto) {
			this.upto = upto;
			this.c = 0;
		}

		public int get() {
			return c;
		}
		
		public boolean step() {
			if(c>=upto) {
				c=0;
				return true;
			} else {
				c++;
				return false;				
			}
		}
	}

	class ValueIndexer implements IIndexer {
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
			if(c>=vals.length) {
				c=0;
				return true;
			} else {
				c++;
				return false;
			}
		}
	}
	
	public Indexer(IMixedArray index, IValue array) {
		this.array = array;
		this.index = index;
		ri = new int[index.length()];
		indexers = new IIndexer[index.length()];
		for(int i=0; i<index.length(); i++) {
			IValue v = index.get(i);
			if(v instanceof IIntScalar) {
				indexers[i] = new ConstIndexer((int)((IIntScalar)v).get()-1);
			} else if(v.length()==0) {
				indexers[i] = new RangeIndexer(array.dims().axis(i));
			} else {
				IntArray ia = (IntArray)v.force();
				indexers[i] = new ValueIndexer(ia.data());
			}
		}		
	}

	public int step() {
		for(int i=0; i<ri.length; i++) {
			ri[i] = indexers[i].get();
			if(ri[i]<0 || ri[i]>=array.dims().axis(i)) throw new IndexError();
		}
		for(int i=ri.length-1; i>=0; i--) {
			if(!indexers[i].step()) break;
		}
		return array.dims().calculateIndex(ri);
	}
	
	public int[] computeResultDims() {
		if(index.length()!=array.rank()) throw new IndexError();
		int x=0;
		int[] resultDims = new int[array.rank()];
		for(int j=0; j<index.length(); j++) {
			IValue idx = index.get(j);
			if(idx instanceof IIntScalar) {
				continue;
			} else if(idx.length()==0) {
				resultDims[x++] = array.dims().axis(j);
			} else {
				resultDims[x++] = idx.length();
			}
		}
		return Arrays.copyOf(resultDims, x);
	}
	
	public int indexForSingle() {
		for(int i=0; i<index.length(); i++) {
			ri[i] = (int)((IIntScalar)index.get(i)).get()-1;
			if(ri[i]<0 || ri[i]>=array.dims().axis(i)) throw new IndexError();
		}
		return array.dims().calculateIndex(ri);
	}
}
