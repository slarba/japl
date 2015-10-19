package com.mlt.japl.fns;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.MixedArray;
import com.mlt.japl.arrays.generated.*;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;

public class TakeFn extends BaseFn {

    public TakeFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        int maxlen = 0;
        for(int i=0; i<a.length(); i++) {
            maxlen = Math.max(a.get(i).length(), maxlen);
        }
        int ml = maxlen;
        Dimensions resultDims = new Dimensions(a.length(), maxlen);
        return new LazyMixedArray(resultDims) {
            @Override
            public IValue get(int index) {
                int row = index/ml;
                IValue v = a.get(row);
                int col = index%ml;
                if(col>=v.length()) return v.getGeneric(0).prototype();
                return v.getGeneric(col);
            }
        }.force();
    }

    private int[] createDimensions(IIntArray a, IValue b) {
        if (a.length() != b.rank()) throw new RankError();
        int[] ds = new int[a.length()];
        for (int i = 0; i < ds.length; i++) ds[i] = (int) Math.abs(a.get(i));
        return ds;
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        int[] ds = createDimensions(a, b);
        return new LazyIntArray(new Dimensions(ds)) {
            @Override
            public long get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    long ai = a.get(i);
                    if (ai < 0) {
                        long ix = Math.abs(b.dims().axis(i) + ai);
                        if (idx[i] < ix) return 0;
                        idx[i] -= ix;
                    } else if (idx[i] >= b.dims().axis(i)) return 0;
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        int[] ds = createDimensions(a, b);
        return new LazyBitArray(new Dimensions(ds)) {
            @Override
            public long get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    long ai = a.get(i);
                    if (ai < 0) {
                        long ix = Math.abs(b.dims().axis(i) + ai);
                        if (idx[i] < ix) return 0;
                        idx[i] -= ix;
                    } else if (idx[i] >= b.dims().axis(i)) return 0;
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        int[] ds = createDimensions(a, b);
        return new LazyDoubleArray(new Dimensions(ds)) {
            @Override
            public double get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    long ai = a.get(i);
                    if (ai < 0) {
                        long ix = Math.abs(b.dims().axis(i) + ai);
                        if (idx[i] < ix) return 0;
                        idx[i] -= ix;
                    } else if (idx[i] >= b.dims().axis(i)) return 0;
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharArray b) {
        int[] ds = createDimensions(a, b);
        return new LazyCharArray(new Dimensions(ds)) {
            @Override
            public char get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    long ai = a.get(i);
                    if (ai < 0) {
                        long ix = Math.abs(b.dims().axis(i) + ai);
                        if (idx[i] < ix) return ' ';
                        idx[i] -= ix;
                    } else if (idx[i] >= b.dims().axis(i)) return ' ';
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedArray b) {
        int[] ds = createDimensions(a, b);
        return new LazyMixedArray(new Dimensions(ds)) {
            @Override
            public IValue get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    long ai = a.get(i);
                    if (ai < 0) {
                        long ix = Math.abs(b.dims().axis(i) + ai);
                        if (idx[i] < ix) return MixedArray.EMPTY;
                        idx[i] -= ix;
                    } else if (idx[i] >= b.dims().axis(i)) return MixedArray.EMPTY;
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        if (axis < 0) {
            if (b.rank() != 1) throw new RankError();
            return new LazyIntArray(new Dimensions((int) Math.abs(a.get()))) {
                @Override
                public long get(int index) {
                    long ai = a.get();
                    if (ai < 0) {
                        long ix = Math.abs(b.length() + ai);
                        if (index < ix) return 0;
                        index -= ix;
                    } else if (index >= b.length()) return 0;
                    return b.get(index);
                }
            };
        }
        if (axis >= b.rank()) throw new AxisError();

        int[] ds = new int[b.rank()];
        for (int i = 0; i < ds.length; i++) {
            if (i == axis) ds[i] = (int) Math.abs(a.get());
            else ds[i] = b.dims().axis(i);
        }
        return new LazyIntArray(new Dimensions(ds)) {
            @Override
            public long get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    if (i == axis) {
                        long ai = a.get();
                        if (ai < 0) {
                            long ix = Math.abs(b.dims().axis(i) + ai);
                            if (idx[i] < ix) return 0;
                            idx[i] -= ix;
                        } else if (idx[i] >= b.dims().axis(i)) return 0;
                    }
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b) {
        if (axis < 0) {
            if (b.rank() != 1) throw new RankError();
            return new LazyCharArray(new Dimensions((int) Math.abs(a.get()))) {
                @Override
                public char get(int index) {
                    long ai = a.get();
                    if (ai < 0) {
                        long ix = Math.abs(b.length() + ai);
                        if (index < ix) return ' ';
                        index -= ix;
                    } else if (index >= b.length()) return ' ';
                    return b.get(index);
                }
            };
        }
        if (axis >= b.rank()) throw new AxisError();

        int[] ds = new int[b.rank()];
        for (int i = 0; i < ds.length; i++) {
            if (i == axis) ds[i] = (int) Math.abs(a.get());
            else ds[i] = b.dims().axis(i);
        }
        return new LazyCharArray(new Dimensions(ds)) {
            @Override
            public char get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    if (i == axis) {
                        long ai = a.get();
                        if (ai < 0) {
                            long ix = Math.abs(b.dims().axis(i) + ai);
                            if (idx[i] < ix) return ' ';
                            idx[i] -= ix;
                        } else if (idx[i] >= b.dims().axis(i)) return ' ';
                    }
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        if (axis < 0) {
            if (b.rank() != 1) throw new RankError();
            return new LazyDoubleArray(new Dimensions((int) Math.abs(a.get()))) {
                @Override
                public double get(int index) {
                    long ai = a.get();
                    if (ai < 0) {
                        long ix = Math.abs(b.length() + ai);
                        if (index < ix) return 0;
                        index -= ix;
                    } else if (index >= b.length()) return 0;
                    return b.get(index);
                }
            };
        }
        if (axis >= b.rank()) throw new AxisError();

        int[] ds = new int[b.rank()];
        for (int i = 0; i < ds.length; i++) {
            if (i == axis) ds[i] = (int) Math.abs(a.get());
            else ds[i] = b.dims().axis(i);
        }
        return new LazyDoubleArray(new Dimensions(ds)) {
            @Override
            public double get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    if (i == axis) {
                        long ai = a.get();
                        if (ai < 0) {
                            long ix = Math.abs(b.dims().axis(i) + ai);
                            if (idx[i] < ix) return 0;
                            idx[i] -= ix;
                        } else if (idx[i] >= b.dims().axis(i)) return 0;
                    }
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IMixedArray b) {
        if (axis < 0) {
            if (b.rank() != 1) throw new RankError();
            return new LazyMixedArray(new Dimensions((int) Math.abs(a.get()))) {
                @Override
                public IValue get(int index) {
                    long ai = a.get();
                    if (ai < 0) {
                        long ix = Math.abs(b.length() + ai);
                        if (index < ix) return b.prototype();
                        index -= ix;
                    } else if (index >= b.length()) return b.prototype();
                    return b.get(index);
                }
            };
        }
        if (axis >= b.rank()) throw new AxisError();

        int[] ds = new int[b.rank()];
        for (int i = 0; i < ds.length; i++) {
            if (i == axis) ds[i] = (int) Math.abs(a.get());
            else ds[i] = b.dims().axis(i);
        }
        return new LazyMixedArray(new Dimensions(ds)) {
            @Override
            public IValue get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    if (i == axis) {
                        long ai = a.get();
                        if (ai < 0) {
                            long ix = Math.abs(b.dims().axis(i) + ai);
                            if (idx[i] < ix) return b.prototype();
                            idx[i] -= ix;
                        } else if (idx[i] >= b.dims().axis(i)) return b.prototype();
                    }
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        if (axis < 0) {
            if (b.rank() != 1) throw new RankError();
            return new LazyBitArray(new Dimensions((int) Math.abs(a.get()))) {
                @Override
                public long get(int index) {
                    long ai = a.get();
                    if (ai < 0) {
                        long ix = Math.abs(b.length() + ai);
                        if (index < ix) return 0;
                        index -= ix;
                    } else if (index >= b.length()) return 0;
                    return b.get(index);
                }
            };
        }
        if (axis >= b.rank()) throw new AxisError();

        int[] ds = new int[b.rank()];
        for (int i = 0; i < ds.length; i++) {
            if (i == axis) ds[i] = (int) Math.abs(a.get());
            else ds[i] = b.dims().axis(i);
        }
        return new LazyBitArray(new Dimensions(ds)) {
            @Override
            public long get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    if (i == axis) {
                        long ai = a.get();
                        if (ai < 0) {
                            long ix = Math.abs(b.dims().axis(i) + ai);
                            if (idx[i] < ix) return 0;
                            idx[i] -= ix;
                        } else if (idx[i] >= b.dims().axis(i)) return 0;
                    }
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };

    }

    @Override
    public String getName() {
        return "take";
    }

}
