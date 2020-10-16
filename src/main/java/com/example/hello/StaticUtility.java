package com.example.hello;

public final class StaticUtility {
    private static final String STATIC_VALUE = "Static value";

    private StaticUtility() {
    }

    public static String staticMethod() {
        return STATIC_VALUE;
    }
}
