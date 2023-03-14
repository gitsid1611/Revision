package com.example.service;

import com.example.exception.EventException;
import com.example.model.event;

public interface EventService {

	
    public event addEvent (event cs) throws EventException;
	
	public event updateEvent(event even, Integer eventId) throws EventException;
	
	public event DeleteEvent (event eventId) throws EventException;

//	public event updateEvent(event e, Integer id);
}
