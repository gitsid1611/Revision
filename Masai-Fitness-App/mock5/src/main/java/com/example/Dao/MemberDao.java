package com.example.Dao;

import com.example.Module.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member,Integer> {

    public Member findByMobileNumber(String mobileNumber);
}
