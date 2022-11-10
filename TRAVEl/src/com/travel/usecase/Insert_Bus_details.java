package com.travel.usecase;

import com.travel.dao.AdministratorDAO_impl;
import com.travel.exception.Administrator_Exception;
import com.travel.model.Bus_Details;
import java.util.*;

public class Insert_Bus_details {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdministratorDAO_impl admn = new AdministratorDAO_impl();
		
		Bus_Details bus = new Bus_Details("koli", 1000, "kollam", "TVM", "2020-01-02 05:00:00", 60);
		try {
			List<Bus_Details> x = admn.view_all_bus_details();
		System.out.println(x);
		} catch (Administrator_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
