package com.example.Repository;

import com.example.Model.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliRepo extends JpaRepository<Police, Integer> {
}
