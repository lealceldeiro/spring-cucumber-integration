package com.example.hello.cucumber;

import com.example.hello.ServiceTo3rdParty;
import com.example.hello.cucumber.handler.MockMvcHandler;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;

public class GreetingStepsDefinition {
    private final MockMvcHandler mockMvcHandler;
    private ServiceTo3rdParty serviceTo3rdPartyMock;

    public GreetingStepsDefinition(MockMvcHandler mockMvcHandler, ServiceTo3rdParty serviceTo3rdPartyMock) {
        this.mockMvcHandler = mockMvcHandler;
        this.serviceTo3rdPartyMock = serviceTo3rdPartyMock;
    }

    @Before
    public void setUp() {
        Mockito.when(serviceTo3rdPartyMock.callExternal()).thenReturn("Mocked value");
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
