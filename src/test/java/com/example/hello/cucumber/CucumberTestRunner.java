package com.example.hello.cucumber;

import com.example.hello.StaticUtility;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.ActiveProfiles;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

// Run with PowerMock for demonstrative purposes only! Consider using `@RunWith(Cucumber.class)` instead.
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Cucumber.class)
@PowerMockIgnore("javax.management.*")
@PrepareForTest({StaticUtility.class})
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
