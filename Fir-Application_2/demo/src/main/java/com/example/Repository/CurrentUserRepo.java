package com.example.Repository;

import com.example.Model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentUserRepo extends JpaRepository<CurrentUserSession, Integer> {



    public CurrentUserSession findByUuid(String uuid);

}
