package com.mlt.japl.fns;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.*;
import com.mlt.japl.arrays.generated.*;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;

public class RavelFn extends BaseFn {
    private boolean firstAxis;

    public RavelFn(boolean firstAxis) {
        this.firstAxis = firstAxis;
    }

    @Override
    public IValue applyMonadic(IValue a, int axis) {
        if (a instanceof IScalar) {
            return a.reshape(new int[]{1});
        }
        return a.reshape(new int[]{a.length()});
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
        return new IntArray(new Dimensions(2), new long[]{a.get(), b.get()});
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
        return new DoubleArray(new Dimensions(2), new double[]{a.get(), b.get()});
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b, int axis) {
        return new CharArray(new Dimensions(2), new char[]{a.get(), b.get()});
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IMixedScalar b, int axis) {
        return new MixedArray(new Dimensions(2), new IValue[]{a.get(), b.get()});
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        if (b.rank() != 1) throw new RankError();
        return new LazyIntArray(new Dimensions(1 + b.length())) {
            @Override
            public long get(int index) {
                return index == 0 ? a.get() : b.get(index - 1);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
        if (b.rank() != 1) throw new RankError();
        return new LazyDoubleArray(new Dimensions(1 + b.length())) {
            @Override
            public double get(int index) {
                return index == 0 ? a.get() : b.get(index - 1);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b, int axis) {
        if (b.rank() != 1) throw new RankError();
        return new LazyMixedArray(new Dimensions(1 + b.length())) {
            @Override
            public IValue get(int index) {
                return index == 0 ? a : new CharScalar(b.get(index - 1));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IMixedArray b, int axis) {
        if (b.rank() != 1) throw new RankError();
        return new LazyMixedArray(new Dimensions(1 + b.length())) {
            @Override
            public IValue get(int index) {
                return index == 0 ? a : b.get(index - 1);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyIntArray(result) {
            @Override
            public long get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyIntArray(result) {
            @Override
            public long get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyIntArray(result) {
            @Override
            public long get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyBitArray(result) {
            @Override
            public long get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyDoubleArray(result) {
            @Override
            public double get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyDoubleArray(result) {
            @Override
            public double get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyDoubleArray(result) {
            @Override
            public double get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyCharArray(result) {
            @Override
            public char get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharScalar b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(new Dimensions(1), axis);
        return new LazyCharArray(result) {
            @Override
            public char get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get();
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(new Dimensions(1), axis);
        return new LazyIntArray(result) {
            @Override
            public long get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get();
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedArray b, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis > a.rank()) throw new AxisError();
        Dimensions result = a.dims().laminate(b.dims(), axis);
        return new LazyMixedArray(result) {
            @Override
            public IValue get(int index) {
                int[] ri = result.reverseIndexInt(index);
                if (ri[axis] >= a.dims().axis(axis)) {
                    return b.get(b.dims().indexWithReplacedAxis(axis, ri[axis] - a.dims().axis(axis), ri));
                } else
                    return a.get(a.dims().calculateIndex(ri));
            }
        };
    }

    @Override
    public String getName() {
        return "ravel";
    }

}
