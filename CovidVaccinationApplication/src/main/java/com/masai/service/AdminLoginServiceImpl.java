package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.AdminLoginDTO;
import com.masai.model.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	 @Autowired
	    private AdminDao adminDao;

	 @Autowired
      private AdminSessionDao sessionDao;
	    
	    
	@Override
	public String logIntoAccount(AdminLoginDTO dto) throws LoginException {
		 Admin existingAdmin=adminDao.findByAdminMobileNo(dto.getAdminMobileNo());

	        if(existingAdmin==null){
	            throw new LoginException("Please Enter a Valid Mobile No");
	        }
	        Optional<CurrentAdminSession> vaildAdminSessionOpt =sessionDao.findById(existingAdmin.getAdminId());

	        if(vaildAdminSessionOpt.isPresent()){
	            throw new LoginException("Admin already Logged in with this number");
	        }
	        if(existingAdmin.getAdminPassword().equals(dto.getAdminPassword())) {

	            String key= RandomString.make(6);



	            CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key, LocalDateTime.now());

	            sessionDao.save(currentAdminSession);

	            return currentAdminSession.toString();
	        }
	        else
	            throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentAdminSession validAdminSession = sessionDao.findByUuid(key);


        if(validAdminSession == null) {
            throw new LoginException("Admin Not Logged In with this number");

        }


        sessionDao.delete(validAdminSession);


        return "Logged Out !";
	}
	
	

}
