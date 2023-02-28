package com.ecommers.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

public class CartConnectivity {
	Connection connection = null;
	PreparedStatement ps = null;
	int prodQty = 0;
	public void Add_Cart(String CustomerName, String ProductName, int Productquantity) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			ps = connection
					.prepareStatement("INSERT INTO addcart(CustomerName,ProductName,Productquantity) values (?,?,?)");
			ps.setString(1, CustomerName);
			ps.setString(2, ProductName);
			ps.setInt(3, Productquantity);
			int i = ps.executeUpdate();
			System.out.println("-----" + i + " Product  added  in  cart -----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getValues(Scanner scanner) throws Exception {
		String CustomerName = null;
		String ProductName = null;
		
		// Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter the Name of customer :");
			CustomerName = scanner.next();
			System.out.println("Enter the Name of product :");
			ProductName = scanner.next();
			System.out.println("Enter the quantity of product : ");
			prodQty = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input, please enter a number.");
		}
		Add_Cart(CustomerName, ProductName, prodQty);
		UsersCartProduct(ProductName,prodQty);
		decreaseQuantity(ProductName, prodQty);
	}

	public void UsersCartProduct(String ProduName, int prodQty) throws Exception {
		System.out.println("i am here");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");

			ps = connection.prepareStatement("SELECT * FROM product WHERE ProductName = ? ");
			ps.setString(1, ProduName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Product Id : " + rs.getInt(1));
				System.out.println("Product name :" + rs.getString(2));
				System.out.println("Product Description : " + rs.getString(3));
				System.out.println("Product Quantity  :" + prodQty);
				System.out.println("Product Price :" + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("This product added to cart");
	}

	public void decreaseQuantity(String ProductName, int Quantity) throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			ps = connection.prepareStatement("select Quantity from product where productName = ?");
			ps.setString(1, ProductName);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			;
			if (rs.next()) {
				i = rs.getInt("Quantity");
				// rest of your code here
			} else {
				System.out.println("No data found for the given product name ");
			}

			// int i = rs.getInt(1);
			PreparedStatement ps1 = null;
			ps1 = connection.prepareStatement("UPDATE product SET Quantity = ? WHERE ProductName = ?");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------");
			// ps.setInt(1, Quantity);
			ps1.setInt(1, (i - Quantity));
			ps1.setString(2, ProductName);

			// Execute the update statement
			ps1.executeUpdate();

		} catch (SQLException e) {
			// Handle any errors that occur
			e.printStackTrace();
		}
	}

}
