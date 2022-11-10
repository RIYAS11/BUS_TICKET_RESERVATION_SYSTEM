package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.travel.exception.Administrator_Exception;
import com.travel.exception.Customer_Exception;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;
import com.travel.utility.DButil;

public class AdministratorDAO_impl implements AdministratorDAO {

	@Override
	public boolean admin_login(String username, String password) throws Administrator_Exception {
		
		boolean flag = false;
		
		
		
		try(Connection conn = DButil.getConnection()){
		
			
			PreparedStatement ps = conn.prepareStatement("select * from Administrator where username = ? AND password = ? ");
			
			ps.setString(1, username);
			ps.setString(2 , password);
			
			   ResultSet rs = ps.executeQuery();

			   if(rs.next()) {
				   
				   flag = true;
			   }
			   else {
				   
				   throw new Administrator_Exception("Password and UserName is incorrect...");
			   }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Administrator_Exception(e.getMessage());
			
		}
		
		
		
		
		return flag;
		
		
		
		
	}

	@Override
	public boolean create_bus_details(Bus_Details bus) throws Administrator_Exception {
		
		boolean flag = false;
		
		
		try(Connection conn = DButil.getConnection()){
			
			
		PreparedStatement ps =	conn.prepareStatement("insert into bus_details values(?,?,?,?,?,?,?)");
		
		ps.setString(1, bus.getBName());
		ps.setInt(2, bus.getBid());
		ps.setString(3, bus.getBFrom());
		ps.setString(4, bus.getBTo());
		ps.setString(5, bus.getBDeparture());
		ps.setInt(6, bus.getTotalSeat());
		ps.setInt(7, bus.getTotalSeat());

		int x = ps.executeUpdate();
		
       if(x>0) flag = true;
       
       
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Administrator_Exception(e.getMessage());
		}
		
		
		return flag;

		
	}

	@Override
	public Customer conform_booking_ticket(int cid) throws Administrator_Exception, Customer_Exception {
		
		Customer cus = new Customer();
		
		
		
		
		try(Connection conn = DButil.getConnection()){
			
		PreparedStatement ps = conn.prepareStatement("update booking set conformation = ? where customerid = ?");
		
		ps.setBoolean(1, true);
		ps.setInt(2, cid);
		
		int x = ps.executeUpdate();
        
		if(x > 0) {
			
		PreparedStatement ps2 = conn.prepareStatement("select * from customer where customerid = ?");
			ps.setInt(1, cid);
			
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) {
				
				cus.setCnmae(rs.getString("Cusutomername"));
				cus.setAddress(rs.getString("CustomerAddress"));
				cus.setCmobile(rs.getString("customermobile"));
			}
			else throw new Customer_Exception("Customer not found ... on this id "+cid);
		}
		else throw new Administrator_Exception("cid is not there for update");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Administrator_Exception(e.getMessage());
			
		} catch (Customer_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Customer_Exception(e.getMessage());
		}
		

		return cus;
		
	}

	@Override
	public List<Bus_Details> view_all_bus_details() throws Administrator_Exception {
		
		List<Bus_Details> list = new ArrayList<>();
		
		try(Connection conn = DButil.getConnection()){
			
		PreparedStatement ps = 	conn.prepareStatement("select b.busname, b.busid , b.busfrom , b.busto, b.busDeparture , b.busTotalSeat, count(bo.busid) Total_Customer  from bus_details b INNER JOIN BOOKING bo ON b.busid = bo.busid GROUP BY bo.busid");
			
		     ResultSet rs =  ps.executeQuery();
		     
		     if(!rs.next()) throw new Administrator_Exception("no data found...");
		     
		     while(rs.next()) {
		    	 
		    	 String busname = rs.getString("busname");
		    	 int busid = rs.getInt("busid");
		    	 String busfrom = rs.getString("busfrom");
		    	 String busto = rs.getString("busto");
		    	 String depart = rs.getString("busDeparture");
		    	 int seat = rs.getInt("totalSeat");
		    	 int total = rs.getInt("Total_Customer");
		    	 
		    	 Bus_Details bus = new Bus_Details(busname, busid, busfrom, busto, depart, seat, total);
		    	 
		    	 list.add(bus);
		     }
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Administrator_Exception(e.getMessage());
		}
		
		
		return list;
		
	}

	

}
