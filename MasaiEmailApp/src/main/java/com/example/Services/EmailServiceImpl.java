package com.example.Services;

import com.example.Exception.EmailException;
import com.example.Module.Email;
import com.example.Repository.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private EmailRepo pl;


    @Override
    public Email AddEmail(Email email) throws EmailException {
        Email mod = pl.save(email);

        if(mod!=null)
        {
            return mod;
        }
        else {
            throw new EmailException("Input is Not Correct");
        }
    }


    @Override
    public Email removeEmail(Email emailId) throws EmailException {
        Optional<Email> found = pl.findById(emailId.getEmailId());


        if(found.isPresent()) {
            pl.delete(emailId);


        }
        else {
            throw new EmailException("Cant delete this because no such email is present here");
        }

        return found.get();
    }

    @Override
    public List<Email> viewAllEmail() throws EmailException {
        List<Email> allmail = pl.findAll();

        if(allmail.isEmpty()) {
            throw new EmailException("No Emails In The Detabase");
        }
        else {
            return allmail;
        }
    }

    @Override
    public Email StarredEmail(Email inth) throws EmailException {
        Optional<Email> found = pl.findById(inth.getEmailId());


        if(found.isPresent()) {
             boolean a= true;

             inth.setStarred(a);


        }
        else {
            throw new EmailException("Cant starred this because no such email is present here");
        }

        return found.get();
    }

    @Override
    public List<Email> getStarredEmail(Email inth) throws EmailException {

        Optional<Email> found = pl.findById(inth.getEmailId());

        List<Email> allmail;

        if(found.isPresent()) {
           inth.isStarred();

             allmail = pl.findAll();


        }
        else {
            throw new EmailException("Cant starred this because no such email is present here");
        }

        return allmail;





    }


}
