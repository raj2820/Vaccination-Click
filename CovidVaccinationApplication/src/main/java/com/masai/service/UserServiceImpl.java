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
	private UserDao userDao;
	
	
	@Autowired
	private CurrentUserSessionDao currentUser;

	@Override
	public User createUser(User user) throws UserException {
		
		User existingUser =userDao.findByMobileNo(user.getMobileNo());
		
		if(existingUser!=null) {
			throw new UserException("User already registered with Mobile number :"+user.getMobileNo());
		}
		
		return userDao.save(user);
		
	
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		
		CurrentUserSession loggedInUser = currentUser.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new UserException("Please provide a valid key to update a user");
		}
		
		if(user.getUserId() == loggedInUser.getUserId()) {
			return userDao.save(user);
		}else {
			throw new UserException("Invalid user Details ,Please login first");
		}
		
	}
	
	
	
	

}
