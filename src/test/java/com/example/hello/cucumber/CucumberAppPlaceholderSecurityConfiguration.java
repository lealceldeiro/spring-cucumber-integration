package com.example.hello.cucumber;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Order 101 to avoid exception {@code Injection of autowired dependencies failed; nested exception is
 * java.lang.IllegalStateException: @Order on WebSecurityConfigurers must be unique. Order of 100 was already used on
 * com.example.hello.cucumber.CucumberTestSecurityConfiguration}
 */
@Order(101)
@Configuration
@EnableWebSecurity
public class CucumberAppPlaceholderSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }
}
