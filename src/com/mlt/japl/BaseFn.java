package com.mlt.japl;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;

public abstract class BaseFn implements Func {

	public abstract Array createResultArrayFor(Array a, int axis);
	public abstract Array createResultArrayFor(Array a, Array b, int axis);

	@Override
	public double D_D(double d) {
		throw new AplError();
	}
	@Override
	public double D_I(long d) {
		throw new AplError();
	}
	@Override
	public double D_DD(double a, double b) {
		throw new AplError();
	}
	@Override
	public double D_DI(double a, long b) {
		throw new AplError();
	}
	@Override
	public double D_ID(long a, double b) {
		throw new AplError();
	}
	@Override
	public double D_II(long a, long b) {
		throw new AplError();
	}

	@Override
	public long I_D(double d) {
		throw new AplError();
	}

	@Override
	public long I_I(long d) {
		throw new AplError();
	}

	@Override
	public long I_DD(double a, double b) {
		throw new AplError();
	}

	@Override
	public long I_DI(double a, long b) {
		throw new AplError();
	}

	@Override
	public long I_ID(long a, double b) {
		throw new AplError();
	}

	@Override
	public long I_II(long a, long b) {
		throw new AplError();
	}
	
	Array loop_I_I(Array r, Array a) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_I(a.atI(i)));
		return r;
	}

	Array loop_D_I(Array r, Array a) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, D_I(a.atI(i)));
		return r;
	}

	Array loop_I_D(Array r, Array a) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_D(a.atD(i)));
		return r;
	}

	Array loop_D_D(Array r, Array a) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, D_D(a.atD(i)));
		return r;
	}

	
	Array loop_I_I_I(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_II(a.atI(i), b.atI(i)));
		return r;
	}

	Array loop_I_D_I(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_DI(a.atD(i), b.atI(i)));
		return r;
	}

	Array loop_I_I_D(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_ID(a.atI(i), b.atD(i)));
		return r;
	}

	Array loop_I_D_D(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_DD(a.atD(i), b.atD(i)));
		return r;
	}

	Array loop_D_I_I(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, D_II(a.atI(i), b.atI(i)));
		return r;
	}

	Array loop_D_D_I(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, D_DI(a.atD(i), b.atI(i)));
		return r;
	}

	Array loop_D_I_D(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, D_ID(a.atI(i), b.atD(i)));
		return r;
	}

	Array loop_D_D_D(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, D_DD(a.atD(i), b.atD(i)));
		return r;
	}
	
	Array loop_M_A(Array r, Array a, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setA(i, monadic(a.atA(i),axis));
		return r;		
	}

	Array loop_M_A_A(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setA(i, dyadic(a.atA(i),b.atA(i), axis));
		return r;		
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		Array result = createResultArrayFor(a, axis);

		switch(result.type()) {
		case Array.INTEGER:
			switch(a.type()) {
			case Array.INTEGER: return loop_I_I(result, a);
			case Array.DOUBLE:  return loop_I_D(result, a);
			}
		case Array.DOUBLE:
			switch(a.type()) {
			case Array.INTEGER: return loop_D_I(result, a);
			case Array.DOUBLE:  return loop_D_D(result, a);
			}
		case Array.MIXED:
			return loop_M_A(result, a, axis);
		}

		throw new DomainError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		Array result = createResultArrayFor(a, b, axis);

		switch(result.type()) {
		case Array.INTEGER:
			switch(a.type()) {
			case Array.INTEGER:
				switch(b.type()) {
				case Array.INTEGER:  return loop_I_I_I(result, a, b);
				case Array.DOUBLE:   return loop_I_I_D(result, a, b);
				}
			case Array.DOUBLE:
				switch(b.type()) {
				case Array.INTEGER:  return loop_I_D_I(result, a, b);
				case Array.DOUBLE:   return loop_I_D_D(result, a, b);
				}
			}
		case Array.DOUBLE:
			switch(a.type()) {
			case Array.INTEGER:
				switch(b.type()) {
				case Array.INTEGER:  return loop_D_I_I(result, a, b);
				case Array.DOUBLE:   return loop_D_I_D(result, a, b);
				}
			case Array.DOUBLE:
				switch(b.type()) {
				case Array.INTEGER:  return loop_D_D_I(result, a, b);
				case Array.DOUBLE:   return loop_D_D_D(result, a, b);
				}
			}
		case Array.MIXED:
			return loop_M_A_A(result, a, b, axis);
		}
	
		throw new DomainError();
	}
}
