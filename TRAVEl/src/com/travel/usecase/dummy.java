package com.travel.usecase;

import java.util.List;
import java.util.Scanner;

import com.travel.dao.AdministratorDAO_impl;
import com.travel.dao.CustomerDAO_impl;
import com.travel.exception.Administrator_Exception;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;

public class dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		List<Bus_Details> list = null;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Departure City");
		
		String from = sc.next();
		
		System.out.println("Enter the Arrival City");
		
		String To = sc.next();
		
		
		CustomerDAO_impl customer = new CustomerDAO_impl();
		
		try {
			list = customer.getbusdetails(from , To);
			System.out.println(list);
			
		} catch (Customer_Exception e) {
			// TODO Auto-generated catch block
	
		}
		
		
	}
}
		
	

