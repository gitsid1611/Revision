package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MemberSecurityConfig {

    @Bean
    public SecurityFilterChain masaiSecurityFilter(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests( (auth)->auth
                        .requestMatchers("/masaifitness/register").authenticated()
                        .requestMatchers("/masaifitness/login").hasRole("admin")
                        .requestMatchers("/masaifitness/login","/masaifitness/register").permitAll()
                )
              ;




        return http.build();
    }




}
