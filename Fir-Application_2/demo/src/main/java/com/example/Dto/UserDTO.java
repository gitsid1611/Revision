package com.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDTO {

    private String firstname;

    private String password;

    private String mobileNumber;
}
