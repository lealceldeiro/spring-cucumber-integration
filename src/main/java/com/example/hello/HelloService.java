package com.example.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private final HelloEntityRepository repository;

    public HelloService(HelloEntityRepository repository) {
        this.repository = repository;
    }

    public HelloEntity nameIt(String name) {
        return repository.save(new HelloEntity(name));
    }

    public String salute(String name) {
        String nameFound = repository.findByNameEquals(name)
                                     .orElseThrow(() -> new NotFoundException("There is no name " + name))
                                     .getName();

        return "Hey, " + nameFound;
    }
}
