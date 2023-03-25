package com.masaiTruckApp.JWT;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import com.masaiTruckApp.Constant.JwtConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TokenGenerator extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication = context.getAuthentication();

        if (authentication != null) {

            Date iatDate = new Date();

            Date expDate = new Date();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(expDate);
            calendar.add(calendar.HOUR, 4);

            SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));

            String jwt = Jwts.builder().setIssuer("/masaiTruck/user/login").setSubject("JWT Token")
                    .claim("firstName", authentication.getName())
                    .claim("authorities", authentication.getAuthorities())
                    .setIssuedAt(iatDate)
                    .setExpiration(calendar.getTime())
                    .signWith(key).compact();



            response.setHeader(JwtConstant.JWT_HEADER, jwt);

            filterChain.doFilter(request, response);
        }
    }
}


