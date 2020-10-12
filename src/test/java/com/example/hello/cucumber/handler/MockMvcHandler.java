package com.example.hello.cucumber.handler;

import com.example.hello.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Component
@Scope("prototype")
public class MockMvcHandler {
    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;

    private String greeting;

    public MockMvcHandler(ObjectMapper objectMapper, WebApplicationContext context) {
        this.objectMapper = objectMapper;
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).alwaysDo(print()).apply(springSecurity()).build();
    }

    public void sayName(String name) throws Exception {
        String payload = objectMapper.writeValueAsString(new Payload(name));

        mockMvc.perform(post("/name").contentType(MediaType.APPLICATION_JSON_UTF8).content(payload))
               .andExpect(status().isOk());
    }

    public void sayHello(String name) throws Exception {
        String response = mockMvc.perform(get("/salute").param("name", name))
                                 .andReturn().getResponse().getContentAsString();
        greeting = JsonPath.parse(response).read("$.message");
    }

    public String returnedGreeting() {
        return greeting;
    }
}
