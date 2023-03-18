package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CurrentUserSession {

    @Id
    private Integer userId;

    private String uuid;

    private Boolean admin;

    private LocalDateTime localDateTime;




}
