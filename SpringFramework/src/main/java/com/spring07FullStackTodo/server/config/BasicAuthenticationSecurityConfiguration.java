package com.spring07FullStackTodo.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // authenticate all requests
//        http.authorizeHttpRequests(
//                auth -> auth.anyRequest().authenticated()
//        );

        // authenticate pre-flight request requests
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated()
        );

        // basic username & password authentication
        http.httpBasic(Customizer.withDefaults());

        // stateless rest api
        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        // disable cross-site-request-forgery
        http.csrf().disable();

        return  http.build();
    }
}
