package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.FuncValue;
import com.mlt.japl.newfns.UserFn;
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
