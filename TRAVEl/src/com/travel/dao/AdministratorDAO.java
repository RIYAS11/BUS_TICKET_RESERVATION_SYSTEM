package com.travel.dao;

import java.util.List;

import com.travel.exception.Administrator_Exception;
import com.travel.exception.Customer_Exception;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;

public interface AdministratorDAO {

	public boolean admin_login(String username , String password) throws Administrator_Exception ;
	
	public boolean create_bus_details(Bus_Details bus) throws Administrator_Exception;
	
	public Customer conform_booking_ticket(int cid) throws Administrator_Exception, Customer_Exception;
	
	public List<Bus_Details> view_all_bus_details()throws Administrator_Exception;
	
}
