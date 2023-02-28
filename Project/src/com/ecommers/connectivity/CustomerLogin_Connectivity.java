package com.ecommers.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CustomerLogin_Connectivity {
public static  void getCustomerLogin(Scanner scanner) {
	
	try {
		// loading driver class
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
		System.out.println("-----------------------------------Welcome to Login Page-----------------------------------");
		// Create a statement
		PreparedStatement ps = conn.prepareStatement(
				"SELECT  * FROM customers WHERE CustomerMail = ? and Password = ?");
		System.out.println("Enter the Customer Email :");
		String CustomerMail =scanner.next();
		System.out.println("Enter the Password :");
		String Password = scanner.next();
        //Close the connection
		ps.setString(1,CustomerMail );
		ps.setString(2, Password);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		rs.getString(1);
		rs.getString(2);
		System.out.println(" Customer Login completed.........................");
		}	conn.close();
		ps.close();
		
}catch(Exception e) {
	e.printStackTrace();
}
}
}