package com.example.controller;

import com.example.Exception.FirException;
import com.example.Exception.PoliceException;
import com.example.Model.Fir;
import com.example.Model.Police;
import com.example.Service.FirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirController {

    @Autowired
    private FirService us;

    @PostMapping("/masaifir/user/fir")
    public ResponseEntity<Fir> ResgisteFir(@RequestBody Fir adms) throws FirException {

        Fir add = us.FileFIR(adms);

        return new ResponseEntity<>(add, HttpStatus.CREATED);


    }


    @GetMapping("/masaifir/user/fir/{stationId)")
    public ResponseEntity<Fir> findbyid(@PathVariable("stationId") int id) throws  PoliceException {

        Fir byid = us.getoldestFir(id);

        return new ResponseEntity<Fir>(byid,HttpStatus.OK);

    }



    @GetMapping("/masaifir/officer/{stationId}")
    public ResponseEntity<Police> findbyPoliceid(@PathVariable("stationId") int id) throws  PoliceException {

        Police byid = us.getthePolice(id);

        return new ResponseEntity<Police>(byid,HttpStatus.OK);

    }


    @DeleteMapping("/masaifir/user/fir/{firId}")
    ResponseEntity<Fir> DeleteFir(@PathVariable("id") int id) throws FirException{

        Fir pe = us.deleteFir(id);

        return new ResponseEntity<Fir>(pe ,HttpStatus.ACCEPTED);

    }












}
