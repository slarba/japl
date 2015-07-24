package com.mlt.japl.arrays;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
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
	
	public BitArray(int actualLength, Dimensions dims) {
		super(dims);
		this.actualLen = actualLength;
		this.data = new long[1+(actualLen/64)];
	}

	private BitArray(Dimensions dims, boolean b, long[] result) {
		super(dims);
		this.actualLen = dims.length();
		this.data = result;
	}

	private BitArray(Dimensions dims, boolean b, int oldActualLen, long[] result) {
		super(dims);
		this.actualLen = oldActualLen;
		this.data = result;
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
		return new BitArray(newShape, true, actualLen, data);
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
	public Array atA(int idx) {
		return new IntScalar(atB(idx));
	}
	
	@Override
	public void setI(int idx, long val) {
		setB(idx, val);
	}

	public static Array similarTo(Array a) {
		return new BitArray(a.actualLength(), a.dims());		
	}

	public Array and(long atI) {
		if(atI==1) return this;
		return new BitArray(dims(), 0);
	}

	public Array or(long atI) {
		if(atI==0) return this;
		return new BitArray(dims(), 1);
	}

	public Array andRight(long atI) {
		if(atI==1) return new BitArray(dims, 1);
		return new BitArray(dims, 0);
	}

	public Array and(BitArray bi) {
		long[] result = new long[Math.max(1+(length()/64), 1+(bi.length()/64))];
		long[] bdata = bi.data;
		long[] adata = this.data;
		for(int i=0; i<result.length; i++)
			result[i] = adata[i] & bdata[i];
		return new BitArray(dims(), true, result);
	}
	
}
