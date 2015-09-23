package com.mlt.japl.inliningtest;

public class DArr extends BaseArr {
	private double[] data;
	private int datalen;
	
	public DArr(double[] d) {
		super(new Object());
		data = d;
		datalen = data.length;
	}
	
	@Override
	public double get(int index) {
		return data[index%datalen];
	}
}
