package com.hibernate.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "root";
		
		try {
			System.out.println("Connecting to DB: "+ jdbcUrl);
			Connection myConnect = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection Successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
