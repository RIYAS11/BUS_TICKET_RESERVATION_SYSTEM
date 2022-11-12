package com.travel.dao;

import java.util.List;

import com.travel.exception.BusException;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;

public interface CustomerDAO {

	public boolean create_customerAccount(Customer c) throws Customer_Exception ; 
	
	public int customer_login(String username , String password) throws Customer_Exception;
	
	public List<Bus_Details> getbusdetails(String from , String to) throws Customer_Exception;
	
	
	public boolean bus_booking(int id,int cid) throws Customer_Exception, BusException;
	
	public boolean cancel_ticket(int ticketno) throws Customer_Exception;
	
	public List<Booking> viewALLBooking(int cid) throws Customer_Exception;
	
}
