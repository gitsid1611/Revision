package com.masaiTruckApp.config;

import com.masaiTruckApp.JWT.TokenGenerator;
import com.masaiTruckApp.JWT.TokenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain masaiSecurityFilter(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests( (auth)->auth
                        .requestMatchers("/masaiTruck/register").authenticated()
                        .requestMatchers("/masaiTruck/getAlluser").hasRole("user")
                        .requestMatchers("/masaiTruck/welcome","/masaiTruck/register").permitAll()
                )
                .addFilterBefore(new TokenValidator(), BasicAuthenticationFilter.class)
                .addFilterAfter(new TokenGenerator(), BasicAuthenticationFilter.class)
                .csrf().disable()
                .httpBasic();




        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
