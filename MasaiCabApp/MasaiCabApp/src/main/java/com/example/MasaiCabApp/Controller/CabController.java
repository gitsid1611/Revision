package com.example.MasaiCabApp.Controller;

import com.example.MasaiCabApp.Exception.CabException;
import com.example.MasaiCabApp.Exception.UserException;
import com.example.MasaiCabApp.Model.Cab;
import com.example.MasaiCabApp.Model.User;
import com.example.MasaiCabApp.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/masaicab/user")
public class CabController {


    @Autowired
    private CabService crp;



    @PostMapping("/register")
    public ResponseEntity<Cab> signUpAdminHandler(@Valid @RequestBody Cab cab) throws CabException {



        Cab savedUser = crp.addcab(cab);

        return new ResponseEntity<Cab>(savedUser, HttpStatus.CREATED);
    }





}
