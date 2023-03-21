package com.example.service;

import com.example.Exception.MemberException;
import com.example.Exception.TrainerException;
import com.example.Module.Member;
import com.example.Module.Slot;
import com.example.Module.Trainer;

import java.util.List;

public interface MemberService {

    public Member addMember(Member cs) throws MemberException;


    public Slot DeleteSlot(Slot plantId) throws MemberException;






}
