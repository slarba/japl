package com.mlt.japl.fns;

import com.mlt.japl.errors.LengthError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.MixedScalar;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.arrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;

public class InnerProdFn extends BaseFn {

    private Func left;
    private Func right;

    public InnerProdFn(Func left, Func right) {
        this.left = left;
        this.right = right;

    }

    @Override
    public IValue applyDyadic(IValue a, IValue b, int axis) {
        if (a.rank() == 0 && b.rank() == 0) return right.applyDyadic(a, b, axis);
        Dimensions resultDims = a.dims().computeInnerProdDims(b.dims());
        if (resultDims.rank() == 0) {
            if (a.length() != b.length()) throw new LengthError();
            IValue result = null;
            for (int i = a.length() - 1; i >= 0; i--) {
                IValue tmp = right.applyDyadic(a.getGeneric(i), b.getGeneric(i), axis);
                if (result == null) {
                    result = tmp;
                } else {
                    result = left.applyDyadic(tmp, result, axis);
                }
            }
            if (a instanceof IMixedArray || b instanceof IMixedArray)
                return new MixedScalar(result);
            else
                return result;
        }
        if (a.dims().lastDim() != b.dims().firstDim()) throw new LengthError();
        int firstSpan = b.dims().spans()[0];
        return new LazyMixedArray(resultDims) {
            @Override
            public IValue get(int index) {
                IValue result = null;
                for (int i = a.dims().firstDim() - 1; i >= 0; i--) {
                    IValue tmp = right.applyDyadic(a.getGeneric(index + i), b.getGeneric(index + i * firstSpan), axis);
                    if (result == null) {
                        result = tmp;
                    } else {
                        result = left.applyDyadic(tmp, result, axis);
                    }
                }
                return result;
            }
        };
    }

    @Override
    public String getName() {
        return "innerprod<" + left.getName() + "," + right.getName() + ">";
    }

}
