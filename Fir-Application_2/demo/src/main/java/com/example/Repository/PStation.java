package com.example.Repository;

import com.example.Model.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PStation extends JpaRepository<PoliceStation, Integer> {
}
