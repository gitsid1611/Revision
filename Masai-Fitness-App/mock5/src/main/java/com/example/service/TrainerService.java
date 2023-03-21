package com.example.service;

import com.example.Exception.MemberException;
import com.example.Exception.TrainerException;
import com.example.Module.Member;
import com.example.Module.Trainer;

import java.util.List;

public interface TrainerService {

    public Trainer addTrainer(Trainer cs) throws TrainerException;



    public Trainer viewMember(Integer t_id) throws TrainerException;

    public List<Trainer> viewAllTrainer() throws TrainerException;


    public Trainer updateTrainer(Trainer train) throws TrainerException;
}
