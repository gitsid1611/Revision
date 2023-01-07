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
public class Email {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int mail_id;
	private String email;
	private String created_date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "email_Address", joinColumns = @JoinColumn(name ="mail_id", referencedColumnName = "mail_id"))
	private User user;
}
