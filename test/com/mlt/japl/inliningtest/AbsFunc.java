package com.mlt.japl.inliningtest;

public class AbsFunc implements IFunc {

	@Override
	public IArr apply(IArr a, int index) {
		return new LazyArr(new Object()) {
			@Override
			public double get(int index) {
				return Math.abs(a.get(index));
			}
		};
	}

	@Override
	public IArr apply(IArr a, IArr b, int index) {
		return null;
	}

}
