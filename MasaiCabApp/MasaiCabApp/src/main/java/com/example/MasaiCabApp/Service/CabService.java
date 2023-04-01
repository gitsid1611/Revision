package com.example.MasaiCabApp.Service;

import com.example.MasaiCabApp.Exception.CabException;
import com.example.MasaiCabApp.Model.Cab;

public interface CabService {


    public Cab addcab(Cab cab)throws CabException;
}
