package com.mlt.japl.newfns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IIntArray;

public class GradeUpFn extends BaseFn {

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		IntArray as = (IntArray)a.force();
		long[] arr = as.data();
		
		List<Long> indices = new ArrayList<Long>();
		for(long i=0; i<a.length(); i++) {
			indices.add(i+1);
		}
		
		Comparator<Long> comparator = new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return Long.compare(arr[(int)o1.longValue()-1], arr[(int)o2.longValue()-1]);
			}
		};

		Collections.sort(indices, comparator);

		long[] result = new long[indices.size()];
		for(int i=0; i<result.length; i++) result[i] = indices.get(i);
				
		return new IntArray(a.dims(), result);
	}
}
