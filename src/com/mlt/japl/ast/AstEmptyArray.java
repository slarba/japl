package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstEmptyArray implements AstNode {

    @Override
    public IValue eval(EvalContext context) {
        return IntArray.EMPTY;
    }

    @Override
    public String toString() {
        return "[<empty>]";
    }
}
