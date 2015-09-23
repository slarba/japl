package com.mlt.japl.inliningtest;

public abstract class LazyArr extends BaseArr {
	private Object object;

	public LazyArr(Object object) {
		super(object);
		this.object = object;
	}

	public long toinenfunktio() {
		return System.currentTimeMillis() + 100;
	}
}
