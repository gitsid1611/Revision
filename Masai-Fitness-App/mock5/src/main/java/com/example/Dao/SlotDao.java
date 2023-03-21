package com.example.Dao;

import com.example.Module.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotDao extends JpaRepository<Slot,Integer> {
}
