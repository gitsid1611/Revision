package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo cus;
	
	
	@Override
	public User addUser(User user) throws UserException {
		// TODO Auto-generated method stub
	    User existing = cus.findByPhoneNo(user.getPhoneNo());
	    
	    if(existing!=null)
	    
	    	throw new UserException("phoneno already exists");
	    else
	    return cus.save(user);
	}

	@Override
	public User deleteUser(User id) throws UserException {
		// TODO Auto-generated method stub
      Optional<User> found = cus.findById(id.getId());
		
		
		if(found.isPresent()) {
			cus.delete(id);
			
			
		}
		else {
			throw new UserException("Cant delete this because no such user is present here");
		}
		
		return found.get();
	}

	@Override
	public User viemUser(Integer id) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> exis = cus.findById(id);

		if(exis.isEmpty()) {
			throw new UserException("Id Was In-Correct");
		}
		else {
			return exis.get() ;

		}
	}

	@Override
	public List<User> viewAllUser() throws UserException {
		// TODO Auto-generated method stub
		List<User> alluse = cus.findAll();

		if(alluse.isEmpty()) {
			throw new UserException("No user In The Detabase");
		}
		else {
			return alluse;
		}
	}

}
