package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class projectutil {

	public static Connection creatConnection()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_4","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection createConnection() {
		// TODO Auto-generated method stub
		return null;
	
	
	}
}
