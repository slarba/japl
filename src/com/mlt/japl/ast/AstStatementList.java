package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstStatementList implements AstNode {

    private AstNode[] stmts;

    public AstStatementList(AstNode[] stmts) {
        this.stmts = stmts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (AstNode s : stmts) {
            builder.append(s.toString());
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue result = null;
        int i=0;
        for(i=0; i<stmts.length; i++) {
            try {
                result = stmts[i].eval(context);
            } catch(JumpSignal jump) {
                i = jump.getLine();
            }
        }
        return result;
    }
}
