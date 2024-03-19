package com.fooddelivery.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddilivery.module.OrderHistory;
import com.fooddilivery.module.OrderItem;
import com.fooddivery.dao.OrderHistoryDao;

public class OrderHistoryDaoImpl implements OrderHistoryDao {
	
	private static Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	Statement statement = null;
	
	private final static String INSERT_QUERY = "insert into `orderhistory`( `UserID`, `OrderID`, `OrderDate`, `TotalAmount`, `Status`)values(?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `orderhistory`  where `OrderHistoryID`=?";
	private final static String DELETE_QUERY ="delete from `orderhistory` where `OrderHistoryID`=? ";
	private final static String UPDATE_QUERY ="update `orderhistory` set `UserID`=?, `OrderID`=?, `OrderDate`=?,`TotalAmount`=?,Status`=? where `OrderHistoryID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `orderhistory` ";
	
	
	
	public OrderHistoryDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 prepareStatement.setInt(1,orderHistory.getUserId());
			 prepareStatement.setInt(2, orderHistory.getOrderId());
			 prepareStatement.setDate(3, new java.sql.Date(orderHistory.getOrderDate().getTime()));
			 prepareStatement.setDouble(4,orderHistory.getTotalAmount());
			 prepareStatement.setString(5,orderHistory.getStatus());
			  int i = prepareStatement.executeUpdate();
			  System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		try {
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, orderHistoryId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  int orderHistoryId1=res.getInt("OrderHistoryID");
				  int userId= res.getInt("UserID");
				  int orderId=res.getInt("OrderID");
				  Date orderDate =res.getDate("OrderDate");
				  Double totalAmount =res.getDouble("TotalAmount");
				  String status =res.getString("Status");
				  return new OrderHistory(orderHistoryId1, userId, orderId, orderDate, orderId, status);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		 int i=0;
			
			try {
				 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				 prepareStatement.setInt(1,orderHistory.getUserId());
				 prepareStatement.setInt(2, orderHistory.getOrderId());
				 prepareStatement.setDate(3, new java.sql.Date(orderHistory.getOrderDate().getTime()));
				 prepareStatement.setDouble(4, orderHistory.getTotalAmount());
				 prepareStatement.setString(5, orderHistory.getStatus());
				 prepareStatement.setInt(5, orderHistory.getOrderHistoryId());
				  i = prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		int i =0;
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1,orderHistoryId);
			   i = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<OrderHistory> getOrderHistoriesByUser(int userId) {
		ArrayList<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
		try {
			
			statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  int orderHistoryId=res.getInt("OrderHistoryID");
				  int userId1= res.getInt("UserID");
				  int orderId=res.getInt("OrderID");
				  Date orderDate =res.getDate("OrderDate");
				  Double totalAmount =res.getDouble("TotalAmount");
				  String status =res.getString("Status");
				  OrderHistory orderHistory = new OrderHistory(orderHistoryId, userId1, orderId, orderDate, orderId, status);
				  orderHistoryList.add(orderHistory);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderHistoryList;
	}
}
