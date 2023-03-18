package com.example.Repository;

import com.example.Model.Fir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirRepo extends JpaRepository<Fir, Integer> {
}
