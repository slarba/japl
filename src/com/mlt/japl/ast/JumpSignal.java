package com.mlt.japl.ast;

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
