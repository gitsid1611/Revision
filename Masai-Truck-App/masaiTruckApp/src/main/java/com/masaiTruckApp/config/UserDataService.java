package com.masaiTruckApp.config;

import com.masaiTruckApp.Module.User;
import com.masaiTruckApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements UserDetailsService {


    @Autowired
    private UserRepo uRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User e= uRepo.findByFirstName(username);

        if(e!=null) {

            return new UserData(e);
        }
        else {
            throw new UsernameNotFoundException("No User Found");
        }
    }
}
