package com.example.Controller;

import com.example.Exception.EmailException;
import com.example.Exception.UserException;
import com.example.Module.Email;
import com.example.Module.User;
import com.example.Repository.UserRepo;
import com.example.Services.EmailService;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/masaimail")
public class UserController {

    @Autowired
    private UserService userser;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo usr;


    @Autowired
    private EmailService ps;


    @PostMapping("/register")
    public ResponseEntity<User> signUpAdminHandler(@Valid @RequestBody User user) throws UserException {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userser.registerUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsear(){

        String s = "User logged in successfully ";

        return new ResponseEntity<String>(s, HttpStatus.OK);
    }


    @GetMapping("/getallUser")
    public ResponseEntity<List<User>> getallUser(){

        List<User> savedUser = usr.findAll();

        return new ResponseEntity<List<User>>(savedUser, HttpStatus.OK);
    }



    @PutMapping("/user")
    ResponseEntity<User> updateUser(@RequestBody User user)throws UserException{

        User updated = userser.UpdateUser(user);

        return new ResponseEntity<User>(updated, HttpStatus.OK);

    }




    @PostMapping("/mail")
    public ResponseEntity<Email> AddEmail(@Valid @RequestBody Email cs) throws EmailException {

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


    @PostMapping("/starred/{id}")
    ResponseEntity<Email> DeletePlant(@PathVariable("id") Email ema) throws EmailException{

        Email pe = ps.StarredEmail(ema);

        return new ResponseEntity<Email>(pe ,HttpStatus.OK);

    }



    @GetMapping("/starred")
    public ResponseEntity<List<Email>> viewAllStarred()throws EmailException{

        List<Email> find = ps.viewAllEmail();

        return new ResponseEntity<List<Email>>(find,HttpStatus.OK);

    }









}
