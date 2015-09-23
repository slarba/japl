package com.mlt.japl.inliningtest;

public abstract class BaseArr implements IArr {

	private Object object;

	public BaseArr(Object o) {
		this.object = o;
	}
	
	public long foo() {
		return System.currentTimeMillis();
	}

}
