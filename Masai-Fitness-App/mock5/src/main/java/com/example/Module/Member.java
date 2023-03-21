package com.example.Module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Pattern(message = "firstname must be of 6 to 12 length with no special characters", regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$")
    private String firstName ;

    @Pattern(message = "firstname must be of 6 to 12 length with no special characters", regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$")
    private String lastName;

    @Pattern(message = "mobilenumber must be of size 10 ", regexp = "^[0-9]$")
    @Size(min = 10)
    private String mobileNumber ;

    private String address ;


    @Min(16)
    private int age;


    @NotNull(message="gender can only be male or female ")
    @Enumerated(EnumType.STRING)
    private Gender gender;



    private int budget;

    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;


    @ManyToOne(cascade = CascadeType.ALL)
    private Trainer trainer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Slot slot;
}
