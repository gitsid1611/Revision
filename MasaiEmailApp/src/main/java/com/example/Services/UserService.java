package com.example.Services;

import com.example.Exception.UserException;
import com.example.Module.User;

public interface UserService {

    public User registerUser(User user)throws UserException;



    public User UpdateUser(User user) throws UserException;

}
