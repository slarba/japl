package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.FuncValue;
import com.mlt.japl.newfns.UserFn;
import com.mlt.japl.workspace.EvalContext;

public class AstLambda extends AstFunc {

    private AstNode body;
    private AstNode[] guards_assignments;

    public AstLambda(AstNode[] astNodes, AstNode body) {
        this.guards_assignments = astNodes;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (AstNode n : guards_assignments) builder.append(AstNode.indent("   ", n.toString()));
        builder.append(AstNode.indent("   ", body.toString()));
        builder.append("}");
        return builder.toString();
    }

    @Override
    public IValue eval(EvalContext context) {
        return new FuncValue(new UserFn(body, context, "\u237a", "\u2375", null));
    }
}
