package com.example.util;

import com.example.Dao.MemberDao;
import com.example.Dao.TrainerDao;
import com.example.Module.Member;
import com.example.Module.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoggedIn {

    @Autowired
    private MemberDao mem;


    @Autowired
    private TrainerDao tem;


    public Member getLoggedInMemberDetails() {


        SecurityContext sc = SecurityContextHolder.getContext();


        Authentication auth=sc.getAuthentication();

        return mem.findByMobileNumber(auth.getName());
    }



    public Trainer getLoggedInTrainerDetails() {


        SecurityContext sc = SecurityContextHolder.getContext();


        Authentication auth=sc.getAuthentication();

        return tem.findByName(auth.getName());
    }






}
