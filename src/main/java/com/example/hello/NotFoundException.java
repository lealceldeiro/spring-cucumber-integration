package com.example.hello;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Entity Not found: " + message);
    }
}
