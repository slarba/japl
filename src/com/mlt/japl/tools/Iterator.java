package com.mlt.japl.tools;

public interface Iterator {
    boolean isFinished();

    int step();

    int index();

    int axis(int axis);

    void reset();

    int[] iter();
}
