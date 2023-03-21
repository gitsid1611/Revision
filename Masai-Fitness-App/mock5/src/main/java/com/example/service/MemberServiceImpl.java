package com.example.service;

import com.example.Dao.MemberDao;
import com.example.Dao.SlotDao;
import com.example.Exception.MemberException;
import com.example.Module.Member;
import com.example.Module.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao pl;

    @Autowired
    private SlotDao sl;





    @Override
    public Member addMember(Member cs) throws MemberException {
        Member mod = pl.save(cs);

        if(mod!=null)
        {
            return mod;
        }
        else {
            throw new MemberException("Input is Not Correct");
        }
    }


    @Override
    public Slot DeleteSlot(Slot memberid) throws MemberException {
        Optional<Slot> found = sl.findById(memberid.getSlotId());


        if(found.isPresent()) {
            sl.delete(memberid);


        }
        else {
            throw new MemberException("Cant delete this because no such slot is present here");
        }

        return found.get();
    }




}
