package com.example.MasaiCabApp.Service;

import com.example.MasaiCabApp.Exception.CabException;
import com.example.MasaiCabApp.Model.Cab;
import com.example.MasaiCabApp.Repo.CabRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepo crp;

    @Override
    public Cab addcab(Cab cab) throws CabException {

        Optional<Cab> c= crp.findById(cab.getId());

        if(c !=null)
        {
            throw new CabException("Cab already present");
        }
        else{
            return crp.save(cab);
        }

    }
}
