package com.example.Module;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Email {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emailId;

    private String Subject;

    private String Description;

    private boolean starred;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "email")
    private List<User> userList = new ArrayList<>();


}
