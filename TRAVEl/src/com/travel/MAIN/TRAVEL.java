package com.travel.MAIN;

import java.util.List;
import java.util.Scanner;

import com.travel.exception.Administrator_Exception;
import com.travel.exception.BusException;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;
import com.travel.usecase.AdminiStrator_task;
import com.travel.usecase.Customer_Task;

public class TRAVEL {

	public static void main(String[] args) {
		
		MAIN();
        
	}
	
	public static void MAIN() {
		
		System.out.println("\n\n");
		System.out.println(ANSI_Yellow+"   Welcome to TRAVEL Bus Booking  "+"\n"+ANSI_RESET);
		System.out.println("****************************************"+"\n");
		Scanner sc = new Scanner(System.in);
		
		System.out.println(
				" 1. Continue As Customer"+"\n\n"
						+" 2. Continue As Administrator"+"\n");  
		
		int out = sc.nextInt();
		
		
		if(out ==1) customer_credential();		
		
		else if(out == 2) Administrator_credential();
		
		else System.out.println(ANSI_RED+"incorrect input...!"+ANSI_RESET);
		
		
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
			 
			 if(flag) System.out.println(ANSI_Green+"Account created successfully"+"\n"+ANSI_RESET);
			 
			 else System.out.println(ANSI_RED+"Cannot create account...!"+"\n"+ANSI_RESET);
			  
			 System.out.println("1. BACK");
			 
			 int back = sc.nextInt();
			 
			 if(back ==1) customer_credential();
		  
	      break;
	      
		  case 2:
			  
			  int cid = Customer_Task.Login();
			  
			  if(cid > 0) {
				  
				  System.out.println(ANSI_Green+"Logn Succesfull"+"\n"+ANSI_RESET);
				  
				  Customer_Task(cid);
			  }
			  
			  else {
				  
				  System.out.println(ANSI_RED+"incorrect username or password"+"\n"+ANSI_RESET);
				  
				  System.out.println("1. BACK");
					 
					  back = sc.nextInt();
					 
					 if(back ==1) customer_credential();
			  }
			 
			break;
			  
			default:System.out.println(ANSI_Green+"incorrect input ...!"+ANSI_RESET);  
			  break;
    		  
		  }
		  
		  
	  }
	
	
	       /**** Administrator Credential ****/
	
	
	  public static void Administrator_credential() {
		  
		  Scanner sc = new Scanner(System.in);
		  
		  boolean flag = AdminiStrator_task.admin_login();
		  
		  if(flag) {
			  
			  System.out.println(ANSI_Green+"Login Succesfull"+"\n"+ANSI_RESET);
			  
			  Administrator_Task();
		  }
		  else {
			  
              System.out.println(ANSI_RED+"incorrect username or password"+"\n"+ANSI_RESET);
			  
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
				 +"5. Main Menu"+"\n"
				  );
		  
		  
		  int task = sc.nextInt();
		  
          
		  switch(task) {
		  
		      
		  case 1:
			      boolean flag = AdminiStrator_task.bus_details();
			      
			      if(flag) {
			    	  
			    	  
			    	  System.out.println(ANSI_Green+"Bus Details Entered Sucessfully"+"\n"+ANSI_RESET);

			    	  System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Administrator_Task();
			    	  
			      }
			      else {
			    	  
			    	  System.out.println(ANSI_RED+"Cannot Insert Bus Details"+"\n"+ANSI_RESET);

			    	  System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Administrator_Task();
			 
			      }
			  
			 break;     
			      
		  case 2 :
			try {
				Customer customer =   AdminiStrator_task.conform_Book_Ticket();
				
				System.out.println(ANSI_Green+"Ticket Conformed Sucessfully"+"\n"+ANSI_RESET);
				
				System.out.println(customer);
				
				System.out.println("1. BACK"+"\n");
		    	  
		        int back = sc.nextInt();
		    	  
		        if(back ==1) Administrator_Task();
				
			} catch (Customer_Exception e) {
			
				System.out.println(ANSI_RED+"Ticket Number is invalid"+"\n"+ANSI_RESET);
				
				 System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Administrator_Task();
			}
			
		 
	      break;
			
			
		  case 3:
			  
			  try {
				List<Bus_Details> list = AdminiStrator_task.view_All_Bus();
			
				System.out.println(ANSI_Green+"Bus Details :"+"\n\n"+ANSI_RESET);

                  for(int i = 1; i <=list.size(); i++ ) {
					
					System.out.print(i+". ");
					System.out.print(list.get(i-1));
				}
				
				System.out.println("1. BACK"+"\n");
		    	  
		        int back = sc.nextInt();
		    	  
		        if(back ==1) Administrator_Task();
		        
			} catch (Administrator_Exception e) {
 
				System.out.println(ANSI_RED+"No bus available"+"\n"+ANSI_RESET);
				
				 System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Administrator_Task();
                   
			}
			  
		 break;	  
			  
		  case 4:
			  
			  try {
					List<Booking> list = AdminiStrator_task.view_all_booking();
				
					System.out.println(ANSI_Green+"Booking Details :"+"\n\n"+ANSI_RESET);
					
					for(int i = 1; i <=list.size(); i++ ) {
							
							System.out.print(i+". ");
							System.out.print(list.get(i-1));
						}
					
					System.out.println("1. BACK"+"\n");
			    	  
			        int back = sc.nextInt();
			    	  
			        if(back ==1) Administrator_Task();
			        
				} catch (Customer_Exception e) {
	 
					System.out.println(ANSI_RED+"No Booking ...!"+"\n"+ANSI_RESET);
					
					 System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Administrator_Task();
	                   
				}
			  
			  
		break;	
		
		
		  case 5: MAIN();
		  
		  break;
			      
		  default : 
			  
			  
			  System.out.println(ANSI_RED+"unexpected input...!"+"\n"+ANSI_RESET);
				
				 System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Administrator_Task();;
			   
		    	  break;

		  
		  }
		  
		  
		
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	     /**** Customer Task ****/
	
	  public static void Customer_Task(int cid) {
		  
		  Scanner sc = new Scanner(System.in);
		
		  System.out.println(
				   
				   "1. Book Bus Ticket"+"\n"
				  +"2. Cancel Bus Ticekt"+"\n"
				  +"3. View All Booing"+"\n"
				  +"4. Main Menu"+"\n"
				  );
		  
		  int task = sc.nextInt();
				  
		  
		  switch (task) {
		  
		     
		  case 1:
			  
			  List<Bus_Details> list = null;
			 
			  try {
				 
				 list =  Customer_Task.list_of_Bus();
				 
				System.out.println(ANSI_Green+"Bus Details"+"\n"+ANSI_RESET);
				
				for(int i = 1; i <=list.size(); i++ ) {
					
					System.out.print(i+". ");
					System.out.print(list.get(i-1));
				}
			 }
				
			 catch(Customer_Exception e) {
                   
	             System.out.println(ANSI_RED+"There is no Bus Found ..!"+ANSI_RESET);			 
				
	             System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Customer_Task(cid);	
		    	  else {
		    		  
		    		  System.out.println(ANSI_RED+"unexpected input...!"+"\n"+ANSI_RESET);
						
						 System.out.println("1. BACK"+"\n");
				    	  
				    	   back = sc.nextInt();
				    	  
				    	  if(back ==1) Customer_Task(cid);
		    		  
		    	  }
				 
				}
				
				
				System.out.println("Choose the bus"+"\n");
				
				int ch = sc.nextInt();
				
				if(ch >list.size() || ch < 1) {
					
					System.out.println(ANSI_RED+"unexpected input...!"+"\n"+ANSI_RESET);
					
					 System.out.println("1. BACK"+"\n");
			    	  
			    	  int back = sc.nextInt();
			    	  
			    	  if(back ==1) Customer_Task(cid);
					
				}
				else {
					
				try {
					
					boolean flag  = Customer_Task.bus_booking(list.get(ch-1).getBid(), cid);
					
					if(flag) System.out.println(ANSI_Green+"Booking Successfull Administrator Conformed Shortly"+"\n"+ANSI_RESET);
					
				} catch (BusException e) {
					
					System.out.println(ANSI_RED+"You Can Book bus only day Before ...!"+"\n"+ANSI_RESET);
				}
				catch(Customer_Exception e) {
					
					System.out.println(ANSI_RED+"No Available Seat ..!"+"\n"+ANSI_RESET);
				}
					
				}
				
				System.out.println("1. BACK"+"\n");
		    	  
		    	  int back = sc.nextInt();
		    	  
		    	  if(back ==1) Customer_Task(cid);
				
				
		   break;
		   
		  case 2:
			  
      			boolean flag =   Customer_Task.cancel_Ticket(cid);
      			
      			if(flag) {
      				System.out.println(ANSI_Green+"Booking Canceled "+"\n"+ANSI_RESET);
					
					 System.out.println("1. BACK"+"\n");
			    	  
			    	   back = sc.nextInt();
			    	  
			    	  if(back ==1) Customer_Task(cid);
      			}
      			else {
      				
      				System.out.println(ANSI_RED+" Ticket Number not found ..!"+"\n"+ANSI_RESET);
					
					 System.out.println("1. BACK"+"\n");
			    	  
			    	   back = sc.nextInt();
			    	  
			    	  if(back ==1) Customer_Task(cid);
      				
      				
      			}
      			
      		break;
      		
		  case 3 :
			  
			try {
				
				List<Booking> lis =  Customer_Task.booking_details(cid);
				
				System.out.println(ANSI_Green+"Booking Detail"+"\n"+ANSI_RESET);
				for( int i=1; i<lis.size(); i++) {
					
					
					System.out.print(i+". "+lis.get(i-1)+"\n");
					
				}
				
				System.out.println("1. BACK"+"\n");
		    	  
		    	   back = sc.nextInt();
		    	  
		    	  if(back ==1) Customer_Task(cid);
				
			} catch (Customer_Exception e) {
				
			     System.out.println(ANSI_RED+"NO Booking ..!"+ANSI_RESET);
			     
			     System.out.println("1. BACK"+"\n");
		    	  
		    	   back = sc.nextInt();
		    	  
		    	  if(back ==1) Customer_Task(cid);
			}
			  
		    	  
		    break;
		    
		  case 4: MAIN();
		  break;
		    
		    default :  
		    	
		    	System.out.println(ANSI_RED+"unexpected input...!"+"\n"+ANSI_RESET);
				
				 System.out.println("1. BACK"+"\n");
		    	  
		    	   back = sc.nextInt();
		    	  
		    	  if(back ==1) Customer_Task(cid);
		    	  
		   break;
		  }
	  
		  
	  }
	
	
	 /**** Declaring ANSI_RESET so that we can reset the color ****/
	  
	  public static final String ANSI_RESET= "\u001B[0m";
	  
	  public static final String ANSI_RED = "\u001B[31m";
	  
	  public static final String ANSI_Green = "\u001B[32m";
	  
	  public static final String ANSI_Yellow = "\u001B[33m";

	

}
