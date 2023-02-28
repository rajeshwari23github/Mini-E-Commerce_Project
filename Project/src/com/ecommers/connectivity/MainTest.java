package com.ecommers.connectivity;

import java.util.Scanner;

public class MainTest {
public static void main(String[] args) throws Exception {
	Banner  banner = new Banner();
	banner.getView();
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter 1 for login / 2 for sign up/3 for admin");
	int input = scanner.nextInt();
	if(input == 1) {
		CustomerLogin_Connectivity.getCustomerLogin(scanner);
	}else if (input == 2) {
		  RegistrationForm.getCustomerInfo(scanner);
	}else if (input ==3) {
		AdminInfo  ai = new AdminInfo();
		ai.CustomerDetails();
		ai.getCartDetails(scanner);
		ai.getProductDetails(scanner);
	}
	else {
		System.out.println("Please select valid option");
	}

	//product
	ProductConnectivity  productConnectivity = new ProductConnectivity();
	productConnectivity.getName();
	//cart
		System.out.println("----------------- Welcome to cart ---------------");
			CartConnectivity cartConnectivity = new CartConnectivity();
			cartConnectivity.getValues(scanner);
			System.out.println("-----------------------------------------TOTAL AMOUNT OF PRODUCT---------------------------------------------");
			Column_Calculation cc = new Column_Calculation();
			cc.calculate(scanner);
	//	System.out.println("VISIT AGAIN AND AGAIN");
		
		System.out.println("---------------------------Thank you for visit----------------------");
       }

}
