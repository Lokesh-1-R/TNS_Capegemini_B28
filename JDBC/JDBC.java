package com.tnc.jdbcprog;
import java.sql.*;
public class JDBC {

	public static void main(String[] args) {
		try {
		//	Class.forName  ("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b28","root","root");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Student");
			while(rs.next()) {
				System.out.println( rs.getInt("idStudent") + " "+ rs.getNString("Studentname") + " "+ rs.getInt("Studentage") +" "+ rs.getNString("StudentDept"));
			}
//			stmt.close();
//			con.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}
