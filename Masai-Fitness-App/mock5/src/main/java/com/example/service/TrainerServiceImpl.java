package com.example.service;

import com.example.Dao.TrainerDao;
import com.example.Exception.MemberException;
import com.example.Exception.TrainerException;
import com.example.Module.Member;
import com.example.Module.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerDao pl;

    @Override
    public Trainer addTrainer(Trainer cs) throws TrainerException {
        Trainer mod = pl.save(cs);

        if(mod!=null)
        {
            return mod;
        }
        else {
            throw new TrainerException("Input is Not Correct");
        }
    }

    @Override
    public Trainer viewMember(Integer t_id) throws TrainerException {
        Optional<Trainer> id = pl.findById(t_id);

        if(id.isEmpty()) {
            throw new TrainerException("Id Was In-Correct");
        }
        else {
            return id.get() ;

        }
    }

    @Override
    public List<Trainer> viewAllTrainer() throws TrainerException {
        List<Trainer> allcus = pl.findAll();

        if(allcus.isEmpty()) {
            throw new TrainerException("No Trainer In The Detabase");
        }
        else {
            return allcus;
        }
    }

    @Override
    public Trainer updateTrainer(Trainer vs) throws TrainerException {
        Optional<Trainer> opt=pl.findById(vs.getId());

        if(opt.isPresent())
        {
            pl.save(vs);

        }


        else {
            throw new TrainerException("Trainer with given id is not presesnt........");

        }

        return opt.get();
    }
}
