package com.ecommerce.quantity;

public class AddtoCart {
	private int Id;
	private int CustomerId;
	private int ProductId;
	private int ProductQty;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getProductQty() {
		return ProductQty;
	}
	public void setProductQty(int productQty) {
		ProductQty = productQty;
	}
	
}