package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;

public interface CurrentUserRepo extends JpaRepository<CurrentUserSession, Integer> {
	
    public Optional<CurrentUserSession>findByuuid(String uuid);
	
	public CurrentUserSession findByUuid(String uuid);

}
