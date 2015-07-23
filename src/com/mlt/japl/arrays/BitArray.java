package com.mlt.japl.arrays;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class BitArray extends BaseArray {
	long[] data;
	int actualLen;  // in bits
	
	private static final long[] EMPTY = new long[] {};
	
	public BitArray() {
		data = EMPTY;
		actualLen = 0;
	}

	public BitArray(long... data) {
		super(new Dimensions(data.length));
		actualLen = data.length;
		initData(data);
	}

	public BitArray(Dimensions d, long... data) {
		super(d);
		actualLen = data.length;
		initData(data);
	}

	private void initData(long[] d) {
		this.data = new long[1+(actualLen/64)];
		for(int i=0; i<actualLen; i++) {
			setB(i, d[i]);
		}		
	}
	
	@Override
	public int type() {
		return BIT;
	}

	@Override
	public int actualLength() {
		return actualLen;
	}

	@Override
	public Array reshape(Dimensions newShape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array unInitializedCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array morePreciseUnInitializedCopy(Array b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setB(int idx, long val) {
		int i = idx % actualLen;
		int whole = i / 64;
		int part = i % 64;
		data[whole] |= val<<part;
	}

	@Override
	public long atB(int idx) {
		int i = idx % actualLen;
		int whole = i / 64;
		int part = i % 64;
		return (data[whole]&(1<<part))!=0 ? 1 : 0;
	}

	@Override
	public long atI(int idx) {
		return atB(idx);
	}
	
	@Override
	public void setI(int idx, long val) {
		setB(idx, val);
	}
}
