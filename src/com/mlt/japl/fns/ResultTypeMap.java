package com.mlt.japl.fns;

import java.util.Arrays;

import com.mlt.japl.iface.Array;

public class ResultTypeMap {
	byte[] resultTypes = new byte[529];
	
	public ResultTypeMap() {
		// result type is always nested if either of the arguments is nested
		put(Array.MIXED, Array.MIXED);
		
		put(Array.MIXED, Array.MIXED, Array.MIXED);

		put(Array.MIXED, Array.BIT, Array.MIXED);
		put(Array.MIXED, Array.INTEGER, Array.MIXED);
		put(Array.MIXED, Array.CHARACTER, Array.MIXED);
		put(Array.MIXED, Array.DOUBLE, Array.MIXED);

		put(Array.BIT, Array.MIXED, Array.MIXED);
		put(Array.INTEGER, Array.MIXED, Array.MIXED);
		put(Array.CHARACTER, Array.MIXED, Array.MIXED);
		put(Array.DOUBLE, Array.MIXED, Array.MIXED);
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
