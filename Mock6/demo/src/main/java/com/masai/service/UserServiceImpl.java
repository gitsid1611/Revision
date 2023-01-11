package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dto.UserDto;
import com.masai.Repository.CurrentUserRepo;
import com.masai.Repository.FirRepo;
import com.masai.Repository.UserRepo;
import com.masai.exception.FirException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Fir;
import com.masai.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private CurrentUserRepo currUserSession;
	
	@Autowired
	private FirRepo pl;
	
	@Override
	public User saveUser(User user) throws UserException {
		User existingUserName = userrepo.findByMobileNumber(user.getMobileNumber());

		if (existingUserName != null)
			throw new UserException("Mobile Number already exists " + user.getMobileNumber());

		return userrepo.save(user);
	}

	@Override
	public String loginUser(UserDto use) throws LoginException {
		
		
		User existingUser = userrepo.findByMobileNumber(use.getMobileNumber());
		
		if (existingUser == null)
			throw new LoginException("Invalid credentials. Mobile Number does not exist " + use.getMobileNumber());
	
		java.util.Optional<CurrentUserSession> validCustomerSessionOpt = currUserSession.findById(existingUser.getId());
	
		if (validCustomerSessionOpt.isPresent()) {
	
			throw new LoginException("User already Logged In with this username");
	
		}
	
		if (existingUser.getPassword().equals(use.getPassword())) {
	
			String key = RandomString.make(6);
	
			Boolean isAdmin = true;
	
			CurrentUserSession cs = new CurrentUserSession(existingUser.getId(), key,  LocalDateTime.now());

			currUserSession.save(cs);
	
			return cs.toString();
		} else
			throw new LoginException("Please Enter a valid password");
		
		
		
	}

	@Override
	public Fir addFir(Fir fir, String key) throws LoginException, FirException, UserException {
		
		CurrentUserSession  k = currUserSession.findByUuid(key);
		
		   if(k==null)
		    {
		    	throw new LoginException("You are not Authorized");
		    }
		   else {
			   return pl.save(fir);
		   }
		   
		   
		
	}

	@Override
	public List<Fir> viewAllFir() throws FirException {
		List<Fir> allf = pl.findAll();

		if(allf.isEmpty()) {
			throw new FirException("No Fir In The Detabase");
		}
		else {
			return allf;
		}
	}

}
