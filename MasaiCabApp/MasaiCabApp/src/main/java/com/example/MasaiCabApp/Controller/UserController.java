package com.example.MasaiCabApp.Controller;

import com.example.MasaiCabApp.Exception.UserException;
import com.example.MasaiCabApp.Model.User;
import com.example.MasaiCabApp.Repo.UserRepo;
import com.example.MasaiCabApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/masaicab/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService usr;

    @Autowired
    private UserRepo us;

    @PostMapping("/register")
    public ResponseEntity<User> signUpAdminHandler(@Valid @RequestBody User user) throws UserException {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = usr.registerUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUsear(){

        String s = "User logged in successfully ";

        return new ResponseEntity<String>(s, HttpStatus.OK);
    }


    @GetMapping("/getallUser")
    public ResponseEntity<List<User>> getallUser(){

        List<User> savedUser = us.findAll();

        return new ResponseEntity<List<User>>(savedUser, HttpStatus.OK);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> viewAll() throws UserException {

        List<User> find = usr.viewAllUser();

        return new ResponseEntity<List<User>>(find,HttpStatus.OK);

    }


    @PutMapping("/update")
    ResponseEntity<User> updatePlant(@RequestBody User usre)throws UserException{




        User updated = usr.updateUser(usre);
        
        return new ResponseEntity<User>(updated, HttpStatus.OK);



    }







}
