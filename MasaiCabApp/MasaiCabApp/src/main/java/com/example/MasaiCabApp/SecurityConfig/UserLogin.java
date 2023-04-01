package com.example.MasaiCabApp.SecurityConfig;

import com.example.MasaiCabApp.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserLogin implements UserDetails {

    @Autowired
    private User usr;


    public UserLogin(User usr) {
        this.usr = usr;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_user");
        authorities.add(role);

        return authorities;
    }

    @Override
    public String getPassword() {
        return usr.getPassword();
    }

    @Override
    public String getUsername() {
        return usr.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}