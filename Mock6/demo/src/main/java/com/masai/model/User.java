package com.masai.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	
   @Pattern(regexp = "^[a-zA-Z]{3,12}$",
           message = "Firstname must be of 6 to 12 length with no special characters")
	private String firstName;
   
   @Pattern(regexp = "^[a-zA-Z]{3,12}$",
           message = "lastname must be of 6 to 12 length with no special characters")
	private String lastName;
   
   @Size(min = 10 , max = 10, message ="Mobile Number Should Contains 10 digits")
	private String mobileNumber;
   
    @NotNull
    @NotBlank
	private String address;
    
    @NotNull
    @Min(8)
	private int age;
    
    @Pattern(regexp ="Male|Female|TransGender")
	private String gender;
	
	 @Pattern(regexp = "^(([a-zA-Z0-9])(?=.*[!@#$&*])){6,12}$",
	            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	 private String password;
	 
	 
	
	
}
