package com.ecommers.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductConnectivity {
	
		public String getName() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			 //Statement condition = new Condition();
			    //condition.add("1=1", "ORDER BY name ASC");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM product ORDER BY ProductName" );
			ResultSet rs = ps.executeQuery();
			
				while (rs.next()) {
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("ProductId = " + rs.getInt(1));
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("ProductName = " + rs.getString(2));
				System.out.println("Description = " + rs.getString(3));
				System.out.println("Product Price = " + rs.getString(4));
				System.out.println("Product Quantity = " + rs.getString(5));
							}
			
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null ;
	}

	
}
