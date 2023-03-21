package com.example.Controller;

import com.example.Dao.MemberDao;
import com.example.Exception.TrainerException;
import com.example.Module.Member;
import com.example.Module.Trainer;
import com.example.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/masaifitness")
public class TrainerController {


    @Autowired
    private TrainerService ps;

    @PostMapping("/register")
    public ResponseEntity<Trainer> AddTrainer(@Valid @RequestBody Trainer cs) throws TrainerException{

        if(cs==null)
        {
            throw new TrainerException("Not Saved");
        }
        else {
            Trainer add = ps.addTrainer(cs);

            return new ResponseEntity<Trainer>(add,HttpStatus.ACCEPTED);
        }



    }



    @PutMapping("/user/trainer")
    ResponseEntity<Trainer> updatePlant(@RequestBody Trainer p)throws TrainerException{




        Trainer updated = ps.updateTrainer(p);
        return new ResponseEntity<Trainer>(updated, HttpStatus.OK);



    }



    @GetMapping("/trainers/available")
    public ResponseEntity<List<Trainer>> viewAll()throws TrainerException{

        List<Trainer> find = ps.viewAllTrainer();

        return new ResponseEntity<List<Trainer>>(find,HttpStatus.OK);

    }


    @GetMapping("/trainer/{id}")
    public ResponseEntity<Trainer> findbyid(@PathVariable("id") int id)throws TrainerException{

        Trainer byid = ps.viewMember(id);

        return new ResponseEntity<Trainer>(byid,HttpStatus.OK);

    }






}
