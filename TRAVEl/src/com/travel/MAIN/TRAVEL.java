package com.travel.MAIN;

import java.util.Scanner;

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
		  
		  
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	     /**** Customer Task ****/
	
	  public static void Customer_Task(int cid) {
		  
		  
		  
		  
	  }
	
	
	

}
