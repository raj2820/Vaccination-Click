package com.masai.model;

public class AdminLoginDTO {

	   private String adminMobileNo;
	   
	   private String adminPassword;

	    public AdminLoginDTO() {
	    }

	    public AdminLoginDTO(String adminMobileNo, String adminPassword) {
	        this.adminMobileNo = adminMobileNo;
	        this.adminPassword = adminPassword;
	    }

	    public String getAdminMobileNo() {
	        return adminMobileNo;
	    }

	    public void setAdminMobileNo(String adminMobileNo) {
	        this.adminMobileNo = adminMobileNo;
	    }

	    public String getAdminPassword() {
	        return adminPassword;
	    }

	    public void setPassword(String password) {
	        this.adminPassword= password;
	    }
	
}
