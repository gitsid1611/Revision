package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	 private UserService use;
	
	@PostMapping("/users")
	 public ResponseEntity<User> addcustomer(@Valid @RequestBody User user) throws  UserException
	 {
		 User addUser = use.addUser(user);
		 
		 return new ResponseEntity<User>(addUser, HttpStatus.OK );
	 }
	
	
	@DeleteMapping("/users/{id}")
	ResponseEntity<User> DeletePlant(@PathVariable("id") User user) throws UserException{
		
		User pe = use.deleteUser(user);
	
		return new ResponseEntity<User>(pe ,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> viewAll()throws UserException{

		List<User> find = use.viewAllUser();

		return new ResponseEntity<List<User>>(find,HttpStatus.ACCEPTED);

	}
	
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findbyid(@PathVariable("id") int id)throws UserException{

		User byid = use.viemUser(id);

		return new ResponseEntity<User>(byid,HttpStatus.ACCEPTED);

	}
	
	
	
}
