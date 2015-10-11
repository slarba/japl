package com.mlt.japl.newfns;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IIntScalar;

/**
 * Created by markolau on 11/10/15.
 */
public class PowerFunc extends BaseFn {

    private final Func fn;
    private final IValue times;

    public PowerFunc(Func fn, IValue times) {
        this.fn = fn;
        this.times = times;
    }

    @Override
    public IValue applyMonadic(IValue right, int axis) {
        if(!(times instanceof IIntScalar)) throw new ValueError();
        IIntScalar t = (IIntScalar) times;
        for(int i=0; i<t.get(); i++) {
            right = fn.applyMonadic(right, axis);
        }
        return right;
    }
}
