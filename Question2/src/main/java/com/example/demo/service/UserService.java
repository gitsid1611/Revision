package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;



public interface UserService {

	public User addUser(User customer) throws UserException;
	
	public User deleteUser(User id) throws UserException;
	
	public User viemUser(Integer id) throws UserException;
	
	public List<User> viewAllUser() throws UserException;
	
}
