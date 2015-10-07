package com.mlt.japl.newfns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newarrays.concrete.ObjectScalar;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class NewFn extends BaseFn {
	@Override
	public IValue visit_monadic(ICharArray a, int axis) {
		CharArray c = (CharArray)a.force();
		try {
			Class<?> clas = Class.forName(c.getString());
			return new ObjectScalar(clas.newInstance());
		} catch (ClassNotFoundException e) {
			throw new ValueError();
		} catch (InstantiationException e) {
			throw new ValueError();
		} catch (IllegalAccessException e) {
			throw new ValueError();
		}
	}

	Class<?>[] buildParameterTypes(MixedArray a) {
		Class<?>[] ps = new Class<?>[a.length()-1];
		for(int i=1; i<a.length(); i++) {
			IValue v = a.get(i);
			ps[i-1] = v.getCorrespondingJavaClass();
		}
		return ps;
	}
	
	Object[] buildParameters(MixedArray a) {
		Object[] ps = new Object[a.length()-1];
		for(int i=1; i<a.length(); i++) {
			IValue v = a.get(i);
			ps[i-1] = v.coerceToJavaObject();
		}
		return ps;
	}
	
	@Override
	public String getName() {
		return "NEW";
	}
	
	@Override
	public IValue visit_monadic(IMixedArray as, int axis) {
		MixedArray a = (MixedArray)as.force();
		if(a.length()<1) throw new LengthError();
		IValue className = a.get(0);
		if(!(className instanceof ICharArray)) throw new DomainError();
		CharArray c = (CharArray)className.force();
		try {
			Class<?> clas = Class.forName(c.getString());
			Class<?>[] parameterTypes = buildParameterTypes(a);
			Constructor<?> ctor = clas.getDeclaredConstructor(parameterTypes);
			return new ObjectScalar(ctor.newInstance(buildParameters(a)));
		} catch (ClassNotFoundException e) {
			throw new ValueError();
		} catch (InstantiationException e) {
			throw new ValueError();
		} catch (IllegalAccessException e) {
			throw new ValueError();
		} catch (NoSuchMethodException e) {
			throw new ValueError();
		} catch (SecurityException e) {
			throw new ValueError();
		} catch (IllegalArgumentException e) {
			throw new ValueError();
		} catch (InvocationTargetException e) {
			throw new ValueError();
		}
	}

}
