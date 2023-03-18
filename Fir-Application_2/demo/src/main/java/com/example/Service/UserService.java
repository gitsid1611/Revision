package com.example.Service;

import com.example.Dto.UserDTO;
import com.example.Exception.LoginException;
import com.example.Exception.UserException;
import com.example.Model.Fir;
import com.example.Model.Police;
import com.example.Model.PoliceStation;
import com.example.Model.User;

import java.util.List;

public interface UserService {



    public List<User> getallUser() throws UserException;

    public User registerUser(User user) ;

    public Police registerPolice(Police police);

    public PoliceStation registerPoliceStation(PoliceStation policeStation);

    public String logInAdmin(UserDTO dto) throws LoginException ,UserException;

    public String logOutAdmin(String key) throws LoginException;




}
