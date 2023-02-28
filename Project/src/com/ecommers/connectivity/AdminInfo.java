package com.ecommers.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class AdminInfo {
		public void CustomerDetails()throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			PreparedStatement ps = conn.prepareStatement("SELECT CustomerName, CustomerMail, Address FROM customers ");
			ResultSet rs = ps.executeQuery();
			System.out.println("-----------------------------------Customer Details------------------------------");
			System.out.println("CustomerName             CustomerMail                Address");
			while (rs.next()) {
				System.out.println(rs.getString(1) +"                                     " + rs.getString(2) +"                                   "+ rs.getString(3));
			}

			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCartDetails(Scanner scanner)throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
//		PreparedStatement	ps = conn.prepareStatement(
//					"SELECT oi.Totalamount, cst.CustomerName, prd.ProductName, ac.Productquantity ,  FROM addcart ac,customers cst, product prd \r\n"
//							+ "where ac.Customerid = cst.customer_id and ac.ProductName = prd.ProductName order by ac.Ordernum ");
			PreparedStatement	ps = conn.prepareStatement("select * from orderinfo ");
			ResultSet rs = ps.executeQuery();
			System.out.println("-----------------------------------Order Details------------------------------");
			System.out.println("CustomerName     ProductName           ProductQuantity        ProductPrice        TotalAmount ");
			while (rs.next()) {
				System.out.println(
						rs.getString(1) +"                 "+ rs.getString(2) +"                 "+ rs.getInt(3) + "                        "+rs.getInt(4) +"                  "+rs.getInt(5));       
			}

			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getProductDetails(Scanner scanner) throws Exception {
		String input;
		int Productid;
		int Price;
		int Quantity;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			PreparedStatement ps = conn.prepareStatement(
					"SELECT Productid, ProductName , Description , Price, Quantity FROM product ORDER BY  ProductName ");
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------------------------Product Details---------------------------------------------");
			System.out.println("Productid    ProductName       Price      Quantity     Description ");
			while (rs.next()) {
				System.out.println(rs.getString(1) +"                     "+ rs.getString(2) +"                           "+ rs.getString(5) +"                          "+ rs.getString(4)+"                             "+rs.getString(3));
			}
			System.out.println("DO you want to change quantity and Unit Price ? press Y or N");
		
			if(scanner.hasNext()) {
			input = scanner.next();
			
			while (input.equals("Y")  || input.equals( "y")) {
							System.out.println("Select any one product id from  above list");
					Productid = scanner.nextInt();
					System.out.println("---------------------------Provide price for product----------------------");
					Price = scanner.nextInt();
					System.out.println("-------------------------Provide the quantity of product-----------------------");
					Quantity = scanner.nextInt();
					System.out.println("---------------------------Press s for Save------------------------ ");
					String save = scanner.next();
					if (save.equals("S")  || save.equals( "s")) {
						PreparedStatement	ps2 = conn.prepareStatement("UPDATE product SET Quantity =  ?, Price =? WHERE Productid = ?");
						System.out.println(
								"---------------------------------------------------------------------------------------------------------------------------------");
						ps2.setInt(1, Quantity);
						ps2.setInt(2, Price);
						ps2.setInt(3, Productid);
						ps2.executeUpdate();
					
					System.out.println("Press E for Exit or Y to change any other product detail");
					input = scanner.next();
				}
					
				
			}
			conn.close();
			ps.close();
			rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}

