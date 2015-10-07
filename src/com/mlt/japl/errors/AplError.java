package com.mlt.japl.errors;

public class AplError extends RuntimeException {

    public AplError() {
        super("APL ERROR (bug)");
    }

    public AplError(String msg) {
        super(msg);
    }
}
