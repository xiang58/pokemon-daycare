package com.miniweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
	
	private static Connection con = null;
	
	// If this is a remote database, 
	// change localhost to the IP address of the remove server
	// for mySQL use URL="jdbc:mysql://localhost:3306"
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "ddxhy";
	private static final String PASSWORD = "admin123";
	
	public static Connection getConnection()
	{
		if(con==null)
		{
			try
			{
				// For mySQL use
				// Class.forName("com.mysql.jdbc.Driver");  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection()
	{
		try
		{
			if(con != null && !con.isClosed())
			{
				con.close();
			}
			con = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
