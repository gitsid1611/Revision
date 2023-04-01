package com.example.MasaiCabApp.Service;

import com.example.MasaiCabApp.Exception.UserException;
import com.example.MasaiCabApp.Model.User;
import com.example.MasaiCabApp.Repo.CabRepo;
import com.example.MasaiCabApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo  usr;

    @Autowired
    private CabRepo crp;

    @Override
    public User registerUser(User user) throws UserException {
        Optional<User> f= usr.findByUsername(user.getFirstName());

        if(f == null)
        {
            usr.save(user);

        }
        else{
            throw new UserException("User already registered");
        }

        return f.get();

    }

    @Override
    public List<User> viewAllUser() throws UserException {

        return usr.findAll();



    }

    @Override
    public User updateUser(User user) throws UserException {
        Optional<User>opt=usr.findByUsername(user.getFirstName());

        if(opt.isPresent())
        {
            usr.save(user);

        }


        else {
            throw new UserException("User with given name is not presesnt........");

        }

        return opt.get();
    }


}
