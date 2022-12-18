package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDao cDao;

    @Autowired
    private CurrentUserSessionDao sDao;


    @Override
    public User createUser(User user) throws UserException {
        User existingUser= cDao.findByMobileNo(user.getMobileNo());



        if(existingUser != null)
            throw new UserException("Customer Already Registered with Mobile number");




        return cDao.save(user);
    }

    @Override
    public User updateUser(User user, String key) throws UserException {
        CurrentUserSession loggedInUser= sDao.findByUuid(key);

        if(loggedInUser == null) {
            throw new UserException("Please provide a valid key to update a customer");
        }




        if(user.getUserId() == loggedInUser.getUserId()) {

            return cDao.save(user);
        }
        else
            throw new UserException("Invalid Customer Details, please login first");
    }
	
	
	

}
