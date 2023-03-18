package com.example.Service;

import com.example.Exception.FirException;
import com.example.Exception.PoliceException;
import com.example.Model.Fir;
import com.example.Model.Police;

public interface FirService {

    public Fir FileFIR(Fir fir) throws FirException;

    public Fir getoldestFir(Integer policeStationID) throws PoliceException;

    public Police getthePolice(Integer policeStationID) throws PoliceException;

    public Fir deleteFir(Integer firID) throws FirException ;


    public Fir updateFir(Integer policeStationID, Integer firID);

    public Police deletePolice(Police policeID) throws PoliceException;


}
