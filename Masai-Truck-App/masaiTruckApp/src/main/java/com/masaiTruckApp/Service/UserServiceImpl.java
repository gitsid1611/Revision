package com.masaiTruckApp.Service;

import com.masaiTruckApp.Exception.TruckException;
import com.masaiTruckApp.Exception.UserException;
import com.masaiTruckApp.Module.Truck;
import com.masaiTruckApp.Module.User;
import com.masaiTruckApp.Repo.TruckRepo;
import com.masaiTruckApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo usr;

    @Autowired
    private TruckRepo trp;



    @Override
    public User registerUser(User user) throws UserException {
        Optional<User> opt = usr.findById(user.getFirstName());
        if(opt.isPresent()) {
            throw new UserException("User already exist with this username ");
        }else {
            return usr.save(user);
        }
    }

    @Override
    public Truck removeVehicle(Truck truckId) throws TruckException {
        Optional<Truck> found = trp.findById(truckId.getId());


        if(found.isPresent()) {
            trp.delete(truckId);


        }
        else {
            throw new TruckException("Cant delete this because no such Vehicle is present here");
        }

        return found.get();
    }

    @Override
    public List<Truck> viewAllVehicle() throws TruckException {
        List<Truck> allTruck = trp.findAll();

        if(allTruck.isEmpty()) {
            throw new TruckException("No Vehicle In The Detabase");
        }
        else {
            return allTruck;
        }
    }

    @Override
    public Truck updateVehicle(Truck id) throws TruckException {
        Optional<Truck>  f= trp.findById(id.getId());

        if(f.isPresent())
        {
            trp.save(id);
        }
        else{
              throw new TruckException("No Vehincle to Update with this id");


        }

        return f.get();


    }

    @Override
    public Truck getVehicle(Integer id) throws TruckException {
        Optional<Truck> f= trp.findById(id);

        if(f.isEmpty())
        {
            throw new TruckException("No Vehicle with this id");
        }
        else{
            return f.get();
        }
    }


}
