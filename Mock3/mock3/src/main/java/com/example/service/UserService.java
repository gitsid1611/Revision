package com.example.service;

import com.example.dto.UserDto;
import com.example.exception.LoginException;
import com.example.exception.UserException;
import com.example.model.User;

public interface UserService {

	public User registerUser(User user)throws UserException;
	
	public String loginUser(UserDto login)throws UserException, LoginException;
	
	public User UpdateUser(User user) throws UserException;
	
}
