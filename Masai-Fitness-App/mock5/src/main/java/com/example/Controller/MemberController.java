package com.example.Controller;

import com.example.Dao.MemberDao;
import com.example.Exception.MemberException;
import com.example.Module.Member;
import com.example.Module.Slot;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MemberController {



    @Autowired
    private MemberDao memb;

    @Autowired
    private PasswordEncoder passwo;


    @Autowired
    private MemberService ps;


    @PostMapping("/add")
    public ResponseEntity<Member> AddMember(@Valid @RequestBody Member cs) throws MemberException{

        if(cs==null)
        {
            throw new MemberException("Not Saved");
        }
        else {
            Member add = ps.addMember(cs);

            return new ResponseEntity<Member>(add,HttpStatus.CREATED);
        }



    }




    @PostMapping("/masaifitness/register")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {

        member.setPassword(passwo.encode(member.getPassword()));

        Member emp= memb.save(member);

        return new ResponseEntity<Member>(emp, HttpStatus.OK);
    }



    @GetMapping("/masaifitness/login")
    public ResponseEntity<Member> loginEmployee(@RequestBody Member member) {

        member.setPassword(passwo.encode(member.getPassword()));

        Member emp= memb.save(member);

        return new ResponseEntity<Member>(emp, HttpStatus.OK);
    }




    @DeleteMapping("/masaifitness/slot/{id}")
    ResponseEntity<Slot> Deletemember(@PathVariable("id") Slot p) throws MemberException {

        Slot pe = ps.DeleteSlot(p);

        return new ResponseEntity<Slot>(pe ,HttpStatus.OK);

    }




}
