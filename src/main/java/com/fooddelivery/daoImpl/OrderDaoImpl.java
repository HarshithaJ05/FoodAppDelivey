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

import com.food.util.OrderIdGenerator;
import com.fooddilivery.module.Order;
import com.fooddivery.dao.OrderDao;

public class OrderDaoImpl implements OrderDao{
	
	private static Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	Statement statement = null;
	
	private final static String INSERT_QUERY = "insert into `order`(`OrderID`,`UserID`, `RestuarantID`, `OrderDate`, `TotalAmount`, `Status`, `PaymentMode`)values(?,?,?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `order`  where `OrderID`=?";
	private final static String DELETE_QUERY ="delete from `order` where `OrderID`=? ";
	private final static String UPDATE_QUERY ="update `order` set `UserID`=?, `RestuarantID`=?, `OrderDate`=?,`TotalAmount`=?, `Status`=?,`PaymentMode`=? where `OrderID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `order`";
	
	public OrderDaoImpl() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","root");			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void addOrder(Order order) {
		
		
		try {
			OrderIdGenerator orderIdGenerator = new OrderIdGenerator();
	        int generatedOrderId = orderIdGenerator.generateOrderId();
	        order.setOrderId(generatedOrderId);

            prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setInt(1, order.getOrderId());
            prepareStatement.setInt(2, order.getUserId());
            prepareStatement.setInt(3, order.getRestuarantId());
            prepareStatement.setDate(4, new java.sql.Date(order.getOrderDate().getTime()));
            prepareStatement.setDouble(5, order.getTotalAmount());
            prepareStatement.setString(6, order.getStatus());
            prepareStatement.setString(7, order.getPayementMode());

            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
	}

	@Override
	public Order getOrder(int orderId) {
		
		try {
			
			
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, orderId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  int orderId1=res.getInt("OrderID");
				  int userId= res.getInt("UserID");
				  int restId=res.getInt("RestuarantID");
				  Date orderDate=res.getDate("OrderDate");
				  Double totalAmount =res.getDouble("TotalAmount");
				  String status=res.getString("Status");
				  String payment= res.getString("PaymentMode");
				  return new Order(orderId1, userId, restId, orderDate, restId, status, payment);
				  
				  
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrder(Order order) {
			
			try {
				 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				 prepareStatement.setInt(1,order.getUserId());
				 prepareStatement.setInt(2, order.getRestuarantId());
				 prepareStatement.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
				 prepareStatement.setDouble(4, order.getTotalAmount());
				 prepareStatement.setString(5, order.getStatus());
				 prepareStatement.setString(6, order.getPayementMode());
				   prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
		
		
		
		
	}

	@Override
	public void deleteOrder(int orderId) {
		int i =0;
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1,orderId);
			   i = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<Order> getAllOrderByUser(int userId) {
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  int orderId=res.getInt("orderId1");
				  int userId1= res.getInt("UserID");
				  int restId=res.getInt("RestuarantID");
				  Date orderDate=res.getDate("OrderDate");
				  Double totalAmount =res.getDouble("TotalAmount");
				  String status=res.getString("Status");
				  String payment= res.getString("PaymentMode");
				  Order order = new Order(orderId, userId1, restId, orderDate, restId, status, payment);
				  orderList.add(order);
				  
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return orderList;
	}

}
