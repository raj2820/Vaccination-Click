package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currentUser;
	
	
	
	@Override
	public String loginToAccount(LoginDTO loginDto) throws LoginException {
		
		User existingUser =  userDao.findByMobileNo(loginDto.getMobileNo());
		
		if(existingUser == null) {
			throw new LoginException("Please Enter a valid Mobile Number, First create account then login");
		}
		
		Optional<CurrentUserSession> ValidUsersessionOpt = currentUser.findById(existingUser.getUserId());
		
		if(ValidUsersessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number :");
		}
		
		if(existingUser.getPassword().equals(loginDto.getPassword())) {
			
			String key = RandomString.make(6);
			

			CurrentUserSession currentUsersession = new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			
		    
			currentUser.save(currentUsersession);
			
			return currentUsersession.toString();
		}
		else {
			throw new LoginException("Please Enter a valid password");
		}
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		CurrentUserSession ValidUserSession = currentUser.findByUuid(key);
		
		if(ValidUserSession==null) {
			throw new LoginException("User Not Logged In With This Number ");
		}
		
		currentUser.delete(ValidUserSession);
		
		return "Logged out !";
	}

}
