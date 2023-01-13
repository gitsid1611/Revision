package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.EmailException;
import com.masai.Exception.UserException;
import com.masai.model.Email;
import com.masai.model.LoginDto;
import com.masai.model.User;
import com.masai.service.EmailService;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaimail")
public class UserController {
	
	@Autowired
	private UserService usr;
	
	@Autowired
	private EmailService ps;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUser( @Valid @RequestBody User  user) throws UserException{
		
		return new ResponseEntity<User>(usr.registerUser(user), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LoginDto login) throws UserException{
		
		return new ResponseEntity<User>(usr.loginUser(login), HttpStatus.OK);
	}
	
	
	@PutMapping("/user")
	ResponseEntity<User> updateUser(@RequestBody User user)throws UserException{
		

		
		
		User updated = usr.UpdateUser(user);
		return new ResponseEntity<User>(updated, HttpStatus.OK);
		
		
			
	}
	
	
	@PostMapping("/mail")
	public ResponseEntity<Email> AddEmail(@Valid @RequestBody Email cs) throws EmailException{
		
		if(cs==null)
		{
			throw new EmailException("Not Saved");
		}
		else {
			Email add = ps.AddEmail(cs);
			
			return new ResponseEntity<Email>(add,HttpStatus.OK);
		}
		
	
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Email> DeleteEmail(@PathVariable("id") Email email) throws EmailException{
		
		Email pe = ps.removeEmail(email);
	
		return new ResponseEntity<Email>(pe ,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/mail")
	public ResponseEntity<List<Email>> viewAll()throws EmailException{

		List<Email> find = ps.viewAllEmail();

		return new ResponseEntity<List<Email>>(find,HttpStatus.OK);

	}
	
	
	
	

}
