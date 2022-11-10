package com.travel.usecase;

import com.travel.dao.AdministratorDAO_impl;
import com.travel.exception.Administrator_Exception;

public class Administrator_login {

	public static boolean credentila(String username , String password) {
		// TODO Auto-generated method stub
         boolean flag = false;
		AdministratorDAO_impl admin = new AdministratorDAO_impl();
		
		try {
			 flag = admin.admin_login(username, password);
			
			 
		} catch (Administrator_Exception e) {
		
			
			flag = false;
		}
		
		return flag;
		
		
	}

}
