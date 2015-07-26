package com.mlt.japl.fns;

import com.mlt.japl.errors.ValueError;

public class TrigFn extends PrimitiveBaseFn {

	@Override
	public double D_I(long a) {
		return Math.PI*a;
	}

	@Override
	public double D_D(double a) {
		return Math.PI*a;
	}

	@Override
	public double D_II(long a, long b) {
		return D_ID(a, (double)b);
	}
	
	@Override
	public double D_ID(long a, double b) {
		switch((int)a) {
		case -7: return 0.5*Math.log( (b + 1.0) / (b - 1.0) ); 
		case -6: return Math.log(b + Math.sqrt(b*b - 1.0));
		case -5: return Math.log(b + Math.sqrt(b*b + 1.0));
		case -4: return Math.sqrt(b*2-1);
		case -3: return Math.atan(b);
		case -2: return Math.acos(b);
		case -1: return Math.asin(b);
		case 0: return Math.sqrt(1-(b*2));
		case 1: return Math.sin(b);
		case 2: return Math.cos(b);
		case 3: return Math.tan(b);
		case 4: return Math.sqrt((b*2)+1);
		case 5: return Math.sinh(b);
		case 6: return Math.cosh(b);
		case 7: return Math.tanh(b);
		default:
			throw new ValueError();
		}
	}
	
	@Override
	public String getName() {
		return "trig";
	}

}
