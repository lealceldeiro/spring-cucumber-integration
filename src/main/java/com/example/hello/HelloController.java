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
    private final ServiceTo3rdParty serviceTo3rdParty;

    public HelloController(HelloService helloService, ServiceTo3rdParty serviceTo3rdParty) {
        this.helloService = helloService;
        this.serviceTo3rdParty = serviceTo3rdParty;
    }

    @PostMapping("name")
    public void name(@RequestBody Payload payload) {
        helloService.setName(payload.getName());
    }

    @GetMapping("salute")
    public String salute() {
        System.out.println("Calling ServiceTo3rdParty: " + serviceTo3rdParty.callExternal());
        System.out.println("Calling again ServiceTo3rdParty: " + serviceTo3rdParty.callExternal());

        String name = helloService.getName();
        if (name == null) {
            return "There is no one to greet";
        }

        return "Hello, " + name;
    }
}
