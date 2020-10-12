package com.example.hello;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class HelloController {
    private final Logger logger = Logger.getAnonymousLogger();

    private final HelloService helloService;
    private final ServiceTo3rdParty serviceTo3rdParty;

    public HelloController(HelloService helloService, ServiceTo3rdParty serviceTo3rdParty) {
        this.helloService = helloService;
        this.serviceTo3rdParty = serviceTo3rdParty;
    }

    @PostMapping("name")
    public void name(@RequestBody Payload payload) {
        helloService.nameIt(payload.getName());
    }

    @GetMapping("salute")
    public ResponseEntity<Map<String, String>> salute(@Param("name") String name) {
        logger.log(Level.INFO, "Calling ServiceTo3rdParty: {0}", serviceTo3rdParty.callExternal());
        logger.log(Level.INFO, "Calling again ServiceTo3rdParty: {0}", serviceTo3rdParty.callExternal());

        Map<String, String> response = new HashMap<>();
        response.put("message", helloService.salute(name));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
