package com.example.MasaiCabApp.Service;

import com.example.MasaiCabApp.Exception.UserException;
import com.example.MasaiCabApp.Model.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user)throws UserException;


    public List<User> viewAllUser() throws UserException;


    public User updateUser(User user) throws UserException;

}
