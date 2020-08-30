package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping("name")
    public void name(@RequestBody Payload payload) {
        helloService.setName(payload.getName());
    }

    @GetMapping("salute")
    public String salute() {
        String name = helloService.getName();
        if (name == null) {
            return "There is no one to greet";
        }

        return "Hello, " + name;
    }
}
