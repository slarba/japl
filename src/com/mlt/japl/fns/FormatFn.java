package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.utils.PrintConfig;

public class FormatFn extends BaseFn {
    private PrintConfig config;

    public FormatFn(int axis, PrintConfig config) {
        super(axis);
        this.config = config;
    }

    @Override
    public IValue applyMonadic(IValue a) {
        return new CharArray(a.asString(config));
    }

    @Override
    public String getName() {
        return "format";
    }
}
