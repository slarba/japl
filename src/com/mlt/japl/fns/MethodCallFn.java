package com.mlt.japl.fns;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.ObjectScalar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodCallFn extends BaseFn {
    private String method;

    public MethodCallFn(String method) {
        this.method = method;
    }

    @Override
    public IValue applyMonadic(IValue a) {
        if (!(a instanceof ObjectScalar)) throw new ValueError();
        ObjectScalar obj = (ObjectScalar) a;
        Object o = obj.coerceToJavaObject();

        try {
            Method m = o.getClass().getMethod(method);
            return new ObjectScalar(m.invoke(o));
        } catch (NoSuchMethodException | SecurityException e) {
            throw new ValueError();
        } catch (IllegalAccessException e) {
            throw new ValueError();
        } catch (IllegalArgumentException e) {
            throw new ValueError();
        } catch (InvocationTargetException e) {
            throw new ValueError();
        }
    }

    @Override
    public String getName() {
        return "methodcall<" + method + ">";
    }
}
