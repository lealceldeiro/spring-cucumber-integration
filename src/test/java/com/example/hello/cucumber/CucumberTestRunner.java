package com.example.hello.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CAMELCASE,
        features = "classpath:cucumber",
        plugin = {
                "pretty"
        }
)
@ActiveProfiles("test")
public class CucumberTestRunner {
}
