package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	    @Autowired
	    private UserDao userDAO;

	    @Autowired
	    private CurrentUserSessionDao sessionDao;
		
		

		@Override
		public String logIntoAccount(LoginDTO dto) throws LoginException {
			 User  existingUser=userDAO.findByMobileNo(dto.getMobileNo());

		        if(existingUser==null){
		            throw new LoginException("Please Enter a Valid Mobile No");
		        }
		        Optional<CurrentUserSession>  vaildUserSessionOpt =sessionDao.findById(existingUser.getUserId());

		        if(vaildUserSessionOpt.isPresent()){
		            throw new LoginException("User already Logged in with this number");
		        }
		        if(existingUser.getPassword().equals(dto.getPassword())) {

		            String key= RandomString.make(6);



		            CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(),key, LocalDateTime.now());

		            sessionDao.save(currentUserSession);

		            return currentUserSession.toString();
		        }
		        else
		            throw new LoginException("Please Enter a valid password");

		    }

		@Override
		public String logOutFromAccount(String key) throws LoginException {
			  CurrentUserSession validUserSession = sessionDao.findByUuid(key);


		        if(validUserSession == null) {
		            throw new LoginException("User Not Logged In with this number");

		        }


		        sessionDao.delete(validUserSession);


		        return "Logged Out !";
		}


	    

}
