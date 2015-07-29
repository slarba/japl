package com.mlt.japl.arrays;

import java.util.Arrays;

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

	public BitArray(Dimensions dims, boolean allocateEmpty, int actualLength) {
		super(dims);
		this.actualLen = actualLength;
		data = new long[1+(actualLength/64)];
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
		// TODO: hugely inefficient copy for now!
		if(newShape.length()<length()) {
			Array b = new BitArray(newShape, true, newShape.length());
			for(int i=0; i<newShape.length(); i++)
				b.setB(i, atB(i));
			return b;
		}
		Array b = new BitArray(newShape, true, length());
		for(int i=0; i<length(); i++)
			b.setB(i, atB(i));
		return b;
	}

	@Override
	public Array unInitializedCopy() {
		return new BitArray(dims(), true, length(), new long[1+(length()/64)]);
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
		return (data[whole]>>>part)&1;
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

	@Override
	public void setA(int idx, Array val) {
		setB(idx, val.atI(idx));
	}

	// integer AND bitarray
	public Array and(long atI) {
		if(atI==1) return this;
		if(atI==0) return new BitArray(dims(), 0);
		throw new DomainError();
	}

	// integer OR bitarray
	public Array or(long atI) {
		if(atI==0) return this;
		if(atI==1) return new BitArray(dims(), 1);
		throw new DomainError();
	}

	// bitarray AND integer
	public Array andRight(long atI) {
		if(atI==1) return this;
		if(atI==0) return new BitArray(dims, 0);
		throw new DomainError();
	}

	// bitarray OR integer
	public Array orRight(long atI) {
		if(atI==1) return new BitArray(dims, 1);
		if(atI==0) return this;
		throw new DomainError();
	}
	
	// bitarray AND bitarray
	public Array and(BitArray bi) {
		long[] result = new long[data.length];
		long[] bdata = bi.data;
		long[] adata = this.data;
		for(int i=0; i<result.length; i++)
			result[i] = adata[i] & bdata[i];
		return new BitArray(dims(), true, actualLen, result);
	}

	// bitarray OR bitarray
	public Array or(BitArray bi) {
		long[] result = new long[data.length];
		long[] bdata = bi.data;
		long[] adata = this.data;
		for(int i=0; i<result.length; i++)
			result[i] = adata[i] | bdata[i];
		return new BitArray(dims(), true, actualLen, result);
	}
	
	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new IntScalar();
		return new BitArray(resultDims, true, resultDims.length(), new long[1+(resultDims.length()/64)]);
	}

	public Array not() {
		long[] result = new long[data.length];
		long[] adata = this.data;
		for(int i=0; i<result.length; i++)
			result[i] = adata[i] ^ (-1);
		return new BitArray(dims(), true, actualLen, result);
	}

//	@Override
//	public boolean equals(Object o) {
//		if(o==this) return true;
//		if(o instanceof BitArray) {
//			BitArray a = (BitArray)o;
//			if(!a.dims().equals(dims)) return false;
//			for(int i=0; i<a.length(); i++) {
//				if(a.atB(i) != atB(i)) return false;
//			}
//			return true;
//		}
//		return false;
//	}
}
