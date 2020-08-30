package com.example.hello.cucumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.hello")
public class CucumberAppPlaceholder {
    public static void main(String[] args) {
        SpringApplication.run(CucumberAppPlaceholder.class, args);
    }
}
