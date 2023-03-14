package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.CurrentUserRepo;
import com.example.Repository.UserRepo;
import com.example.dto.UserDto;
import com.example.exception.LoginException;
import com.example.exception.UserException;
import com.example.model.CurrentUserSession;
import com.example.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private CurrentUserRepo currUserSession;
	
	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		if(user==null) 
		{
			throw new UserException("please add valid detaisls");
		}
		
		User use = urepo.findByEmail(user.getEmail());
		
		if(use!=null) {
			throw new UserException("user mismatch user already registered with this email");
		}
		
		urepo.save(user);
		
		return user;
	}

	@Override
	public String loginUser(UserDto login) throws UserException, LoginException {
		
		User existingUser = urepo.findByEmail(login.getEmail());
		
		if (existingUser == null)
			throw new LoginException("Invalid credentials. Email does not exist " + login.getEmail());
	
		java.util.Optional<CurrentUserSession> validCustomerSessionOpt = currUserSession.findById(existingUser.getId());
	
		if (validCustomerSessionOpt.isPresent()) {
	
			throw new LoginException("User already Logged In with this email");
	
		}
	
		if (existingUser.getPassword().equals(login.getPassword())) {
	
			String key = RandomString.make(6);
	
			
	
			CurrentUserSession cs = new CurrentUserSession(existingUser.getId(), key, LocalDateTime.now());

			currUserSession.save(cs);
	
			return cs.toString();
		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public User UpdateUser(User user) throws UserException {
		
		
	Optional<User> opt= urepo.findById(user.getId());
			
			if(opt.isPresent())
			{
				urepo.save(user);
				
			}
		
		
		else {
	        throw new UserException("User with given id is not presesnt........");
	
		}
			
			return opt.get();
		}

}
