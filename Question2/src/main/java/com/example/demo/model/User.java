package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String name;
	private String phoneNo;
	private String dateOfBirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "user_email", joinColumns = @JoinColumn(name ="user_id", referencedColumnName = "id"))
	private Email email;

	
	
	
	
}
