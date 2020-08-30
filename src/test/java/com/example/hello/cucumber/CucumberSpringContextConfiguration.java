package com.example.hello.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @see <a href="https://github.com/cucumber/cucumber-jvm/tree/main/examples/spring-txn">Cucumber JVM - Spring</a>
 */
@CucumberContextConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = CucumberAppPlaceholder.class)
public class CucumberSpringContextConfiguration {
}
