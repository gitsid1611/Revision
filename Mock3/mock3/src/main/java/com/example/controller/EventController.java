package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EventException;
import com.example.model.event;
import com.example.service.EventService;

import javax.validation.Valid;

@RestController
@RequestMapping("/masaicalender")
public class EventController {
	
	@Autowired
	private EventService ps;
	
	
	@PostMapping("/event")
	public ResponseEntity<event> addEvent( @Valid @RequestBody event cs) throws EventException{
		
		if(cs==null)
		{
			throw new EventException("Not Saved");
		}
		else {
			event add = ps.addEvent(cs);
			
			return new ResponseEntity<event>(add,HttpStatus.CREATED);
		}
		
	
		
	}
	
	
	@PutMapping("/event/{id}")
	public ResponseEntity<event> updateCustomer(@PathVariable("id") Integer id, @RequestBody event e) throws EventException
	{
		event update = ps.updateEvent(e, id);
		
		
		return new ResponseEntity<event>(update, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/event/{id}")
	ResponseEntity<event> DeletePlant(@PathVariable("id") event e) throws EventException{
		
		event pe = ps.DeleteEvent(e);
	
		return new ResponseEntity<event>(pe ,HttpStatus.OK);
		
	}

}
