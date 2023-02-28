package com.ecommers.connectivity;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Column_Calculation {
	public void calculate(Scanner scanner) {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
            // Scanner  scr  = new Scanner(System.in);
             System.out.println("Enter product name : ");
             String ProductName= scanner.next();
             System.out.println("Enter Customer name :");
             String CustomerName  = scanner.next();
          		ps = con.prepareStatement("SELECT Price FROM product WHERE ProductName= ?  ");
          	    ps.setString(1,ProductName );
    			ResultSet rs1 = ps.executeQuery();
			int i = 0;
			while (rs1.next()) {
				i = rs1.getInt(1);
			}
			ps1 = con.prepareStatement("SELECT Productquantity  FROM addcart WHERE CustomerName = ?");
			ps1.setString(1,CustomerName );
			ResultSet rs2 = ps1.executeQuery();
			int j = 0;
			while (rs2.next()) {
				j = rs2.getInt(1);
			}
			int totalColumns = i * j;
			System.out.println("Total Price : " + totalColumns);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
