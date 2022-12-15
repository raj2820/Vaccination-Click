package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
//	@PostMapping("/login")
//	public ResponseEntity<String> loginToAccountHandler(@RequestBody LoginDTO loginDto){
//		String message = loginService.loginToAccount(loginDto);
//		
//		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
//	}
	
	
//	@PostMapping("/logout")
//	public ResponseEntity<String> logOutFromAccountHandler(@RequestParam("key") String key){
//		
//		String message = loginService.logOutFromAccount(key);
//		
//		return new ResponseEntity<String>(message,HttpStatus.OK);
//	}

}
