package com.example.Repository;

import com.example.Module.Email;
import com.example.Module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<Email, Integer> {

    public Email findByStarred(boolean starred);


}
