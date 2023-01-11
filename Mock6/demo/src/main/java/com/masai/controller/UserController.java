package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dto.UserDto;
import com.masai.exception.FirException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Fir;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> addAdminHandler(@Valid @RequestBody User user) throws UserException {

		User savedUser = userService.saveUser(user);

		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);

	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdminHandler(@Valid @RequestBody UserDto admin) throws LoginException {

		String res = userService.loginUser(admin);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	
	
	@GetMapping("/fir")
	public ResponseEntity<List<Fir>> viewAll()throws FirException{

		List<Fir> find = userService.viewAllFir();

		return new ResponseEntity<List<Fir>>(find,HttpStatus.OK);

	}
	
	
	
	
	
	
}
