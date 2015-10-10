package com.mlt.japl.newast;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.FuncValue;
import com.mlt.japl.newfns.*;
import com.mlt.japl.utils.PrintConfig;
import com.mlt.japl.workspace.EvalContext;

import java.util.HashMap;

/**
 * Created by markolau on 07/10/15.
 */
public class AstSimpleFunc extends AstFunc {
    private final String fn;
    private final AstNode axis;

    static HashMap<String, Func> map = new HashMap<>();

    static {

        map.put("\u003f", new RollFn());
        map.put("\u002b", new AddFn());
        map.put("\u2212", new SubFn());
        map.put("\u00d7", new MulFn());
        map.put("\u22c6", new ExpFn());
        map.put("*", new ExpFn());
        map.put("\u235f", new LogFn());
        map.put("\u002c", new RavelFn(false));
        map.put("⍪", new RavelFn(true));
        map.put("\u230a", new FloorFn());
        map.put("\u2308", new CeilFn());
        map.put("\u2223", new AbsFn());
        map.put("\u0021", new FacFn());
        map.put("\u00f7", new DivFn());
        map.put("\u2374", new RhoFn());
        map.put("\u2373", new IotaFn());
        map.put("\u25cb", new TrigFn());
        map.put("\u2208", new ExistsFn());
        map.put("\u003c", new LtFn());
        map.put("\u003e", new GtFn());
        map.put("\u2264", new LteFn());
        map.put("\u2265", new GteFn());
        map.put("\u003d", new EqFn());
        map.put("\u223c", new NotFn());
        map.put("\u2260", new NeqFn());
        map.put("\u2228", new OrFn());  // logical or
        map.put("\u2227", new AndFn());  // logical and
        map.put("\u2371", new NorFn());  // nor
        map.put("\u2372", new NandFn());  // nand
        map.put("\u2349", new ReverseFn());
        map.put("\u233d", new RotateFn(false));
        map.put("\u2296", new RotateFn(true));
        map.put("\u2191", new TakeFn());
        map.put("\u2193", new DropFn());
        map.put("\u2261", new DepthFn());
        map.put("\u2282", new EncloseFn());
        map.put("\u2283", new DiscloseFn());
//		map.put("\u22a5", new DecodeFn());
//		map.put("\....", new EncodeFn());
        map.put("\u222a", new UnionFn());
        map.put("∩", new IntersectionFn());
        map.put("\u22a3", new StopFn());
        map.put("\u22a2", new PassFn());
        map.put("/", new ReplicateFn(false));
        map.put("\u233f", new ReplicateFn(true));
        map.put("⍬", new ZildeFn());
        //map.put("⍎", new ExecuteFn(context));
        map.put("⎕NEW", new NewFn());
        map.put("⎕SLURP", new SlurpFn());
        map.put("⎕SS", new StringSearchFn());
        map.put("⍕", new FormatFn(new PrintConfig()));
//		map.put("\\", new ExpandFn(false));
//		map.put("\u2340", new ExpandFn(true));
        map.put("\u234b", new GradeUpFn());
        map.put("\u2352", new GradeDownFn());
        map.put("\u2337", new IndexFn());

    }
    public AstSimpleFunc(String text, AstNode axis) {
        this.fn = text;
        this.axis = axis;
    }

    @Override
    public String toString() {
        return fn + (axis!=null ? ("[" + axis.toString() + "]") : "");
    }

    @Override
    public IValue eval(EvalContext context) {
        Func f = map.get(fn);
        if(f==null) throw new ValueError();
        return new FuncValue(f);
    }
}
