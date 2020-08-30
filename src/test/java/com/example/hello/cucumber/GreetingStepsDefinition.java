package com.example.hello.cucumber;

import com.example.hello.cucumber.handler.MockMvcHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GreetingStepsDefinition {
    private final MockMvcHandler mockMvcHandler;

    public GreetingStepsDefinition(MockMvcHandler mockMvcHandler) {
        this.mockMvcHandler = mockMvcHandler;
    }

    @Given("{string} is to be greeted")
    public void aNameIsToBeGreeted(String name) throws Exception {
        mockMvcHandler.sayName(name);
    }

    @When("There is a greeting")
    public void thereIsAGreeting() throws Exception {
        mockMvcHandler.sayHello();
    }

    @Then("{string} should be said")
    public void aGreetingShouldBeSaid(String expectedGreeting) {
        Assert.assertEquals(expectedGreeting, mockMvcHandler.returnedGreeting());
    }

    @Given("There is no one to be greeted")
    public void thereIsNoOneToBeGreeted() throws Exception {
        mockMvcHandler.sayName(null);
    }
}
