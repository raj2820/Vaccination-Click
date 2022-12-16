package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	

	@PutMapping("/updateuser")
    public ResponseEntity<User> updateUserHandler(@RequestBody User user,@RequestParam("uuid") String uuid){
    	
    	User updatedUser = userService.updateUser(user, uuid);
    	
    	return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }

}
