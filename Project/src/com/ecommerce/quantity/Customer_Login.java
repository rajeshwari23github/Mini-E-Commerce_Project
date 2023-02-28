package com.ecommerce.quantity;

public class Customer_Login {
		private String customerEmail;
		private String customerPass;

		public Customer_Login() {
			
		}

		public Customer_Login(Customer customer) {
			this.customerEmail = customer.getCustomerMail();
			this.customerPass = customer.getPassword();
		}

		public Customer_Login(String customerEmail, String customerPass) {
			this.customerEmail = customerEmail;
			this.customerPass = customerPass;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getCustomerPass() {
			return customerPass;
		}

		public void setCustomerPass(String customerPass) {
			this.customerPass = customerPass;
		}

}
