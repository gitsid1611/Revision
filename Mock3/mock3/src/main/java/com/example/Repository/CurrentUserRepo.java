package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CurrentUserSession;

@Repository
public interface CurrentUserRepo extends JpaRepository<CurrentUserSession, Integer> {

   public Optional<CurrentUserSession>findByuuid(String uuid);
	
	public CurrentUserSession findByUuid(String uuid);
	
}
