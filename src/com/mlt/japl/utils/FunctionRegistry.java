package com.mlt.japl.utils;

import java.util.HashMap;

import com.mlt.japl.fns.AbsFn;
import com.mlt.japl.fns.AddFn;
import com.mlt.japl.fns.AndFn;
import com.mlt.japl.fns.CeilFn;
import com.mlt.japl.fns.DepthFn;
import com.mlt.japl.fns.DiscloseFn;
import com.mlt.japl.fns.DivFn;
import com.mlt.japl.fns.DropFn;
import com.mlt.japl.fns.EachFn;
import com.mlt.japl.fns.EncloseFn;
import com.mlt.japl.fns.EqFn;
import com.mlt.japl.fns.ExistsFn;
import com.mlt.japl.fns.ExpFn;
import com.mlt.japl.fns.ExpandFn;
import com.mlt.japl.fns.FacFn;
import com.mlt.japl.fns.FloorFn;
import com.mlt.japl.fns.GradeUpFn;
import com.mlt.japl.fns.GtFn;
import com.mlt.japl.fns.GteFn;
import com.mlt.japl.fns.IndexFn;
import com.mlt.japl.fns.IotaFn;
import com.mlt.japl.fns.LogFn;
import com.mlt.japl.fns.LtFn;
import com.mlt.japl.fns.LteFn;
import com.mlt.japl.fns.MulFn;
import com.mlt.japl.fns.NeqFn;
import com.mlt.japl.fns.NotFn;
import com.mlt.japl.fns.OrFn;
import com.mlt.japl.fns.PassFn;
import com.mlt.japl.fns.RavelFn;
import com.mlt.japl.fns.ReduceFn;
import com.mlt.japl.fns.ReplicateFn;
import com.mlt.japl.fns.ReverseFn;
import com.mlt.japl.fns.RhoFn;
import com.mlt.japl.fns.RollFn;
import com.mlt.japl.fns.ScanFn;
import com.mlt.japl.fns.StopFn;
import com.mlt.japl.fns.SubFn;
import com.mlt.japl.fns.TakeFn;
import com.mlt.japl.fns.TrigFn;
import com.mlt.japl.fns.UnionFn;
import com.mlt.japl.iface.Func;
import com.mlt.japl.iface.PrimitiveFunc;

public class FunctionRegistry {

	HashMap<String, Func> map;
	
	public FunctionRegistry() {
		map = new HashMap<String,Func>();
		
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
//		map.put("\u2371", new NorFn());  // nor
//		map.put("\u2372", new NandFn());  // nand
//		map.put("\u2349", new ReverseFn());
		map.put("\u233d", new ReverseFn(false));
		map.put("\u2296", new ReverseFn(true));
		map.put("\u2191", new TakeFn());
		map.put("\u2193", new DropFn());
		map.put("\u2261", new DepthFn());
		map.put("\u2282", new EncloseFn());
		map.put("\u2283", new DiscloseFn());
//		map.put("\u22a5", new DecodeFn());
		map.put("\u222a", new UnionFn());
		map.put("\u22a3", new StopFn());
		map.put("\u22a2", new PassFn());
		map.put("/", new ReplicateFn(false));	
		map.put("\u233f", new ReplicateFn(true));
		map.put("\\", new ExpandFn(false));
		map.put("\u2340", new ExpandFn(true));
		map.put("\u234b", new GradeUpFn(true));
		map.put("\u2352", new GradeUpFn(false));
		map.put("\u2337", new IndexFn());
	}
	
	public Func lookup(String name) {
		return map.getOrDefault(name, null);
	}
	
	public Func buildMonadicOperator(String n, Func arg) {
		switch(n)
		{
			case "/":  return new ReduceFn(arg, false);
			case "/¨":  return new EachFn(new ReduceFn(arg, false));
			case "\\": return new ScanFn(arg, false);
			case "\\¨": return new EachFn(new ScanFn(arg, false));
			case "¨":
				if(arg instanceof PrimitiveFunc) return arg;  // each does nothing productive with primitive functions
				else return new EachFn(arg);
			case "\u233f": return new ReduceFn(arg, true);
			case "\u2340": return new ScanFn(arg, true);
			case "\u233f¨": return new EachFn(new ReduceFn(arg, true));
			case "\u2340¨": return new EachFn(new ScanFn(arg, true));
			default:
				return null;
		}
		
	}
}
