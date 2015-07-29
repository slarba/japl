package com.mlt.japl.utils;

import java.util.HashMap;

import com.mlt.japl.fns.*;
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
		map.put("\u235f", new LogFn());
		map.put("\u002c", new RavelFn());
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
//		map.put("/", new ReplicateFn());				
	}
	
	public Func lookup(String name) {
		return map.getOrDefault(name, null);
	}
	
	public Func buildMonadicOperator(String n, Func arg) {
		switch(n)
		{
			case "/":  return new ReduceFn(arg, false);
			case "\\": return new ScanFn(arg, false);
			case "¨":
				if(arg instanceof PrimitiveFunc) return arg;  // each does nothing productive with primitive functions
				else return new EachFn(arg);
			case "\u233f": return new ReduceFn(arg, true);
			case "\u2340": return new ScanFn(arg, true);
			default:
				return null;
		}
		
	}
}