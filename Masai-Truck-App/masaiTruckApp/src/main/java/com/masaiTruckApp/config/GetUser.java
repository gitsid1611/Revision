package com.masaiTruckApp.config;

import com.masaiTruckApp.Module.User;
import com.masaiTruckApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetUser {

    @Autowired
    private UserRepo usr;

    public User getLoggedInUserDetails() {


        SecurityContext sc = SecurityContextHolder.getContext();


        Authentication auth=sc.getAuthentication();

        return usr.findByFirstName(auth.getName());
    }
}
