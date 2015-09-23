package com.mlt.japl.newfns;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.mlt.japl.errors.IoError;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.interf.ICharArray;

public class SlurpFn extends BaseFn {
	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		CharArray fn = (CharArray)a.force();
		try {
			String f = IOUtils.toString(new FileInputStream(fn.getString()), Charset.forName("UTF-8"));
			return new CharArray(f);
		} catch (IOException e) {
			throw new IoError();
		}
	}
}
