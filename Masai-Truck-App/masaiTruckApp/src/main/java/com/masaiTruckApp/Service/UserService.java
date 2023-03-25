package com.masaiTruckApp.Service;

import com.masaiTruckApp.Exception.TruckException;
import com.masaiTruckApp.Exception.UserException;
import com.masaiTruckApp.Module.Truck;
import com.masaiTruckApp.Module.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user)throws UserException;

    public Truck removeVehicle(Truck truckId) throws TruckException;

    public List<Truck> viewAllVehicle()throws TruckException;


    public Truck updateVehicle(Truck id )throws TruckException;


    public Truck getVehicle(Integer id)throws TruckException;

}
