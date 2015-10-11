package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 12/10/15.
 */
public class AstWhileNode implements AstNode {
    private AstNode condition;
    private AstNode body;

    public AstWhileNode(AstNode condition, AstNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue result = null;
        while(condition.eval(context).equals(IntScalar.ONE)) {
            result = body.eval(context);
        }
        return result;
    }
}
