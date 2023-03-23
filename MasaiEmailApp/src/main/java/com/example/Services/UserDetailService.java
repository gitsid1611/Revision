package com.example.Services;

import com.example.Module.User;
import com.example.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo usr;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> opt = usr.findByUsername(username);
        if(opt.isEmpty()) {
            throw new UsernameNotFoundException("No admin detail found with this username ");
        }else {

            return new UserLogin(opt.get());
        }
    }
}
