package com.example.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests( (auth)->auth
                                .antMatchers("/masaimail/register").permitAll()
				                .antMatchers("/masaimail/getAllUser").authenticated()
                                .antMatchers("/masaimail/login").hasRole("user")

                ).csrf().disable()
                .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
