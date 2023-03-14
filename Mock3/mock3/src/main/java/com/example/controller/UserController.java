package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.exception.LoginException;
import com.example.exception.UserException;
import com.example.model.User;
import com.example.service.UserService;



@RestController
@RequestMapping("/masaicalender")
public class UserController {

	
	@Autowired
	private UserService usr;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser( @javax.validation.Valid @RequestBody User  user) throws UserException{
		
		return new ResponseEntity<User>(usr.registerUser(user), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDto login) throws UserException, LoginException{
		
		String res = usr.loginUser(login);

		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	
	@PutMapping("/user")
	ResponseEntity<User> updatePlant(@RequestBody User user)throws UserException{
		

		
		
			User updated = usr.UpdateUser(user);
		return new ResponseEntity<User>(updated, HttpStatus.OK);
		
		
			
	}
	
	
	
	
}
