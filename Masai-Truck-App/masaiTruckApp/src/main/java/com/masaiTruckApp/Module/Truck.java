package com.masaiTruckApp.Module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String vehicleNo;
    private String color ;
    private int noOfWheels ;
    private String company ;


    @ManyToOne(cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();
}
