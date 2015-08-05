package com.mlt.japl.speedtests;

public class Test2 implements Tester {
	Func fn;
	
	public Test2(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public void test(Arr result, Arr a, Arr b) {
		int rlen = result.length();
		int alen = a.length();
		int blen = b.length();
		for(int i=0; i<rlen; i++)
			result.set(i, fn.I_II(a.get(i%alen), b.get(i%blen)));
	}


}
