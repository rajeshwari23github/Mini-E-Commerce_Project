package com.ecommers.connectivity;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Calculation {
	public void calculate() {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
             Scanner  scr  = new Scanner(System.in);
             System.out.println("Enter product id : ");
             int Productid = scr.nextInt();
             System.out.println("Enter product quantity :");
             int Productquantity = scr.nextInt();
             ps = con.prepareStatement("SELECT Price FROM product WHERE Productid =  "+Productid);
           ResultSet rs1 = ps.executeQuery();
             int i = 0;
             if (rs1.next()) {
            	    i = rs1.getInt(1);
            	} else {
            	    System.out.println("No rows found for the given product id");
            	}
             ps1 = con.prepareStatement("SELECT Productquantity FROM addcart WHERE Productid = "
+Productid+" and Productquantity = "+Productquantity);
             ResultSet rs2 = ps1.executeQuery();
           //  ResultSet rs2 = ps1.executeQuery();
             int j = 0;
//             if (rs2.next()) {
//            	    j = rs2.getInt(1);
//            	} else {
//            	    System.out.println("No rows found for the given product id and quantity in the addcart table");
//            	}
             while(rs2.next()) {
            	    j = rs2.getInt(1);
            	}
             int totalColumns = i * j;
             System.out.println("Total number of columns: " + totalColumns);

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

    public static void main(String[] args) {
        Calculation cc = new Calculation();
        cc.calculate();
        System.out.println("Calculation");

    }

}
