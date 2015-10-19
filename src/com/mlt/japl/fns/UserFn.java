package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.ast.AstNode;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 10/10/15.
 */
public class UserFn extends BaseFn {
    private final AstNode body;
    private final EvalContext context;
    private final String leftArg;
    private final String rightArg;
    private final String resultArg;
    private String[] locals;

    public UserFn(AstNode body, EvalContext context, String leftArg, String rightArg, String resultArg, String[] locals) {
        this.body = body;
        this.context = context;
        this.leftArg = leftArg;
        this.rightArg = rightArg;
        this.resultArg = resultArg;
        this.locals = locals;
    }

    private void setupLocals(EvalContext context) {
        for(String l : locals) {
            context.setLocal(l, IntScalar.ZERO);
        }
    }

    @Override
    public IValue applyDyadic(IValue left, IValue right) {
        EvalContext derived = context.newFrame();
        if(locals!=null) setupLocals(derived);
        if(leftArg!=null) derived.set(leftArg, left);
        if(rightArg!=null) derived.set(rightArg, right);
        IValue retVal = body.eval(derived);
        if(resultArg!=null) {
            return derived.get(resultArg).get();
        } else
            return retVal;
    }

    @Override
    public IValue applyMonadic(IValue right) {
        EvalContext derived = context.newFrame();
        if(locals!=null) setupLocals(derived);
        derived.set(rightArg, right);
        IValue retVal = body.eval(derived);
        if(resultArg!=null) {
            return derived.get(resultArg).get();
        } else
            return retVal;
    }

    @Override
    public IValue applyNiladic() {
        EvalContext derived = context.newFrame();
        if(locals!=null) setupLocals(derived);
        IValue retval = body.eval(derived);
        if(resultArg!=null) {
            return derived.get(resultArg).get();
        } else
            return retval;
    }
}
