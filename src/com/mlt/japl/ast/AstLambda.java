package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.UserFn;
import com.mlt.japl.workspace.EvalContext;

public class AstLambda extends AstFunc {

    private AstNode body;

    public AstLambda(AstNode[] guards_assignments, AstNode body) {
        if(guards_assignments.length>0)
            this.body = new AstGuardedBody(guards_assignments, body);
        else
            this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        builder.append(AstNode.indent("   ", body.toString()));
        builder.append("}");
        return builder.toString();
    }

    @Override
    public IValue eval(EvalContext context) {
        return new FuncValue(new UserFn(body, context, "\u237a", "\u2375", null));
    }
}
