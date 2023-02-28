package com.ecommers.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.quantity.Product;

public class Payment_Info {
	       Connection con = null;
	       public void getPaymentData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //retrieve products from the database
        List<Product> products = new ArrayList<Product>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ProductName, Description, Price, Quantity FROM product");
            while (rs.next()) {
                products.add(new Product(rs.getString("ProductName"), rs.getString("Description"),rs.getInt("Price"), rs.getInt("Quantity")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //calculate total price
        double totalPrice = 0;
        for (Product product : products) {
            //totalPrice = product. ;
        }

        //display total price
        System.out.println("Total price: " + totalPrice);

         }
	       
    }


