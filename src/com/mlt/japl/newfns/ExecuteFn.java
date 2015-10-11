package com.mlt.japl.newfns;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newast.AstNode;
import com.mlt.japl.parsing.Parser;
import com.mlt.japl.workspace.EvalContext;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class ExecuteFn extends BaseFn {

    private EvalContext context;

    public ExecuteFn(EvalContext ctx) {
        this.context = ctx;
    }

    @Override
    public IValue visit_monadic(ICharArray a, int axis) {
        CharArray v = (CharArray) a.force();
        try {
            AstNode node = Parser.parse(new ByteArrayInputStream(v.getString().getBytes("UTF-8")), context);
            return node.eval(context);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new AplError();
        }
    }
}
