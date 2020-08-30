package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class HelloApplication {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        LOGGER.info("Starting " + HelloApplication.class.getName());
        SpringApplication.run(HelloApplication.class, args);
    }
}
