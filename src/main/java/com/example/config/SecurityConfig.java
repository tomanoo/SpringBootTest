package com.example.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] whiteList = {
            "/h2/**",
            "/h2-console/**",
            "/swagger-resources/**",
            "/swagger-ui.html"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers(whiteList).permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin();
    }
}
