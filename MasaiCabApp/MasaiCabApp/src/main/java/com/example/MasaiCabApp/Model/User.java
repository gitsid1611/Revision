package com.example.MasaiCabApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    @NotNull
    @Pattern(regexp = "A-Za-z")
    private String firstName ;

    @NotNull
    @Pattern(regexp = "A-Za-z")
    private String lastName;

    @Size(min=10,message = "moblie number must be 10 digits ")
    @Column(unique = true)
    @Pattern(regexp = "[6789]{1}[0-9]{9}", message = "should be in required form")
    private String mobileNumber ;

    private int currentPosition[] = new int[2];


    @Size(min = 6, max = 12)
    @NotNull(message="Password Must Need")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*]", message = "Password must be have letter A-Z,a-z and charecter line @,%,&,Only Allow")
    private String password ;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Cab> cabList = new ArrayList<>();


}
