 package com.masai.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer userId;
	@NotNull(message="Name should not be empty")
    private String name;
	@NotNull(message="Mobile should not be empty")
    private String mobileNo;
	@NotNull(message="Password should not be empty")
    private String password;
	@NotNull(message="Email should not be empty")
    private String email;

    public User() {
    }

    public User(Integer userId, String name, String mobileNo, String password, String email) {
        this.userId = userId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
