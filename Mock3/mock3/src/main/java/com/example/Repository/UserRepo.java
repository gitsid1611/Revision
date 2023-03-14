package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
}
