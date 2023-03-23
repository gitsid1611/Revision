package com.example.Services;

import com.example.Exception.UserException;
import com.example.Module.User;
import com.example.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo urepo;


    @Override
    public User registerUser(User user) throws UserException {
        Optional<User> opt = urepo.findById(user.getFirstname());
        if(opt.isPresent()) {
            throw new UserException("Admin already exist with this username ");
        }else {
            return urepo.save(user);
        }
    }

    @Override
    public User UpdateUser(User user) throws UserException {

        Optional<User> opt=urepo.findByUsername(user.getFirstname());

        if(opt.isPresent())
        {
            urepo.save(user);

        }
        else {
            throw new UserException("user with given id is not presesnt........");

        }

        return opt.get();
    }

}

