package com.masai.service;

import java.util.List;

import com.masai.Exception.EmailException;
import com.masai.model.Email;


public interface EmailService {

	public Email AddEmail(Email email)throws EmailException;
	
     public Email removeEmail(Email emailId) throws EmailException;
	
	public List<Email> viewAllEmail()throws EmailException;
	
}
