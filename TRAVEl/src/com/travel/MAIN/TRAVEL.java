package com.travel.MAIN;

import java.util.List;
import java.util.Scanner;

import com.travel.exception.Administrator_Exception;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;
import com.travel.usecase.AdminiStrator_task;
import com.travel.usecase.Customer_Task;

public class TRAVEL {

	public static void main(String[] args) {
		
		System.out.println("   Welcome to TRAVEL Bus Booking  "+"\n");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(
				" 1. Continue As Customer"+"\n"
				+" 2. Continue As Administrator"+"\n");  
		
		int out = sc.nextInt();
		
		
		if(out ==1) customer_credential();		
		
		else if(out == 2) Administrator_credential();
		
		else System.out.println("incorrect input...!");
		
		

	}
	
	
	
        	/****   Customer credential ****/
	
	  public static void customer_credential() {
		  
		  Scanner sc = new Scanner(System.in);

		  System.out.println(
					" 1. Create a Account"+"\n"
					+" 2. Login "+"\n");  
		  
		  int task = sc.nextInt();
		  
		  
		  switch(task) {
		  
		  case 1 :
			  
			 boolean flag =  Customer_Task.Create_Account();
			 
			 if(flag) System.out.println("Account created successfully"+"\n");
			 
			 else System.out.println("Cannot create account...!"+"\n");
			  
			 System.out.println("1. BACK");
			 
			 int back = sc.nextInt();
			 
			 if(back ==1) customer_credential();
		  
	      break;
	      
		  case 2:
			  
			  int cid = Customer_Task.Login();
			  
			  if(cid > 0) {
				  
				  System.out.println("Logn Succesfull"+"\n");
				  
				  Customer_Task(cid);
			  }
			  
			  else {
				  
				  System.out.println("incorrect username or password"+"\n");
				  
				  System.out.println("1. BACK");
					 
					  back = sc.nextInt();
					 
					 if(back ==1) customer_credential();
			  }
			  
			  
			default:System.out.println("incorrect input ...!");  
			  
    		  
		  }
		  
		  
	  }
	
	
	       /**** Administrator Credential ****/
	
	
	  public static void Administrator_credential() {
		  
		  Scanner sc = new Scanner(System.in);
		  
		  boolean flag = AdminiStrator_task.admin_login();
		  
		  if(flag) {
			  
			  System.out.println("Login Succesfull"+"\n");
			  
			  Administrator_Task();
		  }
		  else {
			  
              System.out.println("incorrect username or password"+"\n");
			  
			  System.out.println("1. BACK");
				 
			  int back = sc.nextInt();
				 
			  if(back ==1) Administrator_credential();
			  
		  }

		
	  }
	  
	
	       
	      /**** Administrator Task ****/

	  
	  public static void  Administrator_Task() {
		  
		  
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.println(
				  
				  "1. Enter the Bus Details"+"\n"
				 +"2. Conform Ticket "+"\n"
			     +"3. View  All Bus Details"+"\n"
				 +"4. View All Booking"+"\n"
				  );
		  
		  
		  int task = sc.nextInt();
		  
		  
		  
		  switch(task) {
		  
		      
		  case 1:
			      boolean flag = AdminiStrator_task.bus_details();
			      
			      if(flag) {
			    	  
			    	  
			    	  System.out.println("Bus Details Entered Sucessfully"+"\n");

			    	  System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Administrator_Task();
			    	  
			      }
			      else {
			    	  
			    	  System.out.println("Cannot Insert Bus Details"+"\n");

			    	  System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Administrator_Task();
			 
			      }
			      
		  case 2 :
			try {
				Customer customer =   AdminiStrator_task.conform_Book_Ticket();
				
				System.out.println("Ticket Conformed Sucessfully"+"\n");
				
				System.out.println(customer);
				
				System.out.println("1. BACK"+"\n");
		    	  
		        int back = sc.nextInt();
		    	  
		        if(back ==1) Administrator_Task();
				
			} catch (Customer_Exception e) {
			
				System.out.println("Ticket Number is invalid"+"\n");
				
				 System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Administrator_Task();
			}
			
			
		  case 3:
			  
			  try {
				List<Bus_Details> list = AdminiStrator_task.view_All_Bus();
			
				System.out.println("Bus Details :"+"\n\n");

				list.forEach(el -> {
					
					System.out.println(el);
					
				});
				
				System.out.println("1. BACK"+"\n");
		    	  
		        int back = sc.nextInt();
		    	  
		        if(back ==1) Administrator_Task();
		        
			} catch (Administrator_Exception e) {
 
				System.out.println("No bus available"+"\n");
				
				 System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Administrator_Task();
                   
			}
			  
		  case 4:
			  
			  try {
					List<Booking> list = AdminiStrator_task.view_all_booking();
				
					System.out.println("Booking Details :"+"\n\n");
					list.forEach(el -> {
						
						System.out.println(el);
						
					});
					
					System.out.println("1. BACK"+"\n");
			    	  
			        int back = sc.nextInt();
			    	  
			        if(back ==1) Administrator_Task();
			        
				} catch (Customer_Exception e) {
	 
					System.out.println("No Booking ...!"+"\n");
					
					 System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Administrator_Task();
	                   
				}
			  
			      
		  
		  
		  
		  
		  
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	     /**** Customer Task ****/
	
	  public static void Customer_Task(int cid) {
		  
		  
		  
		  
	  }
	
	
	

}
