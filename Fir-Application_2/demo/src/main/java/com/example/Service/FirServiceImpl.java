package com.example.Service;

import com.example.Exception.FirException;
import com.example.Exception.PoliceException;
import com.example.Model.Fir;
import com.example.Model.Police;
import com.example.Model.PoliceStation;
import com.example.Repository.FirRepo;
import com.example.Repository.PStation;
import com.example.Repository.PoliRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FirServiceImpl implements FirService{

    @Autowired
    private FirRepo us;

    @Autowired
    private PStation ps;

    @Autowired
    private PoliRepo pr;

    @Override
    public Fir FileFIR(Fir fir) throws FirException {

        Fir fi = us.save(fir);

        if(fi==null) {
            throw new FirException("Fir not Lodge");
        }
        else {
            return fi;
        }
    }

    @Override
    public Fir getoldestFir(Integer policeStationID) throws PoliceException {

        Optional<Fir> id = us.findById(policeStationID);

        if(id.isEmpty()) {
            throw new PoliceException("Can't get Fir with this id");
        }
        else {
            return id.get() ;

        }
    }

    @Override
    public Police getthePolice(Integer policeStationID) throws PoliceException{
        Optional<Police> id = pr.findById(policeStationID);

        if(id.isEmpty()) {
            throw new PoliceException("Cac't get Police with this id");
        }
        else {
            return id.get() ;

        }
    }

    @Override
    public Fir deleteFir(Integer firID) throws FirException {
        Fir fRepo =	us.findById(firID).orElseThrow(()->new FirException("No FIR Found"));

        us.deleteById(firID);

        return fRepo;
    }

    @Override
    public Fir updateFir(Integer policeStationID, Integer firID) {
        return null;
    }

    @Override
    public Police deletePolice(Police policeID) throws PoliceException {
        Optional<Police> found = pr.findById(policeID.getId());


        if(found.isPresent()) {
            pr.delete(policeID);


        }
        else {
            throw new PoliceException("Cant delete this because no such Police is present here");
        }

        return found.get();
    }
}
