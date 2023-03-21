package com.example.config;

import com.example.Dao.MemberDao;
import com.example.Exception.MemberException;
import com.example.Module.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    private MemberDao mem;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        Member e=mem.findByMobileNumber(mobile);

        if(e!=null) {

            return new MemberDetails(e);
        }
        else {
            throw new UsernameNotFoundException("No Member Found");
        }
    }
}
