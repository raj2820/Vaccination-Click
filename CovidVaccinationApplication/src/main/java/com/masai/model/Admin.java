package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;
    private String adminName;
    private String adminMobileNo;
    private String adminEmail;
    private String adminPassword;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminMobileNo, String adminEmail, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminMobileNo = adminMobileNo;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminMobileNo() {
        return adminMobileNo;
    }

    public void setAdminMobileNo(String adminMobileNo) {
        this.adminMobileNo = adminMobileNo;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminMobileNo='" + adminMobileNo + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
	

}
