package com.ecommerce.quantity;

public class CustomerLogin {
	private String CustomerMail;
	private String Password;
	
	public CustomerLogin( Customer customer) {
		this.CustomerMail = customer.getCustomerMail();
		this.Password = customer.getPassword();
	}
	public CustomerLogin() {}
	public CustomerLogin(String CustomerMail, String Password) {
		this.CustomerMail = CustomerMail;
		this.Password = Password;
	}
	public String getCustomerMail() {
		return CustomerMail;
	}
	public void setCustomerMail(String customerMail) {
		CustomerMail = customerMail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
