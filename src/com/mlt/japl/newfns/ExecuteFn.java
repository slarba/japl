package com.mlt.japl.newfns;

import java.io.StringReader;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.parser.ParseException;
import com.mlt.japl.workspace.EvalContext;

public class ExecuteFn extends BaseFn {

	private EvalContext context;

	public ExecuteFn(EvalContext ctx) {
		this.context = ctx;
	}
	
	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		CharArray v = (CharArray)a.force();
		AplParser parser = new AplParser(new StringReader(v.getString()), context);
		try {
			return parser.apl_expr().eval(context);
		} catch (ParseException e) {
			throw new AplError();
		}
	}
}
