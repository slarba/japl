package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.IIntScalar;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 12/10/15.
 */
public class AstRepeatNode implements AstNode {
    private final AstNode count;
    private final AstNode body;

    public AstRepeatNode(AstNode count, AstNode body) {
        this.count = count;
        this.body = body;
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue c = count.eval(context);
        if(!(c instanceof IIntScalar)) throw new DomainError();
        IIntScalar s = (IIntScalar)c;
        IValue result = null;
        for(int i=0; i<s.get(); i++) {
            result = body.eval(context);
        }
        return result;
    }
}
