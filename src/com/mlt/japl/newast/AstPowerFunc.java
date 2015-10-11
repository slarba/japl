package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.FuncValue;
import com.mlt.japl.newfns.PowerFunc;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstPowerFunc extends AstFunc {
    private AstFunc func;
    private AstNode arg;

    public AstPowerFunc(AstFunc func, AstNode arg) {
        this.func = func;
        this.arg = arg;
    }

    @Override
    public IValue eval(EvalContext context) {
        FuncValue fn = (FuncValue)func.eval(context);
        IValue times = arg.eval(context);
        return new FuncValue(new PowerFunc(fn.get(), times));
    }

    @Override
    public String toString() {
        return func.toString() + "§" + arg.toString();
    }
}
