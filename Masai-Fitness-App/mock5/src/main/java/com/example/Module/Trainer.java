package com.example.Module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @Id
    @Pattern(regexp = "^[0-9]{10}", message = "Length of mobile number should be of 10 digit and it should be number only ")
    @Column(unique = true)
    private String mobileNumber;

    @Pattern(regexp = "^[a-zA-Z]{2,20}", message = "Length of name should be two to 20 characters ")
    private String name;

    @Min(value=23, message="age should be greater than 23 ")
    private Integer age;

    @NotNull(message="gender can only be male or female ")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Min(value=5000, message="Minimum personal training fees should be 5000 ")
    private Integer personalTrainingFee;

    @Min(value=25000, message="Minimum salary should be 25,000 ")
    private Integer salary;


    private LocalDateTime joinedOn = LocalDateTime.now();

    @NotNull(message="gender can only be male or female ")
    @Enumerated(EnumType.STRING)
    private TrainerType trainerType;

    @OneToMany
    private List<Member> members;

    @OneToMany
    private List<Slot> slots;
}