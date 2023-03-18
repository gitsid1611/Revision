package com.example.Repository;

import com.example.Model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentSessionRepo extends JpaRepository<CurrentUserSession, Integer> {

    public CurrentUserSession findByUuid(String uuid);
}
