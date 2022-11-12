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
         
		CustomerDAO_impl cus = new CustomerDAO_impl();
		
      try {
		List<Booking>	list =	cus.viewALLBooking(1);
		System.out.println(list);
	} catch (Customer_Exception e) {
		
	}
		
		
     		
		
	}
		
		

}
		
	

