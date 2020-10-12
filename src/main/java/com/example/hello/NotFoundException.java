package com.example.hello;

class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7839872909036678944L;

    NotFoundException(String message) {
        super(message);
    }
}
