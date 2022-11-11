package com.travel.usecase;

import java.util.List;
import java.util.Scanner;

import com.travel.dao.AdministratorDAO;
import com.travel.dao.AdministratorDAO_impl;
import com.travel.exception.Administrator_Exception;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;

public class AdminiStrator_task {


                  /****	ADMIN_LOGIN ****/
	
  public static boolean admin_login(String username , String password) {
		
		AdministratorDAO admn = new AdministratorDAO_impl();
		
		boolean flag = false;
		
		try {
		
			flag = admn.admin_login(username, password);
		
		} catch (Administrator_Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		
		return flag;
	}
  
  
  
                /**** Insert_Bus_Details ****/
  
  
     public static boolean bus_details(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Bus name");
		
		String busName = sc.next();
		
		System.out.println("Enter the Busid");
		
		int busid = sc.nextInt();
		
		System.out.println("Enter the from");
		
		String from = sc.next();
		
		System.out.println("Enter the To");
		
		String to = sc.next();
		
		System.out.println("Enter the DateandTime");
		
		String dateandTime = sc.next();
		
		System.out.println("Enter the total Seat");
		
		int n = sc.nextInt();
		
		
		
		boolean flag = false;
		AdministratorDAO_impl admin = new AdministratorDAO_impl();
		
		Bus_Details bus = new Bus_Details(busName, busid, from, to, dateandTime, n);
		
		try {
			 flag = admin.create_bus_details(bus);
		} catch (Administrator_Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		
	
		return flag;
		
	}

    
                /**** Conform_Booking_Ticket  ****/
     
     
     
       public static boolean conform_Book_Ticket(int Ticketno) {
    	   
    	   boolean flag = false;
    	   
    	   AdministratorDAO_impl admin = new AdministratorDAO_impl();
    	   
    	  try {
			Customer customer = admin.conform_booking_ticket(Ticketno);
			
			System.out.println(customer);
			
			
		} catch (Administrator_Exception | Customer_Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
    	   
    	   
    	   
    	   
    	   
    	   
    	   return flag;
    	   
    	   
       }

       
       
                /**** View_All_bus_details ****/

       
       public static  boolean view_All_Bus(){
    	   
    	   boolean flag = false;
    	   
    	   AdministratorDAO_impl admin = new  AdministratorDAO_impl();
    	   
    	   try {
    		   List<Bus_Details> list = admin.view_all_bus_details();
			
			System.out.println(list);
			
		} catch (Administrator_Exception e) {
			flag = false;
			
			}
    	   
    	   
    	   
    	   
    	   return flag;
    	   
       }
       
       
       
       /*** View_All_Booking ****/
       
       
       public static boolean view_all_booking() {
    	   
    	   boolean flag = false;
    	   
    	   List<Booking> list = null;
    	   
    	   AdministratorDAO_impl admin = new  AdministratorDAO_impl();
    	   
    	   try {
			list = admin.viewALLBooking();
			System.out.println(list);
			flag = true;
		} catch ( Customer_Exception e) {
			flag = false;
		}
    	   
    	   return flag;
    	   
       }
       
       


}
