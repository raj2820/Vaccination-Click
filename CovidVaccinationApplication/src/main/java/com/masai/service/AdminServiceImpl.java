package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDao adminSessionDao;

	@Override
	public Admin createAdmin(Admin admin) throws AdminException {
		
		 Admin existingAdmin= adminDao.findByAdminMobileNo(admin.getAdminMobileNo());



	        if(existingAdmin != null)
	            throw new AdminException("Admin Already Registered with Mobile number");




	       return adminDao.save(admin);
	       
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);

        if(loggedInAdmin == null) {
            throw new AdminException("Please provide a valid key to update a customer");
        }




        if(admin.getAdminId() == loggedInAdmin.getAdminId()) {
            return adminDao.save(admin);
        }
        else
            throw new AdminException("Invalid Customer Details, please login first");
	}

	



}
