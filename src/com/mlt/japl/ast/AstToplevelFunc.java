package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.UserFn;
import com.mlt.japl.workspace.EvalContext;

import java.util.Arrays;

/**
 * Created by markolau on 09/10/15.
 */
public class AstToplevelFunc extends AstFunc {
    private final AstNode body;
    private final String retvar;
    private final String name;
    private final String leftarg;
    private final String rightarg;
    private final String[] locals;

    public AstToplevelFunc(String name, String retvar, AstNode body, String leftarg, String rightarg, String[] locals) {
        this.name = name;
        this.retvar = retvar;
        this.body = body;
        this.leftarg = leftarg;
        this.rightarg = rightarg;
        this.locals = locals;
    }

    @Override
    public String toString() {
        return name + " <- function(" + (leftarg!=null ? (leftarg + ",") : "") + rightarg + ") {\n"
                + Arrays.toString(locals) + "\n" + AstNode.indent("   ", body.toString())
                + "}";
    }

    @Override
    public IValue eval(EvalContext context) {
        context.set(name, new FuncValue(new UserFn(body, context, leftarg, rightarg, retvar)));
        return null;
    }
}
