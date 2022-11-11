package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.travel.exception.BusException;
import com.travel.exception.Customer_Exception;
import com.travel.model.Booking;
import com.travel.model.Bus_Details;
import com.travel.model.Customer;
import com.travel.utility.DButil;

public class CustomerDAO_impl implements CustomerDAO {

	@Override
	public boolean create_customerAccount(Customer c) throws Customer_Exception {
		
		boolean flag = false;
		
		
		try(Connection conn = DButil.getConnection()){
			
			
		PreparedStatement ps =	conn.prepareStatement("insert into customer values(?,?,?,?)");
		
		ps.setString(1, c.getCnmae());
		ps.setString(2, c.getAddress());
		ps.setString(3, c.getCmobile());
		ps.setString(4, c.getPassword());
		
		
		
		int x = ps.executeUpdate();
		
		if(x > 0) flag = true;
		
		else throw new Customer_Exception("no data found");
		
			
		             
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Customer_Exception(e.getMessage());
			
		}
		
		
		
		
		
		
		return flag;
	}

	@Override
	public boolean customer_login(String username, String password) throws Customer_Exception {
	
		boolean flag = false;
		
		
		
		try(Connection conn = DButil.getConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select * from customers where customerName = ? AND customerpassword = ?");
		
		   ps.setString(1, username);
		   ps.setString(2, password);
		   
		  ResultSet rs =  ps.executeQuery();
		  
		  if(rs.next()) {
			
			  flag = true;
		  }
		  else {
			  
			  throw new Customer_Exception("Username and Password is Incorrect..!");
		  }
		   
		
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new Customer_Exception(e.getMessage());
		}
		
		
		
		
		return flag;
		
	}

	@Override
	public List<Bus_Details> getbusdetails(String from, String to) throws Customer_Exception {
		
		List<Bus_Details> list = new ArrayList<>();
		
		
		
		try(Connection conn = DButil.getConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from bus_details where BusFrom = ? AND BusTo = to");
			
		ps.setString(1, from);
		ps.setString(2, to);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Customer_Exception(e.getMessage());
		}
		
		
		
		
		
		return list;
		
		
		
	}

	@Override
	public boolean bus_booking(int Busid , int cid) throws Customer_Exception, BusException {
	
		boolean flag = false;
		
		
		
		try(Connection conn = DButil.getConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from bus_details where busid = ?");
		
		ps.setInt(1, Busid);
		
	     ResultSet rs = ps.executeQuery();
	     
	     if(rs.next()) {
	    	 
	    	 int TotalSeat = rs.getInt("BusremainingSeat");
	    	 
	    	 if(TotalSeat > 0) {
	    		 
	    		 
	    		PreparedStatement ps1 =  conn.prepareStatement("insert into booking values (?,?,?)");
	    		 
	    		 ps1.setInt(1, cid);
	    		 ps1.setInt(2, Busid);
	    		 ps1.setString(3, "false");

	    		 int x = ps1.executeUpdate();
	    		 
	    		 if(x > 0) flag = true;
	    		 
	    		 
	    	PreparedStatement ps2 =	conn.prepareStatement("update bus_details set BusremainingSeat = ? where busid = ?");
	    		
	           TotalSeat = TotalSeat--;
	           
	           ps2.setInt(1, TotalSeat);
	           ps2.setInt(2, Busid);
	    		 
	    	 }
	    	 else {
	    		 
	    		 throw new Customer_Exception("seat not available");
	    	 }
	    	 
	    	 
	     }
	     else {
	    	 
	    	 throw new BusException("bus not found");
	     }
		}
		
		catch (SQLException e) {
			// TODO: handle exception
			throw new BusException(e.getMessage());
		} 
		
		return flag;
		
		
		
	}

	@Override
	public boolean cancel_ticket(int ticketno) throws Customer_Exception {
		
		boolean flag = false;
		
		try(Connection conn = DButil.getConnection()){
			
     PreparedStatement ps = conn.prepareStatement("delete from booking where TicketNo = ?");
			
     ps.setInt(1, ticketno);
     
    int x =  ps.executeUpdate();
    
    if( x > 0) flag = true;
    
    else {
    	throw new Customer_Exception(" no ticket no found..!");  
    	
    }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Customer_Exception(e.getMessage());
		}
		
		
		
		return flag;
	}

	@Override
	public List<Booking> viewALLBooking(int cid) throws Customer_Exception {
		
		List<Booking> list = new ArrayList<>();
		
		
		try(Connection conn = DButil.getConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select * from booking where customerid = ?");
			ps.setInt(1, cid);
			
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			int cusid = rs.getInt("customerid");
			int busid = rs.getInt("Busid");
			int ticket = rs.getInt("TicketNo");
			String conformation = rs.getString("conformation");
			
			Booking ba = new Booking(cid, busid, conformation, ticket);
			list.add(ba);
			
		}
		
		if(list.isEmpty()) throw new Customer_Exception("no booking");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Customer_Exception(e.getMessage());
		}
		
		
		
		return list;
		
		
	}

	
	
}
