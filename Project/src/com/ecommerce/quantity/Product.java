package com.ecommerce.quantity;

public class Product {
	private int ProductId;
	private String ProductName;
	private String Description;
	private int Price;
	private int Quantity;

	public Product(String ProductName, String Description, int Price, int Quantity) {
		this.ProductName = ProductName;
		this.Description = Description;
		this.Price = Price;
		this.Quantity = Quantity;
	}

	

	public int getId() {
		return ProductId;
	}

 	public void setId(int id) {
		this.ProductId = id;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public String getProductDescription() {
		return Description;
	}

	public void setProductDescription(String productDescription) {
		this.Description = productDescription;
	}

	public int getProductPrice() {
		return Price;
	}

	public void setProductPrice(int productPrice) {
		this.Price = productPrice;
	}

	public int getProductQuantity() {
		return Quantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.Quantity = productQuantity;
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", Description=" + Description
				+ ", Price=" + Price + ", Quantity=" + Quantity + "]";
	}


}
