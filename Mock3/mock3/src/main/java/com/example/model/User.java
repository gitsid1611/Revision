package com.example.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Email(message="Email should be unique")
	@Column(unique=true)
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z]{3,12}$",
	           message = "Firstname should not contain number & special characters")
	private String firstname;
	
	 
	@Pattern(regexp = "^[a-zA-Z]{3,12}$",
	           message = "lastname should not contain number & special characters")
	private String lastname;
	
	@Size(min = 10 , max = 10, message ="Mobile Number Should Contains 10 digits")
	private String mobileNumber;
	
	@Pattern(regexp = "^(([a-zA-Z0-9])(?=.*[!@#$&*])){6,12}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;
	
	
	private LocalDate dateOfBirth;
	
	@OneToMany(cascade=CascadeType.ALL)
	private event e;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public event getE() {
		return e;
	}

	public void setE(event e) {
		this.e = e;
	}

	public User(int id, @Email(message = "Email should be unique") String email,
			@Pattern(regexp = "^[a-zA-Z]{3,12}$", message = "Firstname should not contain number & special characters") String firstname,
			@Pattern(regexp = "^[a-zA-Z]{3,12}$", message = "lastname should not contain number & special characters") String lastname,
			@Size(min = 10, max = 10, message = "Mobile Number Should Contains 10 digits") String mobileNumber,
			@Pattern(regexp = "^(([a-zA-Z0-9])(?=.*[!@#$&*])){6,12}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ") String password,
			LocalDate dateOfBirth, event e) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.e = e;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", e="
				+ e + "]";
	}

	
	
	
	
	
	
	
	
}
