package com.mlt.japl.newast;

/**
 * Created by markolau on 11/10/15.
 */
public class JumpSignal extends AplSignal {
    private final int line;

    public JumpSignal(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }
}
