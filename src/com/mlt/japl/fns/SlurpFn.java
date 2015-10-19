package com.mlt.japl.fns;

import com.mlt.japl.errors.IoError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.interf.ICharArray;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class SlurpFn extends BaseFn {
    public SlurpFn(int axis) {
        super(axis);
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        CharArray fn = (CharArray) a.force();
        try {
            String f = IOUtils.toString(new FileInputStream(fn.getString()), Charset.forName("UTF-8"));
            return new CharArray(f);
        } catch (IOException e) {
            throw new IoError();
        }
    }
}
