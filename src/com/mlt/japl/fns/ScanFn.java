package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;

public class ScanFn extends BaseFn {

    private Func fn;

    public ScanFn(int axis, Func fn, boolean b) {
        super(axis);
        this.fn = fn;
    }

    @Override
    public IValue applyDyadic(IValue a, IValue b) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue applyMonadic(IValue a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue applyNiladic() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return "scan<" + fn.getName() + ">";
    }
}
