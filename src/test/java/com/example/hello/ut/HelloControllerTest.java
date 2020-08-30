package com.example.hello.ut;

import com.example.hello.HelloApplication;
import com.example.hello.HelloService;
import com.example.hello.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.SecureRandom;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class HelloControllerTest {
    @MockBean
    HelloService helloService;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    private String expectedName;

    @Before
    public void setUp() {
        expectedName = "SomeName-" + new SecureRandom().nextInt(111);
        when(helloService.getName()).thenReturn(expectedName);

        mockMvc = MockMvcBuilders.webAppContextSetup(context).alwaysDo(MockMvcResultHandlers.print()).build();
    }

    @Test
    public void salute() throws Exception {
        mockMvc
                .perform(post("/name")
                                 .contentType(MediaType.APPLICATION_JSON_UTF8)
                                 .content(objectMapper.writeValueAsString(new Payload(expectedName))))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(helloService, times(1)).setName(expectedName);
    }

    @Test
    public void hello() throws Exception {
        String response = mockMvc
                .perform(get("/salute").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        verify(helloService, times(1)).getName();
        Assert.assertEquals("Hello, " + expectedName, response);
    }
}