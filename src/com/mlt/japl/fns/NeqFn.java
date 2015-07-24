package com.mlt.japl.fns;

public class NeqFn extends LogicalBaseFn {
	@Override
	public int I_CC(char a, char b) {
		return a!=b ? 1 : 0;
	}

	@Override
	public long I_DD(double a, double b) {
		return a!=b ? 1 : 0;
	}

	@Override
	public long I_DI(double a, long b) {
		return a!=b ? 1 : 0;
	}

	@Override
	public long I_ID(long a, double b) {
		return a!=b ? 1 : 0;
	}

	@Override
	public long I_II(long a, long b) {
		return a!=b ? 1 : 0;
	}

	@Override
	public long I_CI(char a, long b) {
		return 1;
	}

	@Override
	public long I_IC(long a, char b) {
		return 1;
	}

	@Override
	public long I_CD(char a, double b) {
		return 1;
	}

	@Override
	public long I_DC(double a, char b) {
		return 1;
	}

	@Override
	public String getName() {
		return "!=";
	}

}
