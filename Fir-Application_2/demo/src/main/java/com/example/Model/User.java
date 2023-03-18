package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Pattern(message = "firstname must be of 6 to 12 length with no special characters", regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$")
    private String firstname;
    @Pattern(message = "lastname must be of 6 to 12 length with no special characters", regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$")
    private String lastname;
    @Pattern(message = "mobilenumber must be of size 10 ", regexp = "^[0-9]$")
    @Size(min = 10)
    private String mobileNumber;
    private String address;

    @NotNull
    @NotBlank
    @Min(8)
    private Integer age;

    @NotNull
    @Pattern(regexp ="Male |Female |TransGender")
    private String gender;

    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;
}
