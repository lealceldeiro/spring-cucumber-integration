package com.example.hello.ut;

import com.example.hello.HelloApplication;
import com.example.hello.HelloService;
import com.example.hello.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.SecureRandom;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    private String expectedGreeting;

    @Before
    public void setUp() {
        expectedName = "SomeName-" + new SecureRandom().nextInt(111);
        expectedGreeting = "Hello, " + expectedName;
        when(helloService.salute(anyString())).thenReturn(expectedGreeting);

        mockMvc = MockMvcBuilders.webAppContextSetup(context).alwaysDo(MockMvcResultHandlers.print()).build();
    }

    @Test
    public void salute() throws Exception {
        mockMvc.perform(post("/name")
                            .contentType(APPLICATION_JSON_UTF8)
                            .content(objectMapper.writeValueAsString(new Payload(expectedName))))
               .andExpect(status().isOk());

        verify(helloService, times(1)).nameIt(expectedName);
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/salute").contentType(APPLICATION_JSON_UTF8)
                                      .param("name", expectedGreeting))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.message", Is.is(expectedGreeting)))
               .andReturn()
               .getResponse();


        verify(helloService, times(1)).salute(anyString());
    }
}
