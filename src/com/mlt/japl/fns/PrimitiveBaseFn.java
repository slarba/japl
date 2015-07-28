package com.mlt.japl.fns;

import java.util.HashMap;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.AplError;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.iface.PrimitiveFunc;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public abstract class PrimitiveBaseFn implements Func, PrimitiveFunc {
	ResultTypeMap resultTypes = new ResultTypeMap();
	
	public PrimitiveBaseFn() {
		// check which have been implemented in base class
		try { D_D(0);   resultTypes.put(Array.DOUBLE, Array.DOUBLE); } catch(AplError e) {}
		try { D_I(0);   resultTypes.put(Array.INTEGER, Array.DOUBLE); } catch(AplError e) {}

		try { I_D(0);   resultTypes.put(Array.DOUBLE, Array.INTEGER); } catch(AplError e) {}
		try { I_I(0);   resultTypes.put(Array.INTEGER, Array.INTEGER); } catch(AplError e) {}
		try { I_C(' '); resultTypes.put(Array.CHARACTER, Array.INTEGER); } catch(AplError e) {}

		try { D_DD(0,0);     resultTypes.put(Array.DOUBLE,Array.DOUBLE, Array.DOUBLE); } catch(AplError e) {}
		try { 
			D_DI(0,0);     
			resultTypes.put(Array.DOUBLE, Array.INTEGER, Array.DOUBLE); 
			resultTypes.put(Array.DOUBLE, Array.BIT, Array.DOUBLE);
			} catch(AplError e) {}
		try { D_ID(0,0);     
			resultTypes.put(Array.INTEGER, Array.DOUBLE, Array.DOUBLE); 
			resultTypes.put(Array.BIT, Array.DOUBLE, Array.DOUBLE);
			} catch(AplError e) {}
		try { D_II(0,0);     resultTypes.put(Array.INTEGER, Array.INTEGER, Array.DOUBLE); } catch(AplError e) {}

		try { I_CC(' ',' '); resultTypes.put(Array.CHARACTER, Array.CHARACTER, Array.INTEGER); } catch(AplError e) {}
		try { I_DD(0,0);     resultTypes.put(Array.DOUBLE, Array.DOUBLE, Array.INTEGER); } catch(AplError e) {}
		try { I_DI(0,0);     resultTypes.put(Array.DOUBLE, Array.INTEGER, Array.INTEGER); } catch(AplError e) {}
		try { I_ID(0,0);     resultTypes.put(Array.INTEGER, Array.DOUBLE, Array.INTEGER); } catch(AplError e) {}
		try {
			I_II(0,0);
			resultTypes.put(Array.INTEGER, Array.INTEGER, Array.INTEGER); 
			resultTypes.put(Array.INTEGER, Array.BIT, Array.INTEGER);
			resultTypes.put(Array.BIT, Array.INTEGER, Array.INTEGER);
			resultTypes.put(Array.BIT, Array.BIT, Array.INTEGER);
		} catch(AplError e) {}
		try { I_CI(' ',0);   resultTypes.put(Array.CHARACTER, Array.INTEGER, Array.INTEGER); } catch(AplError e) {}
		try { I_IC(0,' ');   resultTypes.put(Array.INTEGER, Array.CHARACTER, Array.INTEGER); } catch(AplError e) {}
		try { I_CD(' ',0);   resultTypes.put(Array.CHARACTER, Array.DOUBLE, Array.INTEGER); } catch(AplError e) {}
		try { I_DC(0,' ');   resultTypes.put(Array.DOUBLE, Array.CHARACTER, Array.INTEGER); } catch(AplError e) {}
	}
	
	public Array createResultArrayFor(Array a, int axis) {
		if(a.isScalar()) {
			return ArrayFactory.makeScalarOfType(resultTypeFor(a));
		}
		return ArrayFactory.makeSimilarArrayOfTypeWithActualLength(resultTypeFor(a), a);
	}

	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			if(b.isScalar()) {
				return ArrayFactory.makeScalarOfType(resultTypeFor(a, b));
			}
			return ArrayFactory.makeSimilarArrayOfTypeWithActualLength(resultTypeFor(a, b), b);
		}
		if(b.isScalar()) {
			return ArrayFactory.makeSimilarArrayOfTypeWithActualLength(resultTypeFor(a, b), a);			
		}
		checkEqualDimensionsAndRank(a, b);
		return ArrayFactory.makeSimilarArrayOfTypeWithActualLength(resultTypeFor(a, b), a);			
	}

	public void checkEqualDimensionsAndRank(Array a, Array b) {
		if(a.rank()!=b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		int t = resultTypes.get(a.type(), b.type());
		if(t==0) throw new DomainError();
		return t;
	}
	
	@Override
	public int resultTypeFor(Array a) {
		int t = resultTypes.get(a.type());
		if(t==0) throw new DomainError();
		return t;
	}

	@Override
	public int I_C(char c) {		
		throw new AplError();
	}

	@Override
	public int I_CC(char a, char b) {		
		throw new AplError();
	}
	
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

	@Override
	public long I_CI(char a, long b) {
		throw new AplError();
	}

	@Override
	public long I_IC(long a, char b) {
		throw new AplError();
	}

	@Override
	public long I_CD(char a, double b) {
		throw new AplError();
	}

	@Override
	public long I_DC(double a, char b) {
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

	Array loop_I_M(Array r, Array a, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, monadic(a.atA(i), axis).atI(0));
		return r;				
	}

	Array loop_D_M(Array r, Array a, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, monadic(a.atA(i), axis).atD(0));
		return r;				
	}
	
	Array loop_I_I_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}

	Array loop_D_I_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, dyadic(a.atA(i), b.atA(i), axis).atD(0));
		return r;
	}

	Array loop_D_D_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, dyadic(a.atA(i), b.atA(i), axis).atD(0));
		return r;
	}
	
	Array loop_I_M_I(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}

	Array loop_D_M_I(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, dyadic(a.atA(i), b.atA(i), axis).atD(0));
		return r;
	}

	Array loop_D_M_D(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, dyadic(a.atA(i), b.atA(i), axis).atD(0));
		return r;
	}

	Array loop_D_M_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setD(i, dyadic(a.atA(i), b.atA(i), axis).atD(0));
		return r;
	}
	
	Array loop_I_D_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}

	Array loop_I_M_D(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}

	Array loop_I_M_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}
	
	@Override
	public Array monadic(Array a, int axis) {
		Array result = createResultArrayFor(a, axis);

		switch(result.type()) {
		case Array.BIT:
		case Array.INTEGER:
			switch(a.type()) {
			case Array.BIT:
			case Array.INTEGER: return loop_I_I(result, a);
			case Array.DOUBLE:  return loop_I_D(result, a);
			case Array.NESTED:  return loop_I_M(result, a, axis);
			}
			break;
		case Array.DOUBLE:
			switch(a.type()) {
			case Array.BIT:
			case Array.INTEGER: return loop_D_I(result, a);
			case Array.DOUBLE:  return loop_D_D(result, a);
			case Array.NESTED:   return loop_D_M(result, a, axis);
			}
			break;
		case Array.NESTED:
			return loop_M_A(result, a, axis);
		}

		throw new DomainError();
	}

	Array loop_I_C_C(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_CC(a.atC(i), b.atC(i)));
		return r;
	}

	Array loop_I_C_I(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_CI(a.atC(i), b.atI(i)));
		return r;
	}

	Array loop_I_C_D(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_CD(a.atC(i), b.atD(i)));
		return r;
	}

	Array loop_I_C_M(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}

	Array loop_I_I_C(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_IC(a.atI(i), b.atC(i)));
		return r;
	}

	Array loop_I_D_C(Array r, Array a, Array b) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, I_DC(a.atD(i), b.atC(i)));
		return r;
	}

	Array loop_I_M_C(Array r, Array a, Array b, int axis) {
		int i;
		int rlen = r.actualLength();
		for(i=0; i<rlen; i++) r.setI(i, dyadic(a.atA(i), b.atA(i), axis).atI(0));
		return r;
	}
	
	@Override
	public Array dyadic(Array a, Array b, int axis) {
		Array result = createResultArrayFor(a, b, axis);

		switch(result.type()) {
		case Array.BIT:
		case Array.INTEGER:
			switch(a.type()) {
			case Array.BIT:
			case Array.INTEGER:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_I_I_I(result, a, b);
				case Array.DOUBLE:   return loop_I_I_D(result, a, b);
				case Array.NESTED:    return loop_I_I_M(result, a, b, axis);
				}
				break;
			case Array.DOUBLE:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_I_D_I(result, a, b);
				case Array.DOUBLE:   return loop_I_D_D(result, a, b);
				case Array.NESTED:    return loop_I_D_M(result, a, b, axis);
				}
				break;
			case Array.NESTED:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_I_M_I(result, a, b, axis);
				case Array.DOUBLE:   return loop_I_M_D(result, a, b, axis);
				case Array.NESTED:    return loop_I_M_M(result, a, b, axis);
				}
				break;
			case Array.CHARACTER:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_I_C_I(result, a, b);
				case Array.DOUBLE:   return loop_I_C_D(result, a, b);
				case Array.NESTED:    return loop_I_C_M(result, a, b, axis);
				case Array.CHARACTER:return loop_I_C_C(result, a, b);
				}
			}
			break;
		case Array.DOUBLE:
			switch(a.type()) {
			case Array.BIT:
			case Array.INTEGER:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_D_I_I(result, a, b);
				case Array.DOUBLE:   return loop_D_I_D(result, a, b);
				case Array.NESTED:    return loop_D_I_M(result, a, b, axis);
				}
				break;
			case Array.DOUBLE:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_D_D_I(result, a, b);
				case Array.DOUBLE:   return loop_D_D_D(result, a, b);
				case Array.NESTED:    return loop_D_D_M(result, a, b, axis);
				}
				break;
			case Array.NESTED:
				switch(b.type()) {
				case Array.BIT:
				case Array.INTEGER:  return loop_D_M_I(result, a, b, axis);
				case Array.DOUBLE:   return loop_D_M_D(result, a, b, axis);
				case Array.NESTED:    return loop_D_M_M(result, a, b, axis);
				}
				break;
			}
			break;
		case Array.NESTED:
			return loop_M_A_A(result, a, b, axis);
		}
	
		throw new DomainError();
	}
	
	@Override
	public Array niladic()
	{
		throw new ValenceError();
	}

	// primitive monadic functions give the same shape out
	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return a.dims();
	}

	// primitive dyadic functions maintain the shape
	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		if(a.isScalar()) return b.dims();
		if(b.isScalar()) return a.dims();
		checkEqualDimensionsAndRank(a, b);
		return a.dims();
	}
}
