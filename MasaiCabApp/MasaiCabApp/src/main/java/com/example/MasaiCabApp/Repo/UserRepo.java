package com.example.MasaiCabApp.Repo;

import com.example.MasaiCabApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    public Optional<User> findByUsername(String firstName);

    public User findByMobileNumber(String mobile);
}
