package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.service.UserService;


@RestController
public class UserController {
	
	 @Autowired
	    private UserService userService;

	    @PostMapping("/users")
	    public ResponseEntity<User> saveUserHandler(@RequestBody User user) throws UserException {

	        User savedUser= userService.createUser(user);


	        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	    }

	    @PutMapping("/users")
	    public  ResponseEntity<User> updateUserHandler(@RequestBody User user,@RequestParam(required = false ) String key ) throws UserException {


	        User updatedUser= userService.updateUser(user, key);

	        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);

	    }

}
