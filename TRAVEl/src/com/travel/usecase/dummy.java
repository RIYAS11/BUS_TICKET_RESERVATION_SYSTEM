package com.travel.usecase;

import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

import com.travel.dao.AdministratorDAO_impl;
import com.travel.dao.CustomerDAO_impl;
import com.travel.exception.Administrator_Exception;
import com.travel.exception.BusException;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;

public class dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
//Scanner sc = new Scanner(System.in);

System.out.println("Enter the Bus name"+"\n");

String busName = sc.next();

System.out.println("Enter the Busid"+"\n");

int busid = sc.nextInt();

System.out.println("Enter the Departure City"+"\n");

String from = sc.next();

System.out.println("Enter the Arrival City"+"\n");

String to = sc.next();

System.out.println("Enter the total Seat"+"\n");

int n = sc.nextInt();

System.out.println("Enter the Date and Time");

String dateandTime= "";
dateandTime+=sc.next()+" ";
dateandTime+=sc.next();
System.out.println(dateandTime);
//System.out.println(dateandTime);

System.out.println("lop");
     		
		
	}
		
		

}
		
	

