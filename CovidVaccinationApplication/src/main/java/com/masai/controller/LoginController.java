package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.LoginDTO;
import com.masai.service.LoginService;


@RestController
public class LoginController {
	
	 @Autowired
	    private LoginService loginService;

	    @PostMapping("/userlogin")
	    public ResponseEntity<String> logInUserHandler(@RequestBody LoginDTO dto) throws LoginException {

	        String result = loginService.logIntoAccount(dto);



	        return new ResponseEntity<String>(result, HttpStatus.OK );


	    }

	    @PostMapping("/userlogout")
	    public String logoutUserHandler(@RequestParam(required = false) String key) throws LoginException {
	        return loginService.logOutFromAccount(key);

	    }

}
