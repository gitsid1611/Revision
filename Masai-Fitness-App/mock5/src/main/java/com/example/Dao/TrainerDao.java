package com.example.Dao;

import com.example.Module.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerDao extends JpaRepository<Trainer, Integer> {

    public Trainer findByName(String name);

}
