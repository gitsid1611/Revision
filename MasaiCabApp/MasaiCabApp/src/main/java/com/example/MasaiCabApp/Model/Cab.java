package com.example.MasaiCabApp.Model;

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
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   private String driverName ;

   private int cabLocation[] = new int[2];


    @ManyToOne(cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();

}
