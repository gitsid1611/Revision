package com.masaiTruckApp.JWT;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import com.masaiTruckApp.Constant.JwtConstant;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenValidator extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {



        String jwt = request.getHeader(JwtConstant.JWT_HEADER);

        if (null != jwt) {
            try {

                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));


                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();


                String firstName = String.valueOf(claims.get("firstName"));

                String autorities= String.valueOf( claims.get("authorities"));

                String[] at=autorities.split("[{[=}]]");

                SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(at[2]);

                List<GrantedAuthority> authorities=new ArrayList<>();

                authorities.add(simpleGrantedAuthority);

                Authentication auth = new UsernamePasswordAuthenticationToken(firstName,null,authorities);

                SecurityContextHolder.getContext().setAuthentication(auth);

            }
            catch (Exception e) {
                throw new UsernameNotFoundException("Invalid Token received!");
            }

        }
        filterChain.doFilter(request, response);
    }
}
