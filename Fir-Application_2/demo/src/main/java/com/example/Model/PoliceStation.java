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
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stationCode;

    private String address;

    @OneToMany(mappedBy = "officerInCharge")
    private List<Police> officers;

    @OneToMany(mappedBy = "policeStation")
    private List<Fir> firList;



    @OneToOne
    private Police officerInCharge;

    @OneToMany(mappedBy = "station")
    private List<Police> constables;

}
