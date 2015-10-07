package com.mlt.japl.newfns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;

public class StringSearchFn extends BaseFn {
	@Override
	public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
		CharArray re = (CharArray)a.force();
		CharArray s = (CharArray)b.force();
		Pattern p = Pattern.compile(re.getString());
		Matcher m = p.matcher(s.getString());
		
		List<IValue> groups = new ArrayList<IValue>();
		
		while(m.find()) {
			long[] d = new long[] { m.start(), m.end() };
			groups.add(new IntArray(new Dimensions(2), d));
		}

		return new MixedArray(new Dimensions(groups.size()), groups.toArray(new IValue[0]));
	}
}
