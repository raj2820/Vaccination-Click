package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.AdminLoginDTO;
import com.masai.service.AdminLoginService;

@RestController
public class AdminLoginController {
	
	 @Autowired
	 private AdminLoginService adminLoginService;
	 
	 @PostMapping("/adminlogin")
	    public ResponseEntity<String> logInUserHandler(@RequestBody AdminLoginDTO dto) throws LoginException {

	        String result =  adminLoginService.logIntoAccount(dto);



	        return new ResponseEntity<String>(result, HttpStatus.OK );


	    }

	    @PostMapping("/adminlogout")
	    public String logoutUserHandler(@RequestParam(required = false) String key) throws LoginException {
	        return adminLoginService.logOutFromAccount(key);

	    }

}
