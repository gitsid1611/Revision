package com.example.Repository;

import com.example.Exception.UserException;
import com.example.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


    public User findByFirstname(String username)throws UserException;

    public User findByMoblienumber(String string);



}
