package com.mlt.japl.fns;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.interf.ICharArray;
import com.mlt.japl.ast.AstNode;
import com.mlt.japl.parser.IParser;
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
            AstNode node = IParser.parse(new ByteArrayInputStream(v.getString().getBytes("UTF-8")), context);
            return node.eval(context);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new AplError();
        }
    }
}
