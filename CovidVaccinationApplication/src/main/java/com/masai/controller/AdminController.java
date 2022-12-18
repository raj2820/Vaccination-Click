package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.service.AdminService;

@RestController
public class AdminController {
	
	 @Autowired
	 private AdminService adminService;
	 
	 @PostMapping("/admins")
	   public ResponseEntity<Admin> saveAdminHandler(@RequestBody Admin admin) throws AdminException {

	        Admin savedAdmin= adminService.createAdmin(admin);


	        return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
	    }
	 @PutMapping("/admins")
	    public  ResponseEntity<Admin> updateUserHandler(@RequestBody Admin admin,@RequestParam(required = false ) String key ) throws AdminException {


	        Admin updatedAdmin= adminService.updateAdmin(admin,key);

	        return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.OK);

	    }

}
