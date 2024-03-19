package com.fooddilivery.module;

public class OrderItem {
	
	private int orderIteamId;
	private int orderId;
	private int menuId;
	private int quantity;
	private double totalPrice;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int orderIteamId, int orderId, int menuId, int quantity, double totalPrice) {
		super();
		this.orderIteamId = orderIteamId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getOrderIteamId() {
		return orderIteamId;
	}

	private void setOrderIteamId(int orderIteamId) {
		this.orderIteamId = orderIteamId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	

}
