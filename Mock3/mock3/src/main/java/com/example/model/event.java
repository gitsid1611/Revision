package com.example.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String type;
	
	
	private LocalDate eventDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	
	
	
	public event() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public LocalDate getEventDate() {
		return eventDate;
	}



	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public event(int id, String type, LocalDate eventDate, User user) {
		super();
		this.id = id;
		this.type = type;
		this.eventDate = eventDate;
		this.user = user;
	}



	@Override
	public String toString() {
		return "event [id=" + id + ", type=" + type + ", eventDate=" + eventDate + ", user=" + user + "]";
	}



	
	
	
}
