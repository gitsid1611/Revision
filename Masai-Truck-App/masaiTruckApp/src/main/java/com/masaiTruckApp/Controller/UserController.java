package com.masaiTruckApp.Controller;

import com.masaiTruckApp.Exception.TruckException;
import com.masaiTruckApp.Exception.UserException;
import com.masaiTruckApp.Module.Truck;
import com.masaiTruckApp.Module.User;
import com.masaiTruckApp.Repo.UserRepo;
import com.masaiTruckApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/masaiTruck")
public class UserController {

    @Autowired
    private UserService userser;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo usr;


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){

        return new ResponseEntity<String>("Welcome to Masai Truck App",HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<User> signUpAdminHandler(@Valid @RequestBody User user) throws UserException {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userser.registerUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }


    @PostMapping("/user/login")
    public ResponseEntity<String> loginUsear(){

        String s = "User logged in successfully ";

        return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @GetMapping("/getallUser")
    public ResponseEntity<List<User>> getallUser(){

        List<User> savedUser = usr.findAll();

        return new ResponseEntity<List<User>>(savedUser, HttpStatus.OK);
    }



    @GetMapping("/user/vehicles")
    public ResponseEntity<List<Truck>> viewAll()throws TruckException {

        List<Truck> find = userser.viewAllVehicle();

        return new ResponseEntity<List<Truck>>(find,HttpStatus.OK);

    }

    @GetMapping("/user/vehicle/{vehicleId}")
    public ResponseEntity<Truck> findbyid(@PathVariable("vehicleId") int vehicleId)throws TruckException{

        Truck byid = userser.getVehicle(vehicleId);

        return new ResponseEntity<Truck>(byid,HttpStatus.OK);

    }


    @GetMapping("/user/{vehicleId}")
    ResponseEntity<Truck> UpdateVehicle(@PathVariable("id") Truck tr) throws TruckException{

        Truck pe = userser.updateVehicle(tr);

        return new ResponseEntity<Truck>(pe ,HttpStatus.OK);

    }


    @DeleteMapping("/user/{vehicleId}")
    ResponseEntity<Truck> DeleteVehicle(@PathVariable("id") Truck tr) throws TruckException{

        Truck pe = userser.removeVehicle(tr);

        return new ResponseEntity<Truck>(pe ,HttpStatus.OK);

    }





}
