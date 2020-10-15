package com.example.hello;

import org.springframework.stereotype.Component;

@Component
public class ServiceTo3rdParty {
    private static final String RETURN_VALUE = "Value from 3rd party service";

    public String callExternal() {
        return RETURN_VALUE;
    }
}
