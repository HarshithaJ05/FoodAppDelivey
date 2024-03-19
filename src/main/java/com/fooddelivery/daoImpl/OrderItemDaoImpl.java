package com.fooddelivery.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddilivery.module.Menu;
import com.fooddilivery.module.Order;
import com.fooddilivery.module.OrderItem;
import com.fooddivery.dao.OrderDao;
import com.fooddivery.dao.OrderItemDao;

public class OrderItemDaoImpl implements  OrderItemDao{
	private static Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	
	private final static String INSERT_QUERY = "insert into `orderitem`(`OrderID`, `MenuID`, `Quantity`, `TotalPrice`)values(?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `orderitem`  where `OrderItemID`=?";
	private final static String DELETE_QUERY ="delete from `orderitem` where `OrderItemID`=? ";
	private final static String UPDATE_QUERY ="update `orderitem` set `OrderID`=?, `MenuID`=?, `Quantity`=?,`TotalPrice`=? where `OrderItemID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `orderitem` where `OrderID`= ?";
	
	public OrderItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","root");			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addOrderItem(OrderItem orderItem) {
			try {
				 prepareStatement = connection.prepareStatement(INSERT_QUERY);
				 prepareStatement.setInt(1,orderItem.getOrderId());
				 prepareStatement.setInt(2, orderItem.getMenuId());
				 prepareStatement.setInt(3, orderItem.getQuantity());
				 prepareStatement.setDouble(4,orderItem.getTotalPrice());
				  prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		try {
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, orderItemId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  int orderItemId1=res.getInt("OrderItemID");
				  int orderId= res.getInt("OrderID");
				  int menuId=res.getInt("MenuID");
				  int quality =res.getInt("Quantity");
				  Double totalPrice =res.getDouble("TotalPrice");
				  return new OrderItem(orderItemId1, orderId, menuId, menuId, quality);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
			
			try {
				 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				 prepareStatement.setInt(1,orderItem.getOrderId());
				 prepareStatement.setInt(2, orderItem.getMenuId());
				 prepareStatement.setInt(3, orderItem.getQuantity());
				 prepareStatement.setDouble(4, orderItem.getTotalPrice());
				 prepareStatement.setInt(5, orderItem.getOrderIteamId());
				  prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
		
		
		
		
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1,orderItemId);
			  prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}

	@Override
	public List<OrderItem> getOrderItemsByOrder(int orderId) {
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		try {
			prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			 prepareStatement.setInt(1, orderId);
			  res = prepareStatement.executeQuery();
			
			  while(res.next()) {
				  int orderItemId1=res.getInt("OrderItemID");
				  int orderId1= res.getInt("OrderID");
				  int menuId=res.getInt("MenuID");
				  int quality =res.getInt("Quantity");
				  Double totalPrice =res.getDouble("TotalPrice");
				  OrderItem orderItem = new OrderItem(orderItemId1, orderId1, menuId, menuId, quality);
				  orderItemList.add(orderItem);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return orderItemList;
	}
	
	
	
	
	
	


}
