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
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.iface.PrimitiveFunc;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;

public abstract class PrimitiveBaseFn implements Func, PrimitiveFunc {
	// intset could be faster
	HashMap<Integer, Integer> resultTypes = new HashMap<Integer,Integer>();
	
	public PrimitiveBaseFn() {
		// check which have been implemented in base class
		try { D_D(0);   resultTypes.put(Array.DOUBLE, Array.DOUBLE); } catch(AplError e) {}
		try { D_I(0);   resultTypes.put(Array.INTEGER, Array.DOUBLE); } catch(AplError e) {}

		try { I_D(0);   resultTypes.put(Array.DOUBLE, Array.INTEGER); } catch(AplError e) {}
		try { I_I(0);   resultTypes.put(Array.INTEGER, Array.INTEGER); } catch(AplError e) {}
		try { I_C(' '); resultTypes.put(Array.CHARACTER, Array.INTEGER); } catch(AplError e) {}

		try { D_DD(0,0);     resultTypes.put(Array.DOUBLE|(Array.DOUBLE<<16), Array.DOUBLE); } catch(AplError e) {}
		try { 
			D_DI(0,0);     
			resultTypes.put(Array.DOUBLE|(Array.INTEGER<<16), Array.DOUBLE); 
			resultTypes.put(Array.DOUBLE|(Array.BIT<<16), Array.DOUBLE);
			} catch(AplError e) {}
		try { D_ID(0,0);     
			resultTypes.put(Array.INTEGER|(Array.DOUBLE<<16), Array.DOUBLE); 
			resultTypes.put(Array.BIT|(Array.DOUBLE<<16), Array.DOUBLE);
			} catch(AplError e) {}
		try { D_II(0,0);     resultTypes.put(Array.INTEGER|(Array.INTEGER<<16), Array.DOUBLE); } catch(AplError e) {}

		try { I_CC(' ',' '); resultTypes.put(Array.CHARACTER|(Array.CHARACTER<<16), Array.INTEGER); } catch(AplError e) {}
		try { I_DD(0,0);     resultTypes.put(Array.DOUBLE|(Array.DOUBLE<<16), Array.INTEGER); } catch(AplError e) {}
		try { I_DI(0,0);     resultTypes.put(Array.DOUBLE|(Array.INTEGER<<16), Array.INTEGER); } catch(AplError e) {}
		try { I_ID(0,0);     resultTypes.put(Array.INTEGER|(Array.DOUBLE<<16), Array.INTEGER); } catch(AplError e) {}
		try {
			I_II(0,0);
			resultTypes.put(Array.INTEGER|(Array.INTEGER<<16), Array.INTEGER); 
			resultTypes.put(Array.INTEGER|(Array.BIT<<16), Array.INTEGER);
			resultTypes.put(Array.BIT|(Array.INTEGER<<16), Array.INTEGER);
			resultTypes.put(Array.BIT|(Array.BIT<<16), Array.INTEGER);
		} catch(AplError e) {}
		try { I_CI(' ',0);   resultTypes.put(Array.CHARACTER|(Array.INTEGER<<16), Array.INTEGER); } catch(AplError e) {}
		try { I_IC(0,' ');   resultTypes.put(Array.INTEGER|(Array.CHARACTER<<16), Array.INTEGER); } catch(AplError e) {}
		try { I_CD(' ',0);   resultTypes.put(Array.CHARACTER|(Array.DOUBLE<<16), Array.INTEGER); } catch(AplError e) {}
		try { I_DC(0,' ');   resultTypes.put(Array.DOUBLE|(Array.CHARACTER<<16), Array.INTEGER); } catch(AplError e) {}
	}

	private Array makeScalarOfType(int type) {
		switch(type) {
		case Array.BIT:
		case Array.INTEGER:   return new IntScalar();
		case Array.DOUBLE:    return new DoubleScalar();
		case Array.CHARACTER: return new CharScalar();
		case Array.NESTED:    return new ArrayScalar();
		default:
			throw new AplError();
		}		
	}

	private Array makeSimilarArrayOfType(int type, Array a) {
		switch(type) {
		case Array.BIT:   		  return new BitArray(a.dims(), true, a.actualLength());
		case Array.INTEGER:		  return new IntArray(a.dims(), true, a.actualLength());
		case Array.DOUBLE:		  return new DoubleArray(a.dims(), true, a.actualLength());
		case Array.CHARACTER:	  return new CharArray(a.dims(), true, a.actualLength());
		case Array.NESTED:		  return new NestedArray(a.dims(), true, a.actualLength());
		default:
			throw new AplError();
		}		
	}
	
	public Array createResultArrayFor(Array a, int axis) {
		if(a.isScalar()) {
			return makeScalarOfType(resultTypeFor(a));
		}
		return makeSimilarArrayOfType(resultTypeFor(a), a);
	}

	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			if(b.isScalar()) {
				return makeScalarOfType(resultTypeFor(a, b));
			}
			return makeSimilarArrayOfType(resultTypeFor(a, b), b);
		}
		if(b.isScalar()) {
			return makeSimilarArrayOfType(resultTypeFor(a, b), a);			
		}
		checkEqualDimensionsAndRank(a, b);
		return makeSimilarArrayOfType(resultTypeFor(a, b), a);			
	}

	public void checkEqualDimensionsAndRank(Array a, Array b) {
		if(a.rank()!=b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		if(a.type()==Array.NESTED || b.type()==Array.NESTED) return Array.NESTED;
		int t = a.type()|(b.type()<<16);
		if(resultTypes.containsKey(t))
			return resultTypes.get(t);
		else
			throw new DomainError();
	}

	@Override
	public int resultTypeFor(Array a) {
		int t = a.type();
		if(t==Array.NESTED) return t;
		if(resultTypes.containsKey(t))
			return resultTypes.get(t);
		else
			throw new DomainError();
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
			case Array.NESTED:   return loop_I_M(result, a, axis);
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
}
