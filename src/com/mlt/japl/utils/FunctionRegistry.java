package com.mlt.japl.utils;

import java.util.HashMap;

import com.mlt.japl.newfns.NotFn;
import com.mlt.japl.newfns.OrFn;
import com.mlt.japl.newfns.PassFn;
import com.mlt.japl.newfns.AbsFn;
import com.mlt.japl.newfns.AddFn;
import com.mlt.japl.newfns.AndFn;
import com.mlt.japl.newfns.CeilFn;
import com.mlt.japl.newfns.DepthFn;
import com.mlt.japl.newfns.DiscloseFn;
import com.mlt.japl.newfns.DivFn;
import com.mlt.japl.newfns.DropFn;
import com.mlt.japl.newfns.EachFn;
import com.mlt.japl.newfns.EncloseFn;
import com.mlt.japl.newfns.EqFn;
import com.mlt.japl.newfns.ExistsFn;
import com.mlt.japl.newfns.ExpFn;
import com.mlt.japl.newfns.FacFn;
import com.mlt.japl.newfns.FloorFn;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.newfns.GtFn;
import com.mlt.japl.newfns.GteFn;
import com.mlt.japl.newfns.IotaFn;
import com.mlt.japl.newfns.LogFn;
import com.mlt.japl.newfns.LtFn;
import com.mlt.japl.newfns.LteFn;
import com.mlt.japl.newfns.MulFn;
import com.mlt.japl.newfns.NandFn;
import com.mlt.japl.newfns.NeqFn;
import com.mlt.japl.newfns.NorFn;
import com.mlt.japl.newfns.RavelFn;
import com.mlt.japl.newfns.ReduceFn;
import com.mlt.japl.newfns.ReplicateFn;
import com.mlt.japl.newfns.ReverseFn;
import com.mlt.japl.newfns.RotateFn;
import com.mlt.japl.newfns.RhoFn;
import com.mlt.japl.newfns.RollFn;
import com.mlt.japl.newfns.ScanFn;
import com.mlt.japl.newfns.StopFn;
import com.mlt.japl.newfns.SubFn;
import com.mlt.japl.newfns.TakeFn;
import com.mlt.japl.newfns.TrigFn;
import com.mlt.japl.newfns.UnionFn;
import com.mlt.japl.newfns.ZildeFn;

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
		map.put("\u222a", new UnionFn());
		map.put("\u22a3", new StopFn());
		map.put("\u22a2", new PassFn());
		map.put("/", new ReplicateFn(false));	
		map.put("\u233f", new ReplicateFn(true));
		map.put("⍬", new ZildeFn());
//		map.put("\\", new ExpandFn(false));
//		map.put("\u2340", new ExpandFn(true));
//		map.put("\u234b", new GradeUpFn(true));
//		map.put("\u2352", new GradeUpFn(false));
//		map.put("\u2337", new IndexFn());
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
			case "¨": return new EachFn(arg);
			case "\u233f": return new ReduceFn(arg, true);
			case "\u2340": return new ScanFn(arg, true);
			case "\u233f¨": return new EachFn(new ReduceFn(arg, true));
			case "\u2340¨": return new EachFn(new ScanFn(arg, true));
			default:
				return null;
		}
		
	}
}
