package com.fooddivery.dao;

import java.util.List;

import com.fooddilivery.module.OrderHistory;

public interface OrderHistoryDao {
	
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getOrderHistoriesByUser(int userId);	

}
