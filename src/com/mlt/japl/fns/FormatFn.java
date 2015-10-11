package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.utils.PrintConfig;

public class FormatFn extends BaseFn {
    private PrintConfig config;

    public FormatFn(PrintConfig config) {
        this.config = config;
    }

    @Override
    public IValue applyMonadic(IValue a, int axis) {
        return new CharArray(a.asString(config));
    }

    @Override
    public String getName() {
        return "format";
    }
}
