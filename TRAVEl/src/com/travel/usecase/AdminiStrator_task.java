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
	
  public static boolean admin_login() {
		
		AdministratorDAO admn = new AdministratorDAO_impl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the username"+"\n");
		
		String username = sc.next();
		
		System.out.println("Enter the password"+"\n");
		
		String password = sc.next();
		
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
		
		System.out.println("Enter the Bus name"+"\n");
		
		String busName = sc.next();
		
		System.out.println("Enter the Busid"+"\n");
		
		int busid = sc.nextInt();
		
		System.out.println("Enter the Departure City"+"\n");
		
		String from = sc.next();
		
		System.out.println("Enter the Arrival City"+"\n");
		
		String to = sc.next();
		
		System.out.println("Enter the Date and Time"+"\n");
		
		String dateandTime = "";
		
		dateandTime+=sc.next()+" ";
		dateandTime+=sc.next();
		
		System.out.println("Enter the total Seat"+"\n");
		
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

    
                /**** Conform_Booking_Ticket  
                 * @throws Customer_Exception ****/
     
     
     
       public static Customer conform_Book_Ticket() throws Customer_Exception {
    	   Customer customer = null;
    	   
    	   Scanner sc = new Scanner(System.in);
    	   
    	   System.out.println("Enter the TicketNo:"+"\n");
    	   
    	   int Ticketno = sc.nextInt();
    	   
    	   AdministratorDAO_impl admin = new AdministratorDAO_impl();
    	   
    	  try {
		 customer = admin.conform_booking_ticket(Ticketno);
			
			
			
			
		} catch (Administrator_Exception | Customer_Exception e) {
			// TODO Auto-generated catch block
			
			throw new Customer_Exception("no data found");
		}
    	   
    	   
    	   
    	   
    	   
    	   
    	   return customer;
    	   
    	   
       }

       
       
                /**** View_All_bus_details 
                 * @throws Administrator_Exception ****/

       
       public static   List<Bus_Details> view_All_Bus() throws Administrator_Exception{
    	   
    	   List<Bus_Details> list = null;
    	   
    	   AdministratorDAO_impl admin = new  AdministratorDAO_impl();
    	   
    	   try {
    	     list = admin.view_all_bus_details();
			
			
			
		} catch (Exception e) {

                   throw new Administrator_Exception("no bus details found");
			
			}
    	   
    	   
    	   
    	   
    	   return list;
    	   
       }
       
       
       
       /*** View_All_Booking ****/
       
       
       public static List<Booking> view_all_booking() throws Customer_Exception{
    	   
    	   List<Booking> list = null;
    	   
    	    list = null;
    	   
    	   AdministratorDAO_impl admin = new  AdministratorDAO_impl();
    	   
    	   try {
			list = admin.viewALLBooking();
			
		} catch ( Customer_Exception e) {
			
			throw new Customer_Exception("no booking");
		}
    	   
    	   return list;
    	   
       }
       
       


}
