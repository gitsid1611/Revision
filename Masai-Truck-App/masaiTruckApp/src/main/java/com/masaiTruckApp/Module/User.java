package com.masaiTruckApp.Module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @Pattern(message = "firstname must be of 6 to 12 length with no special characters", regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$")
    private String firstName;

    @Pattern(message = "firstname must be of 6 to 12 length with no special characters", regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$")
    private String lastName ;

    @Pattern(message = "mobilenumber must be of size 10 ", regexp = "^[0-9]$")
    @Size(min = 10)
    private String mobileNumber;
    private String address ;


    @NotNull(message ="Age should be above 18 years")
    @Min(19)
    private int age;


    @NotNull(message="gender can only be male or female ")
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Size(min = 6, max = 12)
    @NotNull(message="Password Must Need")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*]", message = "Password must be have letter A-Z,a-z and charecter line @,%,&,Only Allow")
    private String password ;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Truck> truckList = new ArrayList<>();

}
