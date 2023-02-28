package com.ecommerce.quantity;

public class Customer_Product {
	private String ProductName;
    private int Quantity;
    private int Price;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		this.ProductName = productName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		this.Price = price;
	}
	@Override
	public String toString() {
		return "Customer_Product [ProductName=" + ProductName + ", Quantity=" + Quantity + ", Price=" + Price + "]";
	}
}
