package com.example.Service;

import com.example.Dto.UserDTO;
import com.example.Exception.LoginException;
import com.example.Exception.UserException;
import com.example.Model.*;
import com.example.Repository.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PoliRepo policeRepo;

    @Autowired
    private PStation policeStationRepo;

    @Autowired
    private FirRepo firRepo;

    @Autowired
    private CurrentSessionRepo sessionDAO;




    @Override
    public List<User> getallUser() throws UserException {
        List<User> alluser = userRepo.findAll();

        if(alluser.isEmpty()) {
            throw new UserException("No Users In The Detabase");
        }
        else {
            return alluser;
        }
    }

    @Override
    public User registerUser(User user) {

        userRepo.save(user);

        return user;

    }

    @Override
    public Police registerPolice(Police police) {

        policeRepo.save(police);

        return police;
    }

    @Override
    public PoliceStation registerPoliceStation(PoliceStation policeStation) {

        policeStationRepo.save(policeStation);

        return policeStation;
    }

    @Override
    public String logInAdmin(UserDTO dto) throws LoginException ,UserException{
        User existingUser = userRepo.findByFirstname(dto.getFirstname());

        if (existingUser == null) {

            throw new LoginException("Please Enter a valid mobile number");

        }

        Optional<CurrentUserSession> validUserSessionOpt = sessionDAO.findById(existingUser.getUserId());

        if (validUserSessionOpt.isPresent()) {

            throw new LoginException("User already Logged In with this number");

        }

        if (existingUser.getPassword().equals(dto.getPassword())) {

            String key = RandomString.make(6);

            CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(), key,true,
                    LocalDateTime.now());

            sessionDAO.save(currentUserSession);

            return currentUserSession.toString();

        } else

            throw new LoginException("Please Enter a valid password");
    }

    @Override
    public String logOutAdmin(String key) throws LoginException {

        CurrentUserSession validUserSession = sessionDAO.findByUuid(key);

        if (validUserSession == null) {

            throw new LoginException("User Not Logged with this number");

        }

        sessionDAO.delete(validUserSession);

        return "you have been Logout";
    }





}
