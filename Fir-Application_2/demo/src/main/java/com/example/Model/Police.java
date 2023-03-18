package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Police {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String officerName;

    private String mobileNo;

    private String department;

    @OneToMany(mappedBy = "officer")
    private List<Fir> firsFiled;

    @OneToMany(mappedBy = "caseCloser")
    private List<Fir> casesClosed;






}
