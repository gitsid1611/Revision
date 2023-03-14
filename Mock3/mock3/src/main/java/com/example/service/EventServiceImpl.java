package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.EventRepo;
import com.example.exception.EventException;
import com.example.model.event;


@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo erp;

	@Override
	public event addEvent(event cs) throws EventException {
		// TODO Auto-generated method stub
        event mod = erp.save(cs);
		
		if(mod!=null)
		{
			return mod;
		}
		else {
			throw new EventException("Input is Not Correct");
		}
	}

	@Override
	public event updateEvent(event even, Integer eventId) throws EventException {
		Optional<event> s = erp.findById(eventId);
		  
		  if(s==null)
		  {
			  throw new EventException("Sorry Event Id  are not Available");
		  }
		  else
		  {
			  Optional<event> opt=  erp.findById(even.getId());
			  
			  
			  if(opt.isPresent()) {
					return erp.save(even);
				}
				else {
					throw new EventException("event does not exist");
				}
			  
		  }
		
	}

	@Override
	public event DeleteEvent(event eventId) throws EventException {
		// TODO Auto-generated method stub
	Optional<event> found = erp.findById(eventId.getId());
			
			
			if(found.isPresent()) {
				erp.delete(eventId);
				
				
			}
			else {
				throw new EventException("Cant delete this because no such event is present here");
			}
			
			return found.get();
	}
	
	
	
	

}
