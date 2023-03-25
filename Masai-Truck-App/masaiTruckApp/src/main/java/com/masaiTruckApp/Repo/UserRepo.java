package com.masaiTruckApp.Repo;

import com.masaiTruckApp.Module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

    public User findByFirstName(String firstName);
}
