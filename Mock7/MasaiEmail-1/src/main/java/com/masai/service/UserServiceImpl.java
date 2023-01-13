package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Repository.UserRepo;
import com.masai.model.LoginDto;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo urepo;
	
	
	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub

		if(user==null) 
		{
			throw new UserException("please add valid detaisls");
		}
		
		User use=urepo.findByMobileNumber(user.getMobileNumber());
		
		if(use!=null) {
			throw new UserException("user mismatch user already registered with this mobile..");
		}
		
		urepo.save(user);
		
		return user;
	}

	@Override
	public User loginUser(LoginDto login) throws UserException {
        User user=urepo.findByMobileNumber(login.getMobileNumber()); 
		
		if(user==null) {
			
			throw new UserException("no user found with this mobile..");
		}
		if(user.getPassword().equals(login.getPassword())==false) {
			throw new UserException("wrong password ..");
		}
		
		return user;
	}

	@Override
	public User UpdateUser(User user) throws UserException {
     Optional<User>opt=urepo.findById(user.getUserid());
		
		if(opt.isPresent())
		{
			urepo.save(user);
			
		}
	
	
	else {
        throw new UserException("user with given id is not presesnt........");

	}
		
		return opt.get();
	}

}
