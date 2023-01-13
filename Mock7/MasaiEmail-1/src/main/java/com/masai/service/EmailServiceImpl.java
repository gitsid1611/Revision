package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.EmailException;
import com.masai.Repository.EmailRepo;
import com.masai.model.Email;

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
		List<Email> allcus = pl.findAll();

		if(allcus.isEmpty()) {
			throw new EmailException("No Emails In The Detabase");
		}
		else {
			return allcus;
		}
	}

	

}
