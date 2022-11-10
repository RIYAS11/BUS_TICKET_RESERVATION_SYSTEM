package com.travel.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButil {

	private static String url;
    private static String driverName;
    private static String username;
    private static String password;
	
    static {
        
        ResourceBundle rb= ResourceBundle.getBundle("dbdetails");
        
        url= rb.getString("db.url");
        driverName= rb.getString("db.drivername");
        username= rb.getString("db.username");
        password= rb.getString("db.password");
        
        
        
    }

	public static Connection getConnection() {
		
		Connection conn = null;
		
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
		try {
			conn = DriverManager.getConnection(url , username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
