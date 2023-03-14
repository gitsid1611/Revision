package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.event;

@Repository
public interface EventRepo extends JpaRepository<event, Integer> {

}
