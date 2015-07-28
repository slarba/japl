package com.mlt.japl.fns;

import java.util.Arrays;

import com.mlt.japl.iface.Array;

public class ResultTypeMap {
	byte[] resultTypes = new byte[529];
	
	public ResultTypeMap() {
		// result type is always nested if either of the arguments is nested
		put(Array.NESTED, Array.NESTED);
		
		put(Array.NESTED, Array.NESTED, Array.NESTED);

		put(Array.NESTED, Array.BIT, Array.NESTED);
		put(Array.NESTED, Array.INTEGER, Array.NESTED);
		put(Array.NESTED, Array.CHARACTER, Array.NESTED);
		put(Array.NESTED, Array.DOUBLE, Array.NESTED);

		put(Array.BIT, Array.NESTED, Array.NESTED);
		put(Array.INTEGER, Array.NESTED, Array.NESTED);
		put(Array.CHARACTER, Array.NESTED, Array.NESTED);
		put(Array.DOUBLE, Array.NESTED, Array.NESTED);
	}

	public void put(int left, int right, int type) {
		resultTypes[left|(right<<5)] = (byte)type;
	}

	public void put(int left, int type) {
		resultTypes[left] = (byte)type;
	}
	
	public int get(int left) {
		return resultTypes[left];
	}
	
	public int get(int left, int right) {
		return resultTypes[left|(right<<5)];
	}
}
