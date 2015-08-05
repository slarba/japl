package com.mlt.japl.speedtests;

public class InliningTest {
	
	public InliningTest() {
	}

	public void run() {
		long[] result = new long[1000000];
		long[] a = new long[23200];
		long[] b = new long[10000];

		long startTime;
		long endTime;
		
		startTime = System.currentTimeMillis();
		for(int i=0; i<3000; i++) {
			test1(result, a, b);
		}
		endTime = System.currentTimeMillis();
		System.out.println("test1 took: " + (endTime-startTime) + " milliseconds");

		startTime = System.currentTimeMillis();
		Arr r = new LongArr(result);
		Arr ai = new LongArr(a);
		Arr bi = new LongArr(b);
		Tester test2 = new Test2(new TestFunc());
		for(int i=0; i<3000; i++) {
			test2.test(r, ai, bi);
		}
		endTime = System.currentTimeMillis();
		System.out.println("test2 took: " + (endTime-startTime) + " milliseconds");
	
	}
	
	public void test1(long[] result, long[] a, long[] b) {
		int rlen = result.length;
		int alen = a.length;
		int blen = b.length;
		for(int i=0; i<rlen; i++)
			result[i] = a[i%alen] + b[i%blen];
	}

	public static void main(String[] args) {
		new InliningTest().run();
	}

}
