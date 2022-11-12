package com.travel.usecase;

import java.util.List;
import java.util.Scanner;

import com.travel.dao.CustomerDAO_impl;
import com.travel.exception.BusException;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;

public class Customer_Task {

	/**** Customer_Account_Create ***/
	
	public static boolean Create_Account() {
		
		boolean flag = false;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Cname");
		
		String cname = sc.next();
		
		System.out.println("Enter the Customer address");
		
		String Caddres = sc.next();
		
		System.out.println("Enter the Cmobile");
		
		String mobile = sc.next();
		
		System.out.println("Enter the password");
		
		String pass = sc.next();
		
		Customer customer = new Customer(cname, Caddres, mobile, pass);
		
		
		
		
	    CustomerDAO_impl cus = new CustomerDAO_impl();
	    	
	    try {
		     flag =  cus.create_customerAccount(customer);
	        
	    } catch (Customer_Exception e) {
		
		          flag = false;
          	}	    	   
	    	
	    	   return flag;
	       
	}
		
		
	/*** Login ***/
	
	
	public static int Login() {
		
		
		 int cid = -1;

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the UserName"+"\n");
			
			String username = sc.next();
			
			System.out.println("Enter the password"+"\n");
			
			String password = sc.next();
			System.out.println("\n");
			
			CustomerDAO_impl cus = new CustomerDAO_impl();
			
			try {
				
				cid = cus.customer_login(username, password);
				
			} catch (Customer_Exception e) {
				// TODO Auto-generated catch block
				
			}
			
			
			return cid;
		
		
	}
	
	
	
	/**** Bus_details ****/

	
	
	public static List<Bus_Details> list_of_Bus() throws Customer_Exception{
		
	List<Bus_Details> list = null;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Departure City");
		
		String from = sc.next();
		
		System.out.println("Enter the Arrival City");
		
		String To = sc.next();
		
		
		CustomerDAO_impl customer = new CustomerDAO_impl();
		
		try {
			
			list = customer.getbusdetails(from , To);
			
			
		} catch (Customer_Exception e) {
			
			throw new Customer_Exception(e.getMessage());
	
		}
		
		return list;
		
				
	}
	
	
	    /**** BOOKING ****/

	
	public static boolean bus_booking(int busid , int cusid) {
		
		boolean flag = false;
		
		
		CustomerDAO_impl cus = new CustomerDAO_impl();
		
		try {
			 flag = cus.bus_booking(busid, cusid);
			
		} catch (Customer_Exception e) {
		
			System.out.println("seat not avqailbel");
			
		} catch (BusException e) {
			
			System.out.println("date matter");
		
		}
		
		return flag;
		
	}
	
	
	
	  /**** Cancel_Ticket ****/
	
	
	public static boolean cancel_Ticket(int tickno ) {
		
		boolean flag = false;
		
		
        CustomerDAO_impl cus = new CustomerDAO_impl();
		
		try {
		     flag = cus.cancel_ticket(tickno);
			
		} catch (Customer_Exception e) {
		
		
		}
		
		return flag;
		
	}
		
		
		
     /**** Get_Booking details  ****/
	
	public static List<Booking> booking_details(int cid) throws Customer_Exception{
		
		List<Booking>	list = null;
		  
		  CustomerDAO_impl cus = new CustomerDAO_impl();
				
		      try {
					
		    	  list =	cus.viewALLBooking(1);
				
			} catch (Customer_Exception e) {
				
				throw new Customer_Exception(e.getMessage());
			}
		
		 return list;
	}
	
	
		
		
		
	}
	
	
	

