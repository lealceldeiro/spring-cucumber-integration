package com.example.hello;

import org.springframework.stereotype.Component;

@Component
public class ServiceTo3rdParty {
    public String callExternal() {
        return "Value from 3rd party service";
    }
}
