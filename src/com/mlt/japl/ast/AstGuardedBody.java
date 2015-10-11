package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstGuardedBody implements AstNode {
    private final AstNode[] guards;
    private final AstNode body;

    public AstGuardedBody(AstNode[] guards, AstNode body) {
        this.guards = guards;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("guarded:");
        for (AstNode n : guards) builder.append(n.toString() + "\n");
        builder.append(body.toString());
        builder.append(":guarded");
        return builder.toString();
    }

    @Override
    public IValue eval(EvalContext context) {
        try {
            for (int i = 0; i < guards.length; i++)
                guards[i].eval(context);
        } catch(ReturnSignal signal) {
            return signal.getVal();
        }
        return body.eval(context);
    }
}
