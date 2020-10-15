package com.example.hello.ut;

import com.example.hello.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.SecureRandom;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    public void setAndGetName() {
        final String expected = "Name-" + new SecureRandom().nextInt(137);
        helloService.nameIt(expected);

        assertEquals("Hey, " + expected, helloService.salute(expected));
    }
}
