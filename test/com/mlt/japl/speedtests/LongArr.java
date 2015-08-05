package com.mlt.japl.speedtests;

public class LongArr implements Arr {
	long[] data;
	
	public LongArr(long[] data) {
		this.data = data;
	}
	
	/* (non-Javadoc)
	 * @see com.mlt.japl.speedtests.Arr#set(int, long)
	 */
	@Override
	public void set(int i, long d) {
		data[i] = d;
	}
	
	/* (non-Javadoc)
	 * @see com.mlt.japl.speedtests.Arr#get(int)
	 */
	@Override
	public long get(int i) {
		return data[i];
	}

	/* (non-Javadoc)
	 * @see com.mlt.japl.speedtests.Arr#length()
	 */
	@Override
	public int length() {
		return data.length;
	}
}
