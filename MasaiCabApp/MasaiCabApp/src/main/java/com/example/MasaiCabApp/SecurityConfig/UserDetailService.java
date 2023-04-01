package com.example.MasaiCabApp.SecurityConfig;

import com.example.MasaiCabApp.Model.User;
import com.example.MasaiCabApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService {

    public class userDetailService implements UserDetailsService {

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
}
