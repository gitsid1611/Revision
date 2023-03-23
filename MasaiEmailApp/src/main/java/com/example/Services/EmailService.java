package com.example.Services;

import com.example.Exception.EmailException;
import com.example.Module.Email;

import java.util.List;

public interface EmailService {

    public Email AddEmail(Email email)throws EmailException;

    public Email removeEmail(Email emailId) throws EmailException;

    public List<Email> viewAllEmail()throws EmailException;


    public Email StarredEmail(Email inth)throws EmailException;

    public List<Email> getStarredEmail(Email inth)throws EmailException;

}
