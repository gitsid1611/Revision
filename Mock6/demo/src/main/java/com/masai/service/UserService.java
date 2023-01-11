package com.masai.service;

import java.util.List;

import com.masai.Dto.UserDto;
import com.masai.exception.FirException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Fir;
import com.masai.model.User;

public interface UserService {

	public User saveUser(User user) throws UserException;
	
	public String loginUser(UserDto use) throws LoginException;
	
	public  Fir addFir(Fir fir,String key) throws LoginException, FirException, UserException;
	
	public List<Fir> viewAllFir() throws FirException;
}
