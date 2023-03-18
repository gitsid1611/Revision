package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String crimeDetail;

    private LocalDateTime timeStamp;

    private boolean isOpen;


    @ManyToOne
    private User applicant;

    @ManyToMany
    private List<User> criminals;

    @ManyToOne
    private Police officer;

    @ManyToOne
    private PoliceStation policeStation;

}
