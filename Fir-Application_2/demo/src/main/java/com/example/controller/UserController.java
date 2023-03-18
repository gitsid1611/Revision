package com.example.controller;

import com.example.Dto.UserDTO;
import com.example.Exception.LoginException;
import com.example.Exception.UserException;
import com.example.Model.Police;
import com.example.Model.PoliceStation;
import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping("/masaifir/user/register")
    public ResponseEntity<User> ResgisteCustomer(@RequestBody User usr) throws UserException {

        User add = us.registerUser(usr);

        return new ResponseEntity<User>(add, HttpStatus.CREATED);


    }

    @GetMapping("/masaifir/users/")
    public ResponseEntity<List<User>> AllUser(@PathVariable("userId")Integer id )throws UserException{

        List<User> ids = us.getallUser();

        return new ResponseEntity<List<User>>(ids,HttpStatus.OK);

    }

    @PostMapping("masaifir/user/registerPolice")
    public ResponseEntity<Police> registerPolice(@RequestBody Police police){

        return new ResponseEntity<Police>(us.registerPolice(police), HttpStatus.OK);

    }


    @PostMapping("masaifir/user/registerPoliceStation")
    public ResponseEntity<PoliceStation> registerPoliceStation(@RequestBody PoliceStation policeStation){

        return new ResponseEntity<PoliceStation>(us.registerPoliceStation(policeStation), HttpStatus.OK);

    }

    @PostMapping("masaifir/user/login")
    public ResponseEntity<String> logInAdmin(@RequestBody UserDTO dto) throws LoginException,UserException {

        String result = us.logInAdmin(dto);

        return new ResponseEntity<String>(result, HttpStatus.OK);

    }

    @PostMapping("masaifir/user/logout")
    public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {

        return us.logOutAdmin(key);

    }









}
